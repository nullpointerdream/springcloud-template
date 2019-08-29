package com.hk.oa.auth.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Token implements Serializable {


    /**
     * token
     */
    private String token;

    private String refreshToken;

    private Integer expire;

    public Token(String token,Integer expire){
        this.token=token;
        this.expire=expire;
    }

}