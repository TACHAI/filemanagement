package com.chaoxing.filemanagement.service.impl;

import com.chaoxing.filemanagement.common.ResponseString;
import com.chaoxing.filemanagement.common.ServerResponse;
import com.chaoxing.filemanagement.dao.DeptMapper;
import com.chaoxing.filemanagement.dao.FileaddressMapper;
import com.chaoxing.filemanagement.po.Dept;
import com.chaoxing.filemanagement.po.Fileaddress;
import com.chaoxing.filemanagement.service.FileService;
import com.chaoxing.filemanagement.vo.FileVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Create by tachai on 2019-10-22 11:37
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Service("FileServiceImpl")
public class FileServiceImpl implements FileService {

    private String temp;

    @Autowired
    private FileaddressMapper fileDao;
    @Autowired
    private DeptMapper deptDao;
    
    @Override
    public ServerResponse<String> addFile(Fileaddress fileaddress) {
        fileaddress.setInsertTime(new Date());
        fileaddress.setIsDelete(ResponseString.UN_DELETE);
        int res = fileDao.insert(fileaddress);
        if(res>0){
            return ServerResponse.createBySuccessMessage(ResponseString.ADD_SUCCESS);
        }
        return ServerResponse.createByErrorMessage(ResponseString.ADD_FAIL);
    }

    @Override
    public ServerResponse<String> deleteById(Integer id) {
        Fileaddress fileaddress=fileDao.selectByPrimaryKey(id);
        fileaddress.setIsDelete(ResponseString.IS_DELETE);
        int res = fileDao.updateByPrimaryKeySelective(fileaddress);
        if(res>0){
            return ServerResponse.createBySuccessMessage(ResponseString.DELETE_SUCCESS);
        }
        return ServerResponse.createByErrorMessage(ResponseString.DELETE_FAIL);
    }

    @Override
    public ServerResponse<String> updateFile(Fileaddress fileaddress) {
        int res = fileDao.updateByPrimaryKeySelective(fileaddress);
        if(res>0){
            return ServerResponse.createBySuccessMessage(ResponseString.UPDATE_SUCCESS);
        }
        return ServerResponse.createByErrorMessage(ResponseString.UPDATE_FAIL);
    }

    @Override
    public ServerResponse<Fileaddress> selectById(Integer id) {
        Fileaddress fileaddress = fileDao.selectByPrimaryKey(id);
        if(fileaddress!=null){
            return ServerResponse.createBySuccess(fileaddress,ResponseString.SELECT_SUCCESS);
        }
        return ServerResponse.createByErrorMessage(ResponseString.DATA_IS_EMPTY);
    }

    @Override
    public ServerResponse<List<FileVO>> selectByDeptId(Integer id) {

        String [] temps = temp.split(",");
        List<FileVO> fileVOS = new ArrayList<>();
        FileVO vo=null;
        for(int i=0;i<temps.length;i++){
            List<Fileaddress> list = fileDao.selectByDeptId(Integer.parseInt(temps[i]));

            for(int j=0;i<list.size();j++){
                vo =new FileVO();
                BeanUtils.copyProperties(list.get(j),vo);
                vo.setDeptName(deptDao.selectByPrimaryKey(list.get(i).getDeptId()).getName());
                fileVOS.add(vo);
            }

        }
        return ServerResponse.createBySuccess(fileVOS,ResponseString.SELECT_SUCCESS);
    }

    @Override
    public ServerResponse<List<FileVO>> selectList() {
        List<FileVO> fileVOS = new ArrayList<>();
        List<Fileaddress> list = fileDao.selectList();
        FileVO fileVO =null;
        for(int i=0;i<list.size();i++){
            fileVO = new FileVO();
            BeanUtils.copyProperties(list.get(i),fileVO);
            fileVO.setDeptName(deptDao.selectByPrimaryKey(list.get(i).getDeptId()).getName());
            fileVOS.add(fileVO);
        }
        return ServerResponse.createBySuccess(fileVOS,ResponseString.SELECT_SUCCESS);
    }


    // 递归查找
    private void getDept(Integer id){
        temp =id+",";

        List<Dept> list = deptDao.selectByParentId(id);
        if(list.size()>0){
            for (int i=0;i<list.size();i++){
                getDept(list.get(i).getId());
            }

        }else {
            return ;
        }
    }




}
