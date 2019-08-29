package com.hk.oa.common.handler;

import com.hk.oa.common.exception.code.ExceptionCode;
import com.hk.oa.common.msg.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;


/**
 * @author zuihou
 * @createTime 2017-12-13 17:04
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ConditionalOnClass(value = {
        DataIntegrityViolationException.class
})
@ResponseBody
@Slf4j
public class GlobalDbExceptionHandler {

    @ExceptionHandler(SQLException.class)
    public BaseResponse sqlException(SQLException ex) {
        log.error("SQLException:", ex);
        return BaseResponse.result(ExceptionCode.SQL_EX.getCode(), ExceptionCode.SQL_EX.getMsg());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public BaseResponse dataIntegrityViolationException(DataIntegrityViolationException ex) {
        log.error("DataIntegrityViolationException:", ex);
        return BaseResponse.result(ExceptionCode.SQL_EX.getCode(), ExceptionCode.SQL_EX.getMsg());
    }

    @ExceptionHandler(PersistenceException.class)
    public BaseResponse persistenceException(PersistenceException ex) {
        log.error("PersistenceException:", ex);
        return BaseResponse.result(ExceptionCode.SQL_EX.getCode(),  ExceptionCode.SQL_EX.getMsg());
    }

}
