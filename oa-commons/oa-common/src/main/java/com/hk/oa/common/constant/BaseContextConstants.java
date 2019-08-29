package com.hk.oa.common.constant;

/**
 * @program: hk-oa-master
 * @description: 常量
 * @author: 陈家乐
 * @create: 2019-08-23 16:08
 **/

public class BaseContextConstants {
    /**
     *
     */
    public static final String TOKEN_NAME = "token";
    /**
     *
     */
    public static final String JWT_KEY_USER_ID = "userId";
    /**
     *
     */
    public static final String JWT_KEY_NAME = "name";
    /**
     *
     */
    public static final String JWT_KEY_ACCOUNT = "account";

    /**
     * 组织id
     */
    public static final String JWT_KEY_DEP_ID = "departmentId";
    /**
     * 岗位id
     */
    public static final String JWT_KEY_ROLE_ID = "roleId";

    /**
     * token异常
     */
    public static final Integer EX_TOKEN_ERROR_CODE = 40201;

    public static final int EX_TOKEN_FORBIDDEN_CODE = 40301;

    /**接口请求正常状态码**/
    public static final String SUCCESS_CODE = "200";

    /** 失败状态**/
    public static final String FAIL_STATE = "0";
    /** 成功状态**/
    public static final String SUCCESS_STATE = "1";

}
