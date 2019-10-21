package com.chaoxing.filemanagement.util;

import java.util.regex.Pattern;

/**
 * @ClassName FilePathUtil
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2019-06-06 17:12
 **/
public class FilePathUtil {
    public static String getClassesSystemFilePath() {
        String classesSystemFilePath = FilePathUtil.class.getResource("/").getPath();
        return classesSystemFilePath;
    }

    public static String getWebProjectRootFilePath() {
        String classesSystemFilePath = FilePathUtil.getClassesSystemFilePath();

        String pattern = "^/[a-zA-Z]:";
        boolean isWindowsPath = Pattern.matches(pattern, classesSystemFilePath);
        if (isWindowsPath) {
            classesSystemFilePath = classesSystemFilePath.substring(1);
        }

        String webappSystemFilePath =
                classesSystemFilePath.substring(0, classesSystemFilePath.lastIndexOf("/"));
        webappSystemFilePath = webappSystemFilePath.substring(0, webappSystemFilePath.lastIndexOf("/"));
        webappSystemFilePath = webappSystemFilePath.substring(0, webappSystemFilePath.lastIndexOf("/"));

        return webappSystemFilePath;
    }
}
