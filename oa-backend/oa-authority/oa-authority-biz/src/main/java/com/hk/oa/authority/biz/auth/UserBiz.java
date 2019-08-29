package com.hk.oa.authority.biz.auth;

import com.hk.oa.auth.server.utils.JwtTokenServerUtils;
import com.hk.oa.auth.utils.JwtUserInfo;
import com.hk.oa.auth.utils.Token;
import com.hk.oa.authority.auth.dto.TokenRefreshDto;
import com.hk.oa.authority.auth.dto.UserLoginDto;
import com.hk.oa.authority.auth.entity.User;
import com.hk.oa.authority.dao.auth.UserMapper;
import com.hk.oa.common.biz.BaseBiz;
import com.hk.oa.common.exception.BizException;
import com.hk.oa.common.exception.code.ExceptionCode;
import com.hk.oa.redis.template.RedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * @program: hk-oa-master
 * @description: 用户管理
 * @author: 陈家乐
 * @create: 2019-08-26 10:45
 **/

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserBiz extends BaseBiz<UserMapper, User> {

    @Value("${authentication.user.refresh_expire}")
    private Integer refresh_expire;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    private JwtTokenServerUtils jwtTokenServerUtils;

    @Autowired
    private RedisRepository redisRepository;

    /**
    * @Description:  用户登录
    * @Param: [userLoginDto]
    * @return: com.hk.oa.common.vo.ResponseResult
    * @Author: 陈家乐
    * @Date: 2019/8/26
    */
    public Token login(UserLoginDto userLoginDto) {
        User user = getUser(userLoginDto.getAccount(),userLoginDto.getPassword());
        Token token = getToken(user);
        token.setRefreshToken(this.getRefreshToken(user));
        return token;
    }


    /**
    * @Description: 刷新token
    * @Param: [tokenRefreshDto]
    * @return: com.hk.oa.common.vo.ResponseResult
    * @Author: 陈家乐
    * @Date: 2019/8/28
    */
    public Token refreshJwtToken(TokenRefreshDto tokenRefreshDto) {
        String refreshToken = tokenRefreshDto.getRefreshToken();
        User user= redisRepository.get(refreshToken);
        if(user==null){
            throw new BizException(ExceptionCode.JWT_REFRESH_TOKEN_EXPIRED.getCode(), ExceptionCode.JWT_REFRESH_TOKEN_EXPIRED.getMsg());
        }
        Token token = getToken(user);
        //更新refresh token
        redisRepository.setExpire(refreshToken,user,refresh_expire);
        return token;
    }

    private User getUser(String account, String password) {
        User user = mapper.getUserByAccount(account,false);
        if (user == null || !encoder.matches(password, user.getPassword())) {
            throw new BizException(ExceptionCode.JWT_USER_INVALID.getCode(), ExceptionCode.JWT_USER_INVALID.getMsg());
        }
        if (user.getIsCanLogin() == null || !user.getIsCanLogin()) {
            throw new BizException(ExceptionCode.JWT_USER_ENABLED.getCode(), ExceptionCode.JWT_USER_ENABLED.getMsg());
        }
        return user;
    }

    private Token getToken(User user) {
        JwtUserInfo userInfo = null;
        userInfo = new JwtUserInfo(String.valueOf(user.getId()), user.getAccount(), user.getName(), String.valueOf(user.getDepartmentId()), String.valueOf(user.getRoleId()));
        Token token = jwtTokenServerUtils.generateUserToken(userInfo,null);
        return token;
    }

    private String getRefreshToken(User user) {
        String refreshToken = user.getAccount()+ UUID.randomUUID();
        redisRepository.setExpire(refreshToken,user,refresh_expire);
        return refreshToken;
    }

    /**
    * @Description: 添加用户
    * @Param: [entity]
    * @return: void
    * @Author: 陈家乐
    * @Date: 2019/8/29
    */
    public void addUser(User entity) {
        entity.setPassword(encoder.encode(entity.getPassword()));
        Date date = new Date();
        entity.setCreateTime(date);
        entity.setCreateTime(date);
        mapper.insertSelective(entity);

    }
}
