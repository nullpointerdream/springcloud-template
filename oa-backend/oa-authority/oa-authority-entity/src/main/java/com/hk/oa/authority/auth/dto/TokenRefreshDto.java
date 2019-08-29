package com.hk.oa.authority.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@ApiModel(value = "刷新token请求", description = "刷新token请求")
@Data
public class TokenRefreshDto {

    @NotBlank(message = "Refresh token 不能为空")
    @ApiModelProperty(value = "refreshToken", required = true)
    private String refreshToken;


}
