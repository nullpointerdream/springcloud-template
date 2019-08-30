package com.hk.oa.authority.common.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "common_opt_log")
public class OptLog {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 操作IP
     */
    @Column(name = "request_ip")
    private String requestIp;

    /**
     * 日志类型
#LogType{OPT:操作类型;EX:异常类型}
     */
    private String type;

    /**
     * 操作人
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 操作描述
     */
    private String description;

    /**
     * 类路径
     */
    @Column(name = "class_path")
    private String classPath;

    /**
     * 请求方法
     */
    @Column(name = "action_method")
    private String actionMethod;

    /**
     * 请求地址
     */
    @Column(name = "request_uri")
    private String requestUri;

    /**
     * 请求类型
#HttpMethod{GET:GET请求;POST:POST请求;PUT:PUT请求;DELETE:DELETE请求;PATCH:PATCH请求;TRACE:TRACE请求;HEAD:HEAD请求;OPTIONS:OPTIONS请求;}
     */
    @Column(name = "http_method")
    private String httpMethod;

    /**
     * 开始时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 完成时间
     */
    @Column(name = "finish_time")
    private Date finishTime;

    /**
     * 消耗时间
     */
    @Column(name = "consuming_time")
    private Long consumingTime;

    /**
     * 浏览器
     */
    private String ua;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user")
    private Integer createUser;

    /**
     * 请求参数
     */
    private String params;

    /**
     * 返回值
     */
    private String result;

    /**
     * 异常详情信息
     */
    @Column(name = "ex_desc")
    private String exDesc;

    /**
     * 异常描述
     */
    @Column(name = "ex_detail")
    private String exDetail;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取操作IP
     *
     * @return request_ip - 操作IP
     */
    public String getRequestIp() {
        return requestIp;
    }

    /**
     * 设置操作IP
     *
     * @param requestIp 操作IP
     */
    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    /**
     * 获取日志类型
#LogType{OPT:操作类型;EX:异常类型}
     *
     * @return type - 日志类型
#LogType{OPT:操作类型;EX:异常类型}
     */
    public String getType() {
        return type;
    }

    /**
     * 设置日志类型
#LogType{OPT:操作类型;EX:异常类型}
     *
     * @param type 日志类型
#LogType{OPT:操作类型;EX:异常类型}
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取操作人
     *
     * @return user_name - 操作人
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置操作人
     *
     * @param userName 操作人
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取操作描述
     *
     * @return description - 操作描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置操作描述
     *
     * @param description 操作描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取类路径
     *
     * @return class_path - 类路径
     */
    public String getClassPath() {
        return classPath;
    }

    /**
     * 设置类路径
     *
     * @param classPath 类路径
     */
    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    /**
     * 获取请求方法
     *
     * @return action_method - 请求方法
     */
    public String getActionMethod() {
        return actionMethod;
    }

    /**
     * 设置请求方法
     *
     * @param actionMethod 请求方法
     */
    public void setActionMethod(String actionMethod) {
        this.actionMethod = actionMethod;
    }

    /**
     * 获取请求地址
     *
     * @return request_uri - 请求地址
     */
    public String getRequestUri() {
        return requestUri;
    }

    /**
     * 设置请求地址
     *
     * @param requestUri 请求地址
     */
    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }

    /**
     * 获取请求类型
#HttpMethod{GET:GET请求;POST:POST请求;PUT:PUT请求;DELETE:DELETE请求;PATCH:PATCH请求;TRACE:TRACE请求;HEAD:HEAD请求;OPTIONS:OPTIONS请求;}
     *
     * @return http_method - 请求类型
#HttpMethod{GET:GET请求;POST:POST请求;PUT:PUT请求;DELETE:DELETE请求;PATCH:PATCH请求;TRACE:TRACE请求;HEAD:HEAD请求;OPTIONS:OPTIONS请求;}
     */
    public String getHttpMethod() {
        return httpMethod;
    }

    /**
     * 设置请求类型
#HttpMethod{GET:GET请求;POST:POST请求;PUT:PUT请求;DELETE:DELETE请求;PATCH:PATCH请求;TRACE:TRACE请求;HEAD:HEAD请求;OPTIONS:OPTIONS请求;}
     *
     * @param httpMethod 请求类型
#HttpMethod{GET:GET请求;POST:POST请求;PUT:PUT请求;DELETE:DELETE请求;PATCH:PATCH请求;TRACE:TRACE请求;HEAD:HEAD请求;OPTIONS:OPTIONS请求;}
     */
    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    /**
     * 获取开始时间
     *
     * @return start_time - 开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间
     *
     * @param startTime 开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取完成时间
     *
     * @return finish_time - 完成时间
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * 设置完成时间
     *
     * @param finishTime 完成时间
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 获取消耗时间
     *
     * @return consuming_time - 消耗时间
     */
    public Long getConsumingTime() {
        return consumingTime;
    }

    /**
     * 设置消耗时间
     *
     * @param consumingTime 消耗时间
     */
    public void setConsumingTime(Long consumingTime) {
        this.consumingTime = consumingTime;
    }

    /**
     * 获取浏览器
     *
     * @return ua - 浏览器
     */
    public String getUa() {
        return ua;
    }

    /**
     * 设置浏览器
     *
     * @param ua 浏览器
     */
    public void setUa(String ua) {
        this.ua = ua;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return create_user
     */
    public Integer getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser
     */
    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取请求参数
     *
     * @return params - 请求参数
     */
    public String getParams() {
        return params;
    }

    /**
     * 设置请求参数
     *
     * @param params 请求参数
     */
    public void setParams(String params) {
        this.params = params;
    }

    /**
     * 获取返回值
     *
     * @return result - 返回值
     */
    public String getResult() {
        return result;
    }

    /**
     * 设置返回值
     *
     * @param result 返回值
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * 获取异常详情信息
     *
     * @return ex_desc - 异常详情信息
     */
    public String getExDesc() {
        return exDesc;
    }

    /**
     * 设置异常详情信息
     *
     * @param exDesc 异常详情信息
     */
    public void setExDesc(String exDesc) {
        this.exDesc = exDesc;
    }

    /**
     * 获取异常描述
     *
     * @return ex_detail - 异常描述
     */
    public String getExDetail() {
        return exDetail;
    }

    /**
     * 设置异常描述
     *
     * @param exDetail 异常描述
     */
    public void setExDetail(String exDetail) {
        this.exDetail = exDetail;
    }
}