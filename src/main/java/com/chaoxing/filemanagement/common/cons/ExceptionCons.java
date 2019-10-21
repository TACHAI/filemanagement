package com.chaoxing.filemanagement.common.cons;

/**
 * @ClassName ExceptionCons
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2019-06-06 17:16
 **/
public class ExceptionCons {
    /**
     * "$Field"
     */
    public static final String FIELD_TAB = "$Field";

    /**
     * "$Id"
     */
    public static final String ID_TAB = "$Id";

    /**
     * "$Class"
     */
    public static final String CLASS_TAB = "$Class";

    /**
     * "$Role"
     */
    public static final String ROLE_TAB = "$Role";

    /**
     * "id:\"fieldName\" in Class:\"clasName\" can't be null!\n";
     */
    public static final String ID_NULL_EXCEPTION_MESSAGE = "Id:\"$Id\" in Class:\"$Class\" can't be null!\n";

    /**
     * "Field:\"fieldName\" in Class:\"clasName\" can't be null!\n"
     */
    public static final String FIELD_NULL_EXCEPTION_MESSAGE = "Field:\"$Field\" in Class:\"$Class\" can't be null!\n";;

    /**
     * "Can't delete role:\"$Role\"! case has user is \"\" role."
     */
    public static final String CANT_DELETE_ROLE_CASE_HAS_USER = "Can't delete role:\"$Role\"! case has user is \"\" role.";

    /**
     * "权限名不可重复"
     */
    public static final String PERMISSION_NAME_CANT_REPEAT = "权限名不可重复";

    /**
     * "账户不可重复"
     */
    public static final String ACCOUNT_CANT_REPEAT = "账户不可重复";

    /**
     * "账号或密码错误"
     */
    public static final String ACCOUNT_PASSWORD_ERROR = "账号或密码错误";

    /**
     * "找不到要修改的对象"
     */
    public static final String UPDATE_OBJECT_NOT_FOUND = "找不到要修改的对象";

    /**
     * "重复数据"
     */
    public static final String DATA_REPEAT = "重复数据";

    /**
     * "要删除的数据不存在"
     */
    public static final String DELETE_DATA_NOT_FOUND = "要删除的数据不存在";

    /**
     * "无操作权限"
     */
    public static final String NO_AUTH = "无操作权限";

    /**
     * "未知异常"
     */
    public static final String UNKNOW_ERROR = "未知异常";

    /**
     * "非法操作"
     */
    public static final String ILLEGALITY_ERROR = "非法操作";

    /**
     * "找不到页面"
     */
    public static final String NOT_FOUND_ERROR = "找不到页面";

    /**
     * "参数非法"
     */
    public static final String PARAMETER_ILLEGAL = "参数非法";

    /**
     * "上传文件为空"
     */
    public static final String UPLOAD_FILE_IS_EMPTY = "上传文件为空";

    /**
     * "参数长度不符合规则"
     */
    public static final String FIELD_TOO_LENGTH = "参数长度不符合规则";
}
