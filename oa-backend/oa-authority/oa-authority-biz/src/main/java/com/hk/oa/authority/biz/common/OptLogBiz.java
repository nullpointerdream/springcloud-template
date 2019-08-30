package com.hk.oa.authority.biz.common;

import com.hk.oa.authority.common.entity.OptLog;
import com.hk.oa.authority.dao.common.OptLogMapper;
import com.hk.oa.common.biz.BaseBiz;
import com.hk.oa.log.entity.OptLogDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @program: hk-oa-master
 * @description: 日志
 * @author: 陈家乐
 * @create: 2019-08-29 09:42
 **/
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class OptLogBiz extends BaseBiz<OptLogMapper, OptLog> {

    /**
    * @Description: 保存日志
    * @Param: [log]
    * @return: void
    * @Author: 陈家乐
    * @Date: 2019/8/30
    */
    public void save(OptLogDTO log) {
        OptLog optLog =new OptLog();
        optLog.setCreateTime(new Date());
        BeanUtils.copyProperties(log, optLog);
        mapper.insert(optLog);
    }
}
