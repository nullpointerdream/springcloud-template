package com.hk.oa.authority.biz.auth;

import com.hk.oa.authority.auth.entity.Menu;
import com.hk.oa.authority.dao.auth.MenuMapper;
import com.hk.oa.common.biz.BaseBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: hk-oa-master
 * @description: 菜单管理
 * @author: 陈家乐
 * @create: 2019-08-28 13:56
 **/
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class MenuBiz extends BaseBiz<MenuMapper, Menu> {
    
    /** 
    * @Description: 根据id查询菜单 
    * @Param: [userId] 
    * @return: java.util.List<com.hk.oa.authority.auth.entity.Menu> 
    * @Author: 陈家乐 
    * @Date: 2019/8/30
    */ 
    public List<Menu> findVisibleMenu(Integer userId) {
        return mapper.findVisibleMenu(userId);
    }
}
