package com.hk.oa.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = -1093882708787618917L;


    /**
     * 状态 0 失败，1成功
     */
    private String state;
    /**
     * 异常编码
     */
    private String msgCode;
    /**
     * 消息信息
     */
    private String message;
    /**
     * 系统时间戳
     */
    private Date timestamp =new Date();
    /**
     * 返回数据,Json字符串
     */
    private T data;

    public ResponseResult() {

    }

    public ResponseResult(String state, String msgCode, String message, T data) {
    		this.state=state;
    		this.msgCode=msgCode;
    		this.message=message;
        this.data = data;
    }

}
