package com.hk.oa.authority.controller.auth;

/**
 * @program: hk-oa-master
 * @description: 菜单管理
 * @author: 陈家乐
 * @create: 2019-08-28 13:42
 **/

import com.hk.oa.authority.auth.entity.Menu;
import com.hk.oa.authority.auth.vo.MenuTree;
import com.hk.oa.authority.biz.auth.MenuBiz;
import com.hk.oa.common.rest.BaseController;
import com.hk.oa.common.utils.ResponseResultUtil;
import com.hk.oa.common.vo.ResponseResult;
import com.hk.oa.common.vo.tree.TreeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/menu")
@Api(value = "MenuController", tags = "菜单管理")
@Slf4j
public class MenuController extends BaseController<MenuBiz, Menu> {


    /**
    * @Description: 查询用户可用的所有菜单
    * @Param: []
    * @return: com.hk.oa.common.vo.ResponseResult
    * @Author: 陈家乐
    * @Date: 2019/8/28
    */
    @ApiOperation(value = "查询用户可用的所有菜单", notes = "查询用户可用的所有菜单")
    @RequestMapping(value = "menus", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户id", dataType = "long", paramType = "query")
    })
    public ResponseResult myMenus(@RequestParam(value = "userId", required = false) Integer userId) {
        if ( userId == null || userId <= 0) {
            userId = this.getCurrentUserId();
        }
        List<Menu> menus=baseBiz.findVisibleMenu(userId);
        List<MenuTree> list = menus.stream().map(bean -> new MenuTree(bean)).collect(Collectors.toList());
        return ResponseResultUtil.buildSuccessResponseResult("",TreeUtil.bulid(list,0));
    }



}
