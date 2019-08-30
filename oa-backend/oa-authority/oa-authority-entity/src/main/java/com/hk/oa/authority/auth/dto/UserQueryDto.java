package com.hk.oa.authority.auth.dto;

import com.hk.oa.common.msg.QueryDto;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @program: hk-oa-master
 * @description: 用户查询
 * @author: 陈家乐
 * @create: 2019-08-30 10:00
 **/
@Data
@ApiModel(value = "用户列表查询请求体", description = "用户列表查询请求体")
public class UserQueryDto extends QueryDto {
}
