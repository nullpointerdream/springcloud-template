package com.hk.oa.authority.controller.auth;


import com.hk.oa.authority.auth.entity.Department;
import com.hk.oa.authority.biz.auth.DepartmentBiz;
import com.hk.oa.common.rest.BaseController;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: hk-oa-master
 * @description: 部门管理
 * @author: 陈家乐
 * @create: 2019-08-22 15:58
 **/
@Slf4j
@Validated
@RestController
@RequestMapping("/department")
@Api(value = "Department", tags = "部门管理")
public class DepartmentController extends BaseController<DepartmentBiz, Department> {



}
