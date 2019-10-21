package com.chaoxing.filemanagement.common;

/**
 * <pre>
 *     异常返回码枚举接口
 * </pre>
 * @ClassName IResponseEnum
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2019-07-04
 */

public interface IResponseEnum {
    /**
     * 获取返回码
     * @return 返回码
     */
    int getCode();

    /**
     * 获取返回信息
     * @return 返回信息
     */
    String getMessage();
}
