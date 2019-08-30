package com.hk.oa.authority.controller.auth;

import com.github.pagehelper.Page;
import com.hk.oa.authority.auth.dto.RoleAuthoritySaveDto;
import com.hk.oa.authority.auth.dto.RoleQueryDto;
import com.hk.oa.authority.auth.dto.RoleUpdateDto;
import com.hk.oa.authority.auth.entity.Role;
import com.hk.oa.authority.biz.auth.RoleBiz;
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
 * @description: 角色管理
 * @author: 陈家乐
 * @create: 2019-08-30 10:37
 **/
@Slf4j
@Validated
@RestController
@RequestMapping("/role")
@Api(value = "Rple", tags = "角色管理")
public class RoleController extends BaseController<RoleBiz, Role> {

    /**
     * @Description: 添加角色
     * @Param: [entity]
     * @return: com.hk.oa.common.vo.ResponseResult
     * @Author: 陈家乐
     * @Date: 2019/8/30
     */
    @Validated //表单校验
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ApiOperation(value = "添加角色", notes = "添加角色")
    @ResponseBody
    public ResponseResult add(@RequestBody @Valid Role entity) {
        baseBiz.addRole(entity);
        return  ResponseResultUtil.buildSuccessResponseResult("添加成功",null);
    }


    /**
     * @Description: 查询角色
     * @Param: [id]
     * @return: com.hk.oa.common.vo.ResponseResult
     * @Author: 陈家乐
     * @Date: 2019/8/30
     */
    @ApiOperation(value = "查询角色", notes = "根据ID查询")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult get(@PathVariable int id) {
        Role role = baseBiz.selectById(id);
        return  ResponseResultUtil.buildSuccessResponseResult("查询成功",role);
    }


    /**
     * @Description: 更新角色
     * @Param: [entity]
     * @return: com.hk.oa.common.vo.ResponseResult
     * @Author: 陈家乐
     * @Date: 2019/8/30
     */
    @Validated //表单校验
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ApiOperation(value = "更新角色", notes = "根据ID更新角色")
    @ResponseBody
    public ResponseResult update(@RequestBody @Valid RoleUpdateDto entity) {
        baseBiz.updateRole(entity);
        return  ResponseResultUtil.buildSuccessResponseResult("修改成功",null);
    }


    /**
     * @Description: 分页查询角色
     * @Param: [userQueryDto]
     * @return: com.hk.oa.common.vo.ResponseResult
     * @Author: 陈家乐
     * @Date: 2019/8/30
     */
    @Validated
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ApiOperation(value = "分页查询角色", notes = "分页查询角色")
    @ResponseBody
    public ResponseResult list(@RequestBody @Valid RoleQueryDto roleQueryDto) {
        Page<Role> list =baseBiz.getRoleList(roleQueryDto);
        return  ResponseResultUtil.buildSuccessPageResponseResult("查询成功",list);
    }


    /**
     * 给角色配置权限
     *
     * @param roleAuthoritySaveDto 角色权限授权对象
     * @return 新增结果
     */
    @ApiOperation(value = "给角色配置权限", notes = "给角色配置权限")
    @PostMapping("/menu")
    @Validated
    public ResponseResult save(@RequestBody @Valid RoleAuthoritySaveDto roleAuthoritySaveDto) {
        roleAuthoritySaveDto.setCreateUser(this.getCurrentUserId());
        baseBiz.addRoleMenu(roleAuthoritySaveDto);
        return  ResponseResultUtil.buildSuccessResponseResult("设置成功",null);
    }

}
