package com.hk.oa.authority.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @program: hk-oa-master
 * @description: 角色修改请求体
 * @author: 陈家乐
 * @create: 2019-08-30 09:50
 **/
@Data
@ApiModel(value = "角色更新请求体", description = "角色更新请求体")
public class RoleUpdateDto {

    @NotNull(message = "Id不能为空")
    @ApiModelProperty(value = "id", required = true)
    private Integer id;

    /**
     * 角色名称
     */
    @NotEmpty(message = "角色名称不能为空")
    @ApiModelProperty(value = "角色名称", required = true)
    private String name;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 功能描述
     */
    @ApiModelProperty(value = "角色描述")
    private String describe;

    /**
     * 是否启用
     */
    private Boolean isEnable;

    /**
     * 数据权限类型{1,全部;2,本级;3,本级以及子级;4,自定义;5,个人;}
     */
    @ApiModelProperty(value = "数据权限类型{1,全部;2,本级;3,本级以及子级;4,自定义;5,个人;}")
    private Integer dsType;



    /**
     * 更新人id
     */
    private Integer updateUser;

    /**
     * 更新时间
     */
    private Date updateTime;
}
