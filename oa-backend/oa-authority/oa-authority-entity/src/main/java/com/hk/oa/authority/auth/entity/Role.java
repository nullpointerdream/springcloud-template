package com.hk.oa.authority.auth.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Table(name = "auth_role")
public class Role {
    @Id
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
    @Column(name = "is_enable")
    private Boolean isEnable;

    /**
     * 数据权限类型{1,全部;2,本级;3,本级以及子级;4,自定义;5,个人;}
     */
    @Column(name = "ds_type")
    @ApiModelProperty(value = "数据权限类型{1,全部;2,本级;3,本级以及子级;4,自定义;5,个人;}")
    private Integer dsType;

    /**
     * 创建人id
     */
    @Column(name = "create_user")
    private Integer createUser;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新人id
     */
    @Column(name = "update_user")
    private Integer updateUser;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取角色名称
     *
     * @return name - 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置角色名称
     *
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取角色编码
     *
     * @return code - 角色编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置角色编码
     *
     * @param code 角色编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取功能描述
     *
     * @return describe - 功能描述
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * 设置功能描述
     *
     * @param describe 功能描述
     */
    public void setDescribe(String describe) {
        this.describe = describe;
    }

    /**
     * 获取是否启用
     *
     * @return is_enable - 是否启用
     */
    public Boolean getIsEnable() {
        return isEnable;
    }

    /**
     * 设置是否启用
     *
     * @param isEnable 是否启用
     */
    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    /**
     * 获取数据权限类型{1,全部;2,本级;3,本级以及子级;4,自定义;5,个人;}
     *
     * @return ds_type - 数据权限类型{1,全部;2,本级;3,本级以及子级;4,自定义;5,个人;}
     */
    public Integer getDsType() {
        return dsType;
    }

    /**
     * 设置数据权限类型{1,全部;2,本级;3,本级以及子级;4,自定义;5,个人;}
     *
     * @param dsType 数据权限类型{1,全部;2,本级;3,本级以及子级;4,自定义;5,个人;}
     */
    public void setDsType(Integer dsType) {
        this.dsType = dsType;
    }

    /**
     * 获取创建人id
     *
     * @return create_user - 创建人id
     */
    public Integer getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建人id
     *
     * @param createUser 创建人id
     */
    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新人id
     *
     * @return update_user - 更新人id
     */
    public Integer getUpdateUser() {
        return updateUser;
    }

    /**
     * 设置更新人id
     *
     * @param updateUser 更新人id
     */
    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}