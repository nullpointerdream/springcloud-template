package com.hk.oa.authority.dao.auth;

import com.hk.oa.authority.auth.entity.Menu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface MenuMapper extends Mapper<Menu> {

    /**
    * @Description: 查询用户可见的菜单
    * @Param: [userId]
    * @return: java.util.List<com.hk.oa.authority.auth.entity.Menu>
    * @Author: 陈家乐
    * @Date: 2019/8/30
    */
    List<Menu> findVisibleMenu(Integer userId);
}