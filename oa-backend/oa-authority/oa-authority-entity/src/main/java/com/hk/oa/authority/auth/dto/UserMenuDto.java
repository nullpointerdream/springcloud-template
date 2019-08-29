package com.hk.oa.authority.auth.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @program: hk-oa-master
 * @description: 查询用户菜单请求体
 * @author: 陈家乐
 * @create: 2019-08-28 13:49
 **/
@Data
@ApiModel(value = "查询用户菜单请求体", description = "查询用户菜单请求体")
public class UserMenuDto {
    private Integer userId;
}
