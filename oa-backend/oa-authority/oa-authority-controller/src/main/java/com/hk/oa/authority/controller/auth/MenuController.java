package com.hk.oa.authority.controller.auth;

/**
 * @program: hk-oa-master
 * @description: 菜单管理
 * @author: 陈家乐
 * @create: 2019-08-28 13:42
 **/

import com.hk.oa.authority.auth.dto.UserMenuDto;
import com.hk.oa.authority.auth.entity.Menu;
import com.hk.oa.authority.biz.auth.MenuBiz;
import com.hk.oa.common.rest.BaseController;
import com.hk.oa.common.vo.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping
    public ResponseResult myMenus(@RequestBody UserMenuDto userMenuDto) {
        Integer userId=userMenuDto.getUserId();
        if ( userId == null || userId <= 0) {
            userId = this.getCurrentUserId();
        }
       // baseBiz.findVisibleMenu(userId);
        return null;
    }
}
