package com.hk.oa.authority.biz.auth;

import com.hk.oa.authority.auth.entity.Role;
import com.hk.oa.authority.dao.auth.RoleMapper;
import com.hk.oa.common.biz.BaseBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
