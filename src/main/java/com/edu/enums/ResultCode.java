package com.edu.enums;

/**
 * 返回的状态码
 *
 * @author ham
 */
public enum ResultCode {
    // 只针对列表
    TABLE_SUCCESS(0,"操作成功"),

    NO_ILLEGAL(0,"非法操作"),

    // 成功
    SUCCESS(1,"操作成功"),

    // 失败
    FAILURE(2,"系统异常"),
    RARAM_IS_BLANK(3,"请求参数为空"),
    PASSWD_NOT_EQ(4,"新密码和确认密码不一致"),
    RARAM_IS_INVALID(2,"参数无效"),
    RARAM_TYPE_BIND_ERROR(2,"参数类型错误"),
    RARAM_NOT_COMPLETE(2,"参数缺失"),

    // 用户错误
    USER_NOT_LOGED_IN(5,"用户未登录，访问的路径需要验证"),
    OLE_PASSWD_FAILL(4,"原始密码不正确"),
    USER_LOGIN_ERR(4,"用户不存在或密码错误"),
    USER_ACCOUNT_NO_ACTIVE(4,"账号未激活"),
    USER_ACCOUNT_FORBIDDEN(4,"账号已禁用");
    private Integer code;
    private String message;
    ResultCode(Integer code,String message){
        this.code = code;
        this.message = message;
    }
    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
