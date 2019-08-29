package com.hk.oa.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ResponseListResult<T> implements Serializable {

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
     * 返回数据,Json字符串
     */
    private List<T> data;

    public ResponseListResult() {
    }

    public ResponseListResult(List<T> list) {
        this.data = list;
    }

    public ResponseListResult(String state, String msgCode, String message, List<T> list) {
        this.state = state;
        this.msgCode = msgCode;
        this.message = message;
        this.data = list;
    }

}
