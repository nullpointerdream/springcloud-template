package com.hk.oa.authority.auth.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Table(name = "auth_user")
public class User {
    /**
     * ID
     */
    @Id
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
    @Column(name = "department_id")
    private Integer departmentId;

    /**
     * 角色ID
     *
     */
    @NotNull(message = "角色不能为空")
    @ApiModelProperty(value = "角色", required = true)
    @Column(name = "role_id")
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
     * 是否可登陆
     */
    @Column(name = "is_can_login")
    private Boolean isCanLogin;

    /**
     * 删除标记
     */
    @Column(name = "is_delete")
    private Boolean isDelete;

    /**
     * 照片
     */
    private String photo;

    /**
     * 工作描述
     * 比如：  市长、管理员、局长等等   用于登陆展示
     */
    @Column(name = "work_describe")
    private String workDescribe;


    /**
     * 备注
     */
    private String remark;

    /**
     * 输入密码错误的日期
     * 比如20190102  与error_count合力实现一天输入密码错误次数限制
     */
    @Column(name = "continuation_error_day")
    private Date continuationErrorDay;

    /**
     * 一天连续输错密码次数
     */
    @Column(name = "continuation_error_count")
    private Integer continuationErrorCount;

    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    @ApiModelProperty(value = "密码", required = true)
    @JsonIgnore
    private String password;

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
     * 获取账号
     *
     * @return account - 账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置账号
     *
     * @param account 账号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * 获取手机
     *
     * @return mobile - 手机
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机
     *
     * @param mobile 手机
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取性别
     * #Sex{W:女;M:男}
     *
     * @return sex - 性别
     * #Sex{W:女;M:男}
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     * #Sex{W:女;M:男}
     *
     * @param sex 性别
     *            #Sex{W:女;M:男}
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取是否可登陆
     *
     * @return is_can_login - 是否可登陆
     */
    public Boolean getIsCanLogin() {
        return isCanLogin;
    }

    /**
     * 设置是否可登陆
     *
     * @param isCanLogin 是否可登陆
     */
    public void setIsCanLogin(Boolean isCanLogin) {
        this.isCanLogin = isCanLogin;
    }

    /**
     * 获取删除标记
     *
     * @return is_delete - 删除标记
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * 设置删除标记
     *
     * @param isDelete 删除标记
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取照片
     *
     * @return photo - 照片
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 设置照片
     *
     * @param photo 照片
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * 获取工作描述
     * 比如：  市长、管理员、局长等等   用于登陆展示
     *
     * @return work_describe - 工作描述
     * 比如：  市长、管理员、局长等等   用于登陆展示
     */
    public String getWorkDescribe() {
        return workDescribe;
    }

    /**
     * 设置工作描述
     * 比如：  市长、管理员、局长等等   用于登陆展示
     *
     * @param workDescribe 工作描述
     *                     比如：  市长、管理员、局长等等   用于登陆展示
     */
    public void setWorkDescribe(String workDescribe) {
        this.workDescribe = workDescribe;
    }

    /**
     * 获取输入密码错误的日期
     * 比如20190102  与error_count合力实现一天输入密码错误次数限制
     *
     * @return continuation_error_day - 输入密码错误的日期
     * 比如20190102  与error_count合力实现一天输入密码错误次数限制
     */
    public Date getContinuationErrorDay() {
        return continuationErrorDay;
    }

    /**
     * 设置输入密码错误的日期
     * 比如20190102  与error_count合力实现一天输入密码错误次数限制
     *
     * @param continuationErrorDay 输入密码错误的日期
     *                             比如20190102  与error_count合力实现一天输入密码错误次数限制
     */
    public void setContinuationErrorDay(Date continuationErrorDay) {
        this.continuationErrorDay = continuationErrorDay;
    }

    /**
     * 获取一天连续输错密码次数
     *
     * @return continuation_error_count - 一天连续输错密码次数
     */
    public Integer getContinuationErrorCount() {
        return continuationErrorCount;
    }

    /**
     * 设置一天连续输错密码次数
     *
     * @param continuationErrorCount 一天连续输错密码次数
     */
    public void setContinuationErrorCount(Integer continuationErrorCount) {
        this.continuationErrorCount = continuationErrorCount;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
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


    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}