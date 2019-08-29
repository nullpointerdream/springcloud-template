package com.hk.oa.authority.controller.auth;

import com.hk.oa.auth.utils.Token;
import com.hk.oa.authority.auth.dto.TokenRefreshDto;
import com.hk.oa.authority.auth.dto.UserLoginDto;
import com.hk.oa.authority.auth.entity.User;
import com.hk.oa.authority.biz.auth.UserBiz;
import com.hk.oa.common.exception.BizException;
import com.hk.oa.common.rest.BaseController;
import com.hk.oa.common.utils.ResponseResultUtil;
import com.hk.oa.common.vo.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Api(value = "UserAuthController", tags = "用户认证token管理")
@Slf4j
@RefreshScope //配置文件自动刷新
public class AuthTokenController extends BaseController<UserBiz, User> {

    /**
    * @Description:  验证登录并返回token
    * @Param: [userLoginDto]
    * @return: com.hk.oa.common.vo.ResponseResult
    * @Author: 陈家乐
    * @Date: 2019/8/28
    */
    @ApiOperation(value = "登录", notes = "验证登录并返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @Validated //表单校验
    public ResponseResult login(@Valid @RequestBody UserLoginDto userLoginDto) throws BizException {
        Token token = baseBiz.login(userLoginDto);
        return ResponseResultUtil.buildSuccessResponseResult("",token);
    }


    /**
    * @Description:  刷新token
    * @Param: [tokenRefreshRequest]
    * @return: org.springframework.http.ResponseEntity
    * @Author: 陈家乐
    * @Date: 2019/8/28
    */
    @PostMapping("/refresh")
    @ApiOperation(value = "刷新token",notes = "验证refreshToken并返回jwtToken")
    @Validated //表单校验
    public ResponseResult refreshJwtToken(@Valid @RequestBody TokenRefreshDto tokenRefreshDto) {
        Token token =  baseBiz.refreshJwtToken(tokenRefreshDto);
        return ResponseResultUtil.buildSuccessResponseResult("",token);
    }




}
