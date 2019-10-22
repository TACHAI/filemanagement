package com.chaoxing.filemanagement.vo;

import lombok.Data;

/**
 * Create by tachai on 2019-10-22 14:22
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Data
public class PageVO<T> {
    /**
     * 总数
     */
    private long total;

    /**
     * 数据
     */
    private T rows;
}
