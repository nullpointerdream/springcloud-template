package com.hk.oa.authority.dao.auth;

import com.hk.oa.authority.auth.entity.RoleAuthority;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleAuthorityMapper extends Mapper<RoleAuthority> {

    /**
     * @Description: 删除角色菜单权限
     * @Param: [roleId]
     * @return: void
     * @Author: 陈家乐
     * @Date: 2019/8/30
     */
    void deleteAuthorityByRole(@Param("roleId") Integer roleId,@Param("authorityType") String authority_type);


    /**
     * @Description: 批量插入
     * @Param: [menuList]
     * @return: void
     * @Author: 陈家乐
     * @Date: 2019/8/30
     */
    void saveBatch(@Param("list") List<RoleAuthority> menuList);
}