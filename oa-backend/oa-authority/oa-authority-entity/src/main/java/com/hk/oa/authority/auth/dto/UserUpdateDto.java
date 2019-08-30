package com.hk.oa.authority.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @program: hk-oa-master
 * @description: 用户修改请求体
 * @author: 陈家乐
 * @create: 2019-08-30 09:50
 **/
@Data
@ApiModel(value = "用户更新请求体", description = "用户更新请求体")
public class UserUpdateDto {

    @NotNull(message = "Id不能为空")
    @ApiModelProperty(value = "id", required = true)
    private Integer id;

    /**
     * 账号
     */
    @NotEmpty(message = "账号不能为空")
    @ApiModelProperty(value = "账号", required = true)
    private String account;

    /**
     * 姓名
     */
    @NotEmpty(message = "姓名不能为空")
    @ApiModelProperty(value = "姓名", required = true)
    private String name;

    /**
     * 部门ID
     * #c_core_org
     */
    @NotNull(message = "部门不能为空")
    @ApiModelProperty(value = "部门", required = true)
    private Integer departmentId;

    /**
     * 角色ID
     *
     */
    @NotNull(message = "角色不能为空")
    @ApiModelProperty(value = "角色", required = true)
    private Integer roleId;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 性别
     * #Sex{W:女;M:男}
     */
    private String sex;

    /**
     * 照片
     */
    private String photo;

    /**
     * 工作描述
     * 比如：  市长、管理员、局长等等   用于登陆展示
     */
    private String workDescribe;


    /**
     * 备注
     */
    private String remark;



    /**
     * 更新人id
     */
    private Integer updateUser;

    /**
     * 更新时间
     */
    private Date updateTime;
}
