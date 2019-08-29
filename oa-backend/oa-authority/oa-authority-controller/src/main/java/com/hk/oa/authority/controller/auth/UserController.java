package com.hk.oa.authority.controller.auth;


import com.hk.oa.authority.auth.entity.User;
import com.hk.oa.authority.biz.auth.UserBiz;
import com.hk.oa.common.rest.BaseController;
import com.hk.oa.common.utils.ResponseResultUtil;
import com.hk.oa.common.vo.ResponseResult;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @program: hk-oa-master
 * @description: 用户管理
 * @author: 陈家乐
 * @create: 2019-08-22 15:58
 **/
@Slf4j
@Validated
@RestController
@RequestMapping("/user")
@Api(value = "User", tags = "用户管理")
public class UserController extends BaseController<UserBiz, User> {

    @Validated //表单校验
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult add(@RequestBody @Valid User entity) {
        baseBiz.addUser(entity);
        return  ResponseResultUtil.buildSuccessResponseResult("添加成功",null);
    }


}
