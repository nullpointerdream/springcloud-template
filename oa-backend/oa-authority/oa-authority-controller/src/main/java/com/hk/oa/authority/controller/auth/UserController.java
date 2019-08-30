package com.hk.oa.authority.controller.auth;


import com.github.pagehelper.Page;
import com.hk.oa.authority.auth.dto.UserQueryDto;
import com.hk.oa.authority.auth.dto.UserUpdateDto;
import com.hk.oa.authority.auth.entity.User;
import com.hk.oa.authority.biz.auth.UserBiz;
import com.hk.oa.common.rest.BaseController;
import com.hk.oa.common.utils.ResponseResultUtil;
import com.hk.oa.common.vo.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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


    /**
    * @Description: 添加用户
    * @Param: [entity]
    * @return: com.hk.oa.common.vo.ResponseResult
    * @Author: 陈家乐
    * @Date: 2019/8/30
    */
    @Validated //表单校验
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户", notes = "添加用户")
    @ResponseBody
    public ResponseResult add(@RequestBody @Valid User entity) {
        baseBiz.addUser(entity);
        return  ResponseResultUtil.buildSuccessResponseResult("添加成功",null);
    }


    /**
    * @Description: 查询用户
    * @Param: [id]
    * @return: com.hk.oa.common.vo.ResponseResult
    * @Author: 陈家乐
    * @Date: 2019/8/30
    */
    @ApiOperation(value = "查询用户", notes = "根据ID查询")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult get(@PathVariable int id) {
        User user = baseBiz.selectById(id);
        return  ResponseResultUtil.buildSuccessResponseResult("查询成功",user);
    }


    /**
    * @Description: 更新用户
    * @Param: [entity]
    * @return: com.hk.oa.common.vo.ResponseResult
    * @Author: 陈家乐
    * @Date: 2019/8/30
    */
    @Validated //表单校验
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ApiOperation(value = "更新用户", notes = "根据ID更新用户")
    @ResponseBody
    public ResponseResult update(@RequestBody @Valid UserUpdateDto entity) {
        baseBiz.updateUser(entity);
        return  ResponseResultUtil.buildSuccessResponseResult("修改成功",null);
    }

    
    /** 
    * @Description: 分页查询用户 
    * @Param: [userQueryDto] 
    * @return: com.hk.oa.common.vo.ResponseResult 
    * @Author: 陈家乐 
    * @Date: 2019/8/30
    */ 
    @Validated 
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ApiOperation(value = "分页查询用户", notes = "分页查询用户")
    @ResponseBody
    public ResponseResult list(@RequestBody @Valid UserQueryDto userQueryDto) {
        Page<User> list =baseBiz.getUserList(userQueryDto);
        return  ResponseResultUtil.buildSuccessPageResponseResult("查询成功",list);
    }










}
