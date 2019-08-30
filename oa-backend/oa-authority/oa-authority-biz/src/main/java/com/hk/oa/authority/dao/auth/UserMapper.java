package com.hk.oa.authority.dao.auth;

import com.hk.oa.authority.auth.entity.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {
    
   /** 
   * @Description: 根据用户名查询用户 
   * @Param: [account] 
   * @return: com.hk.oa.authority.auth.entity.User 
   * @Author: 陈家乐 
   * @Date: 2019/8/30
   */ 
    User getUserByAccount(@Param("account") String account);
}