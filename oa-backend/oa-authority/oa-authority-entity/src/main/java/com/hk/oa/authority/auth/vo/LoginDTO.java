package com.hk.oa.authority.auth.vo;

import com.hk.oa.auth.utils.Token;
import com.hk.oa.authority.auth.entity.User;
import io.swagger.annotations.ApiModel;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 登录返回信息
 *
 * @author zuihou
 * @date 2019/06/25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)//chain的中文含义是链式的，设置为true，则setter方法返回当前对象
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "LoginDTO", description = "登录信息")
public class LoginDTO implements Serializable {
    private User user;
    private Token token;
}
