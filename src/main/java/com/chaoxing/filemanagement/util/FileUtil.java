package com.chaoxing.filemanagement.util;

import com.chaoxing.filemanagement.common.ResponseString;
import com.chaoxing.filemanagement.common.ServerResponse;
import com.chaoxing.filemanagement.common.cons.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;

/**
 * @ClassName FileUtil
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2019-06-11 10:23
 **/
public class FileUtil {

    public static final String SEPARATOR = "/";

    /**
     * 从文件中读取内容
     * @param filePath
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String readFileBanner(String filePath) throws FileNotFoundException, IOException {
        String banner = FileUtil.readFileBanner(new FileInputStream(filePath));
        return banner;
    }

    /**
     * 从文件中读取内容
     * @param file
     * @return
     * @throws IOException
     */
    public static String readFileBanner(File file) throws IOException {
        String banner = FileUtil.readFileBanner(new FileInputStream(file));
        return banner;
    }

    /**
     * 从文件中读取内容
     * @param fileInputStream
     * @return
     * @throws IOException
     */
    public static String readFileBanner(FileInputStream fileInputStream) throws IOException {
        StringBuilder banner = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, ResponseString.DEFAULT_CHARSET));

        String line = bufferedReader.readLine();

        while (null != line) {
            banner.append(line);
            line = bufferedReader.readLine();
        }

        bufferedReader.close();

        return banner.toString();
    }




    /**
     * 覆盖文件内容
     * @param filePath
     * @param banner
     * @throws IOException
     */
    public static void updateFileBanner(String filePath, String banner) throws IOException {
        String sysFilePath = FilePathUtil.getWebProjectRootFilePath() + filePath;
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sysFilePath)));
        bufferedWriter.write(banner);
        bufferedWriter.flush();
        bufferedWriter.close();
    }


    /**
     * 根据给出的路径，删除文件
     * @param filePath
     */
    public static void deleteFile(String filePath) {
        String sysFilePath = FilePathUtil.getWebProjectRootFilePath() + filePath;

        File file = new File(sysFilePath);

        if (!file.exists()) {
            return ;
        }

        file.delete();
    }


    /**
     * 上传单一文件处理方法
     * @param file
     * @param fileType
     * @return
     * @throws IOException
     */
    public static ServerResponse<String> uploadFile(MultipartFile file, FileType fileType, String realPath)  {
        // 若上传文件为空或文件类型为空，返回错误信息

        if (null == file || file.isEmpty() || null == fileType) {
            return ServerResponse.createByErrorMessage(ExceptionCons.UPLOAD_FILE_IS_EMPTY);
        }

        String suffix = FileUtil.getSuffix( file.getOriginalFilename());
        String fileName = file.getOriginalFilename().replace(suffix,"");
        String newFileName =fileName +DateUtils.dateToStr(new Date(),DateUtils.DATENAME_FORMAT)+ suffix;
        String webProjectRootFilePath = PropertiesUtil.getProperty("file.localDir");
        StringBuilder pathStringBuilder = new StringBuilder(webProjectRootFilePath);
        StringBuilder pathStringBuilder2 = new StringBuilder(PropertiesUtil.getProperty("fore.path"));
        pathStringBuilder.append(realPath);

        switch (fileType) {
            case Txt:
                pathStringBuilder.append(FileCons.TXT_UPLOAD_FILE_PATH);
                pathStringBuilder2.append(FileCons.TXT_UPLOAD_FILE_PATH);
                break;
            case Book:
                pathStringBuilder.append(FileCons.BOOK_UPLOAD_FILE_PATH);
                pathStringBuilder2.append(FileCons.BOOK_UPLOAD_FILE_PATH);
                break;
            case Image:
                pathStringBuilder.append(FileCons.IMAGE_UPLOAD_FILE_PATH);
                pathStringBuilder2.append(FileCons.IMAGE_UPLOAD_FILE_PATH);
                break;
            case Video:
                pathStringBuilder.append(FileCons.VIDEO_UPLOAD_FILE_PATH);
                pathStringBuilder2.append(FileCons.VIDEO_UPLOAD_FILE_PATH);
                break;
            default:
                pathStringBuilder.append(FileCons.DEFAULT_UPLOAD_FILE_PATH);
                pathStringBuilder2.append(FileCons.DEFAULT_UPLOAD_FILE_PATH);
                break;
        }

        pathStringBuilder.append(FileUtil.SEPARATOR);
        pathStringBuilder.append(newFileName);
        //pathStringBuilder.append(suffix);
        pathStringBuilder2.append(FileUtil.SEPARATOR);
        pathStringBuilder2.append(newFileName);


        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(pathStringBuilder.toString())));
            InputStream in = file.getInputStream();
            byte[] buff = new byte[2048];
            int bytesRead=0;
            while ((bytesRead=in.read(buff))>0) {
                bufferedOutputStream.write(buff, 0, bytesRead);
            }
            // bufferedOutputStream.write(file.getBytes());
            in.close();
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读取异常:"+e.getMessage());
        }finally {

        }

//        return ServerResponse.createBySuccess(pathStringBuilder2.toString(),ResponseString.UPLOAD_FILE_SUCCESS);
        return ServerResponse.uploadBySuccess(pathStringBuilder2.toString(), ResponseString.UPLOAD_FILE_SUCCESS,pathStringBuilder2.toString());

    }



    /**
     * 获取文件的后缀名
     * @param str
     * @return
     */
    public static String getSuffix(String str) {
        String temp = str.substring(str.lastIndexOf("."));
        return temp;
    }


    /**
     * 获取文件名（去除后缀名）
     * @param fileName
     * @return
     */
    public static String getFileNameDelSuffix(String fileName) {
        String name = fileName.substring(0, fileName.lastIndexOf("."));
        return name;
    }

}
