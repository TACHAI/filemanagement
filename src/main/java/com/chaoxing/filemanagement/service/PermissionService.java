package com.chaoxing.filemanagement.service;

import com.chaoxing.filemanagement.common.ServerResponse;
import com.chaoxing.filemanagement.po.Permissions;

import java.util.List;

/**
 * Create by tachai on 2019-10-25 10:46
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public interface PermissionService {

    ServerResponse<String> addPermission(Permissions permissions);

    ServerResponse<String> deleteById(Integer id);

    ServerResponse<String> updatePermission(Permissions permissions);

    ServerResponse<Permissions> selectById(Integer id);

    ServerResponse<List<Permissions>> selectListByDeptId(Integer deptId);
}
