package com.hk.oa.authority.biz.auth;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hk.oa.authority.auth.dto.RoleQueryDto;
import com.hk.oa.authority.auth.dto.RoleUpdateDto;
import com.hk.oa.authority.auth.entity.Role;
import com.hk.oa.authority.dao.auth.RoleMapper;
import com.hk.oa.common.biz.BaseBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @program: hk-oa-master
 * @description: 角色管理
 * @author: 陈家乐
 * @create: 2019-08-28 13:56
 **/
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleBiz extends BaseBiz<RoleMapper, Role> {

    /**
     * @Description: 添加角色
     * @Param: [entity]
     * @return: void
     * @Author: 陈家乐
     * @Date: 2019/8/29
     */
    public void addRole(Role entity) {
        Date date = new Date();
        entity.setCreateTime(date);
        entity.setCreateTime(date);
        mapper.insertSelective(entity);

    }

    /**
     * @Description: 更新角色
     * @Param: [entity]
     * @return: void
     * @Author: 陈家乐
     * @Date: 2019/8/30
     */
    public void updateRole(RoleUpdateDto roleUpdateDto) {
        Role role =new Role();
        BeanUtils.copyProperties(roleUpdateDto, role);
        role.setUpdateTime(new Date());
        mapper.updateByPrimaryKeySelective(role);
    }


    /**
     * @Description: 分页查询角色
     * @Param: [roleQueryDto]
     * @return: com.github.pagehelper.Page<com.hk.oa.authority.auth.entity.Role>
     * @Author: 陈家乐
     * @Date: 2019/8/30
     */
    public Page<Role> getRoleList(RoleQueryDto roleQueryDto) {
        Page list = PageHelper.startPage(roleQueryDto.getPage(), roleQueryDto.getLimit());
        mapper.selectAll();
        return list;
    }
}
