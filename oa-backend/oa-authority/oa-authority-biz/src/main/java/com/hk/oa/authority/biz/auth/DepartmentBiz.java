package com.hk.oa.authority.biz.auth;

import com.hk.oa.authority.auth.entity.Department;
import com.hk.oa.authority.dao.auth.DepartmentMapper;
import com.hk.oa.common.biz.BaseBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: hk-oa-master
 * @description: 部门
 * @author: 陈家乐
 * @create: 2019-08-29 09:42
 **/
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class DepartmentBiz extends BaseBiz<DepartmentMapper, Department> {
}
