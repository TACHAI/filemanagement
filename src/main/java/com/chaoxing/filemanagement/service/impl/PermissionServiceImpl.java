package com.chaoxing.filemanagement.service.impl;

import com.chaoxing.filemanagement.common.ResponseString;
import com.chaoxing.filemanagement.common.ServerResponse;
import com.chaoxing.filemanagement.dao.PermissionsMapper;
import com.chaoxing.filemanagement.po.Permissions;
import com.chaoxing.filemanagement.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create by tachai on 2019-10-25 10:49
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionsMapper permissionDao;


    @Override
    public ServerResponse<String> addPermission(Permissions permissions) {

        int res = permissionDao.insert(permissions);
        if(res>0){
            return ServerResponse.createBySuccessMessage(ResponseString.ADD_SUCCESS);
        }
        return ServerResponse.createByErrorMessage(ResponseString.ADD_FAIL);
    }

    @Override
    public ServerResponse<String> deleteById(Integer id) {

        int res = permissionDao.deleteByPrimaryKey(id);
        if(res>0){
            return ServerResponse.createBySuccessMessage(ResponseString.DELETE_SUCCESS);
        }

        return ServerResponse.createByErrorMessage(ResponseString.DELETE_FAIL);
    }

    @Override
    public ServerResponse<String> updatePermission(Permissions permissions) {

        int res = permissionDao.updateByPrimaryKeySelective(permissions);
        if(res>0){
            return ServerResponse.createBySuccessMessage(ResponseString.UPDATE_SUCCESS);
        }
        return ServerResponse.createByErrorMessage(ResponseString.UPDATE_FAIL);
    }

    @Override
    public ServerResponse<Permissions> selectById(Integer id) {
        Permissions permissions = permissionDao.selectByPrimaryKey(id);
        if(permissions!=null){
            return ServerResponse.createBySuccess(permissions,ResponseString.SELECT_SUCCESS);
        }
        return ServerResponse.createByErrorMessage(ResponseString.DATA_IS_EMPTY);
    }

    @Override
    public ServerResponse<List<Permissions>> selectListByDeptId(Integer deptId) {

        List<Permissions> list = permissionDao.selectByDeptId(deptId);
        if(list.size()>0){
            return ServerResponse.createBySuccess(list,ResponseString.SELECT_SUCCESS);
        }
        return ServerResponse.createByErrorMessage(ResponseString.DATA_IS_EMPTY);
    }
}
