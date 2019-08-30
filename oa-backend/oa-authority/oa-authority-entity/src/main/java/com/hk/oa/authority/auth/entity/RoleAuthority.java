package com.hk.oa.authority.auth.entity;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "auth_role_authority")
@Builder
public class RoleAuthority {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 资源id
     */
    @Column(name = "authority_id")
    private Integer authorityId;

    /**
     * 权限类型{MENU:菜单;RESOURCE:资源;}
     */
    @Column(name = "authority_type")
    private String authorityType;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 创建人
     */
    @Column(name = "create_user")
    private Integer createUser;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取资源id
     *
     * @return authority_id - 资源id
     */
    public Integer getAuthorityId() {
        return authorityId;
    }

    /**
     * 设置资源id
     *
     * @param authorityId 资源id
     */
    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    /**
     * 获取权限类型{MENU:菜单;RESOURCE:资源;}
     *
     * @return authority_type - 权限类型{MENU:菜单;RESOURCE:资源;}
     */
    public String getAuthorityType() {
        return authorityType;
    }

    /**
     * 设置权限类型{MENU:菜单;RESOURCE:资源;}
     *
     * @param authorityType 权限类型{MENU:菜单;RESOURCE:资源;}
     */
    public void setAuthorityType(String authorityType) {
        this.authorityType = authorityType;
    }

    /**
     * 获取角色id
     *
     * @return role_id - 角色id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     *
     * @param roleId 角色id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }


}