package com.hk.oa.authority.auth.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "auth_menu")
public class Menu {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 功能描述
     */
    private String describe;

    /**
     * 资源编码
     */
    private String code;

    /**
     * 是否公开菜单
就是无需分配就可以访问的。所有人可见
     */
    @Column(name = "is_public")
    private Boolean isPublic;

    /**
     * 资源路径
     */
    private String href;

    /**
     * 打开方式
#TargetType{SELF:_self,相同框架;TOP:_top,当前页;BLANK:_blank,新建窗口;PAREN:_parent,父窗口}
     */
    private String target;

    /**
     * 是否启用
     */
    @Column(name = "is_enable")
    private Boolean isEnable;

    /**
     * 排序
     */
    @Column(name = "sort_value")
    private Integer sortValue;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 类型目录 dirt 菜单 menu
     */
    private String type;

    /**
     * 父级菜单id
     */
    @Column(name = "parent_id")
    private Integer parentId;

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
     * 获取菜单名称
     *
     * @return name - 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置菜单名称
     *
     * @param name 菜单名称
     */
    public void setName(String name) {
        this.name = name;
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
     * 获取资源编码
     *
     * @return code - 资源编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置资源编码
     *
     * @param code 资源编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取是否公开菜单
就是无需分配就可以访问的。所有人可见
     *
     * @return is_public - 是否公开菜单
就是无需分配就可以访问的。所有人可见
     */
    public Boolean getIsPublic() {
        return isPublic;
    }

    /**
     * 设置是否公开菜单
就是无需分配就可以访问的。所有人可见
     *
     * @param isPublic 是否公开菜单
就是无需分配就可以访问的。所有人可见
     */
    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    /**
     * 获取资源路径
     *
     * @return href - 资源路径
     */
    public String getHref() {
        return href;
    }

    /**
     * 设置资源路径
     *
     * @param href 资源路径
     */
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * 获取打开方式
#TargetType{SELF:_self,相同框架;TOP:_top,当前页;BLANK:_blank,新建窗口;PAREN:_parent,父窗口}
     *
     * @return target - 打开方式
#TargetType{SELF:_self,相同框架;TOP:_top,当前页;BLANK:_blank,新建窗口;PAREN:_parent,父窗口}
     */
    public String getTarget() {
        return target;
    }

    /**
     * 设置打开方式
#TargetType{SELF:_self,相同框架;TOP:_top,当前页;BLANK:_blank,新建窗口;PAREN:_parent,父窗口}
     *
     * @param target 打开方式
#TargetType{SELF:_self,相同框架;TOP:_top,当前页;BLANK:_blank,新建窗口;PAREN:_parent,父窗口}
     */
    public void setTarget(String target) {
        this.target = target;
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
     * 获取排序
     *
     * @return sort_value - 排序
     */
    public Integer getSortValue() {
        return sortValue;
    }

    /**
     * 设置排序
     *
     * @param sortValue 排序
     */
    public void setSortValue(Integer sortValue) {
        this.sortValue = sortValue;
    }

    /**
     * 获取菜单图标
     *
     * @return icon - 菜单图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置菜单图标
     *
     * @param icon 菜单图标
     */
    public void setIcon(String icon) {
        this.icon = icon;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}