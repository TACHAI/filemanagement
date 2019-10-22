package com.chaoxing.filemanagement.service.impl;

import com.chaoxing.filemanagement.common.ResponseString;
import com.chaoxing.filemanagement.common.ServerResponse;
import com.chaoxing.filemanagement.dao.DeptMapper;
import com.chaoxing.filemanagement.po.Dept;
import com.chaoxing.filemanagement.service.DeptService;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Create by tachai on 2019-10-22 10:17
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptDao;

    @Override
    public ServerResponse<String> addDept(Dept dept) {
        int res = deptDao.updateByPrimaryKeySelective(dept);
        if(res>0){
            return ServerResponse.createBySuccessMessage(ResponseString.ADD_SUCCESS);
        }
        return ServerResponse.createByErrorMessage(ResponseString.ADD_FAIL);
    }

    @Override
    public ServerResponse<String> deleteDeptById(Integer id) {
        // Dept dept = deptDao.selectByPrimaryKey(id);
        int res = deptDao.deleteByPrimaryKey(id);
        if(res>0){
            return ServerResponse.createBySuccessMessage(ResponseString.DELETE_SUCCESS);
        }
        return ServerResponse.createByErrorMessage(ResponseString.DELETE_FAIL);
    }

    @Override
    public ServerResponse<String> updateDept(Dept dept) {
        int res =deptDao.updateByPrimaryKeySelective(dept);
        if(res>0){
            return ServerResponse.createBySuccessMessage(ResponseString.UPDATE_SUCCESS);
        }
        return ServerResponse.createByErrorMessage(ResponseString.UPDATE_FAIL);
    }

    @Override
    public ServerResponse<Dept> selectDeptById(Integer id) {
        Dept dept=deptDao.selectByPrimaryKey(id);
        if(dept!=null){
            return ServerResponse.createBySuccess(dept,ResponseString.SELECT_SUCCESS);
        }
        return ServerResponse.createByErrorMessage(ResponseString.DATA_IS_EMPTY);
    }

    @Override
    public ServerResponse<List<Dept>> listDept(Integer id) {
        List<Dept> list = deptDao.selectList(id);

        return null;
    }
}
