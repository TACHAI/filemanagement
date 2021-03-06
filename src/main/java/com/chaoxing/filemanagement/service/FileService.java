package com.chaoxing.filemanagement.service;

import com.chaoxing.filemanagement.common.ServerResponse;
import com.chaoxing.filemanagement.po.Fileaddress;
import com.chaoxing.filemanagement.vo.FileVO;

import java.util.List;

/**
 * Create by tachai on 2019-10-22 11:37
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public interface FileService {

    ServerResponse<String> addFile(Fileaddress fileaddress);

    ServerResponse<String> deleteById(Integer id);

    ServerResponse<String> updateFile(Fileaddress fileaddress);

    ServerResponse<Fileaddress> selectById(Integer id);

    ServerResponse<List<FileVO>> selectByDeptId(Integer Id);

    ServerResponse<List<FileVO>> selectList();
}
