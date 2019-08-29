package com.hk.oa.authority.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @program: hk-oa-master
 * @description: 用户登录参数
 * @author: 陈家乐
 * @create: 2019-08-26 10:50
 **/
@Data
@ApiModel(value = "登录请求", description = "登录请求体")
public class UserLoginDto {
    /**
     * 账号
     */
    @NotEmpty(message = "账号不能为空")
    @ApiModelProperty(value = "账号", required = true)
    private String account;

    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    @ApiModelProperty(value = "密码", required = true)
    private String password;
}
