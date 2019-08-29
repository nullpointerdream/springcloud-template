package com.hk.oa.common.msg;

import lombok.Data;

@Data
public class BaseResponse {

    private Integer state = 200;
    private String message;

    public BaseResponse(Integer state, String message) {
        this.state = state;
        this.message = message;
    }

    public BaseResponse() {
    }

    public static BaseResponse result(Integer code , String msg) {
        return new BaseResponse(code, msg);

    }
    
}
