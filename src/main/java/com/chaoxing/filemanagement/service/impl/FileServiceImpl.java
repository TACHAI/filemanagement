package com.chaoxing.filemanagement.service.impl;

import com.chaoxing.filemanagement.common.ResponseString;
import com.chaoxing.filemanagement.common.ServerResponse;
import com.chaoxing.filemanagement.dao.FileaddressMapper;
import com.chaoxing.filemanagement.po.Fileaddress;
import com.chaoxing.filemanagement.service.FileService;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Create by tachai on 2019-10-22 11:37
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Service("FileServiceImpl")
public class FileServiceImpl implements FileService {
    @Autowired
    private FileaddressMapper fileDao;
    
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
    public ServerResponse<List<Fileaddress>> selectByDeptId(Integer id) {
        List<Fileaddress> list = fileDao.selectByDeptId(id);
        return ServerResponse.createBySuccess(list,ResponseString.SELECT_SUCCESS);
    }

    @Override
    public ServerResponse<List<Fileaddress>> selectList() {
        List<Fileaddress> list = fileDao.selectList();
        return ServerResponse.createBySuccess(list,ResponseString.SELECT_SUCCESS);    }
}
