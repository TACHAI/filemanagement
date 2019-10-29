package com.chaoxing.filemanagement.vo;

import lombok.Data;

import java.util.List;

/**
 * Create by tachai on 2019-10-29 13:43
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Data
public class DeptVO {
    private Integer id;
    private String deptName;
    private List<DeptVO> deptVO;
}
