package com.chaoxing.filemanagement.service;

import com.chaoxing.filemanagement.common.ServerResponse;
import com.chaoxing.filemanagement.po.Dept;
import com.sun.org.apache.xpath.internal.operations.String;

import java.util.List;

/**
 * Create by tachai on 2019-10-22 10:17
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public interface DeptService {

    ServerResponse<String> addDept(Dept dept);

    ServerResponse<String> deleteDeptById(Integer id);

    ServerResponse<String> updateDept(Dept dept);

    ServerResponse<Dept> selectDeptById(Integer id);
    // 根据parentId 查询list
    ServerResponse<List<Dept>> listDept(Integer id);
}
