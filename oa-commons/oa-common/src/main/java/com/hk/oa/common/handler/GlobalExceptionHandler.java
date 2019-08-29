package com.hk.oa.common.handler;

import cn.hutool.core.util.StrUtil;
import com.hk.oa.common.exception.BizException;
import com.hk.oa.common.exception.code.ExceptionCode;
import com.hk.oa.common.msg.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;


import javax.servlet.ServletException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.hk.oa.common.exception.code.ExceptionCode.REQUIRED_FILE_PARAM_EX;


/**
 * @author zuihou
 * @createTime 2017-12-13 17:04
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BizException.class)
    public BaseResponse baseExceptionHandler(BizException ex) {
        log.info("BizException:", ex);
        return BaseResponse.result(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public BaseResponse httpMessageNotReadableException(HttpMessageNotReadableException ex) {
        log.error("HttpMessageNotReadableException:", ex);
        String message = ex.getMessage();
        if (message != null && !"".equals(message)) {
            if (message.contains("Could not read document:")) {
                String msg = "无法正确的解析json类型的参数：" +
                        message.substring(message.indexOf("Could not read document:") +
                                "Could not read document:".length(), message.indexOf(" at "));
                return BaseResponse.result(ExceptionCode.PARAM_EX.getCode(), msg);
            }
        }
        return BaseResponse.result(ExceptionCode.PARAM_EX.getCode(), ExceptionCode.PARAM_EX.getMsg());
    }

    @ExceptionHandler(BindException.class)
    public BaseResponse bindException(BindException eee) {
        log.error("BindException:", eee);
        try {
            String msgs = eee.getBindingResult().getFieldError().getDefaultMessage();
            if (StrUtil.isNotEmpty(msgs)) {
                return BaseResponse.result(ExceptionCode.PARAM_EX.getCode(), msgs);
            }
        } catch (Exception ee) {

        }
        StringBuilder msg = new StringBuilder();
        List<FieldError> fieldErrors = eee.getFieldErrors();
        fieldErrors.forEach((oe) ->
                msg.append("参数对象[").append(oe.getObjectName()).append("]的字段[")
                        .append(oe.getField()).append("]的值[").append(oe.getRejectedValue()).append("]与实际类型不匹配.")

        );
        return BaseResponse.result(ExceptionCode.PARAM_EX.getCode(), msg.toString());
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public BaseResponse methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        log.error("MethodArgumentTypeMismatchException:", ex);
        MethodArgumentTypeMismatchException eee = (MethodArgumentTypeMismatchException) ex;
        StringBuilder msg = new StringBuilder("参数[").append(eee.getName()).append("]的值[")
                .append(eee.getValue()).append("]与实际类型[").append(eee.getRequiredType().getName()).append("]不匹配");
        return BaseResponse.result(ExceptionCode.PARAM_EX.getCode(), msg.toString());
    }

    @ExceptionHandler(IllegalStateException.class)
    public BaseResponse illegalStateException(IllegalStateException ex) {
        log.error("IllegalStateException:", ex);
        return BaseResponse.result(ExceptionCode.ILLEGALA_ARGUMENT_EX.getCode(), ExceptionCode.ILLEGALA_ARGUMENT_EX.getMsg());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public BaseResponse missingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.error("MissingServletRequestParameterException:", e);
        StringBuilder msg = new StringBuilder();
        msg.append("缺少必须的[").append(e.getParameterType()).append("] 类型的参数[").append(e.getParameterName()).append("]");
        return BaseResponse.result(ExceptionCode.ILLEGALA_ARGUMENT_EX.getCode(), msg.toString());
    }

    @ExceptionHandler(NullPointerException.class)
    public BaseResponse nullPointerException(NullPointerException ex) {
        log.error("NullPointerException:", ex);
        return BaseResponse.result(ExceptionCode.NULL_POINT_EX.getCode(), ExceptionCode.NULL_POINT_EX.getMsg());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public BaseResponse illegalArgumentException(IllegalArgumentException ex) {
        log.error("IllegalArgumentException:", ex);
        return BaseResponse.result(ExceptionCode.ILLEGALA_ARGUMENT_EX.getCode(), ExceptionCode.ILLEGALA_ARGUMENT_EX.getMsg());
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public BaseResponse httpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        log.error("HttpMediaTypeNotSupportedException:", e);
        MediaType contentType = e.getContentType();
        if (contentType != null) {
            StringBuilder msg = new StringBuilder();
            msg.append("请求类型(Content-Type)[").append(contentType.toString()).append("] 与实际接口的请求类型不匹配");
            return BaseResponse.result(ExceptionCode.MEDIA_TYPE_EX.getCode(), msg.toString());
        }
        return BaseResponse.result(ExceptionCode.MEDIA_TYPE_EX.getCode(), "无效的Content-Type类型");
    }

    @ExceptionHandler(MissingServletRequestPartException.class)
    public BaseResponse missingServletRequestPartException(MissingServletRequestPartException ex) {
        log.error("MissingServletRequestPartException:", ex);
        return BaseResponse.result(REQUIRED_FILE_PARAM_EX.getCode(), REQUIRED_FILE_PARAM_EX.getMsg());
    }

    @ExceptionHandler(ServletException.class)
    public BaseResponse servletException(ServletException ex) {
        log.error("ServletException:", ex);
        String msg = "UT010016: Not a multi part request";
        if (msg.equalsIgnoreCase(ex.getMessage())) {
            return BaseResponse.result(REQUIRED_FILE_PARAM_EX.getCode(), REQUIRED_FILE_PARAM_EX.getMsg());
        }
        return BaseResponse.result(ExceptionCode.SYSTEM_BUSY.getCode(), ex.getMessage());
    }

    @ExceptionHandler(MultipartException.class)
    public BaseResponse multipartException(MultipartException ex) {
        log.error("MultipartException:", ex);
        return BaseResponse.result(REQUIRED_FILE_PARAM_EX.getCode(), REQUIRED_FILE_PARAM_EX.getMsg());
    }

    /**
     * jsr 规范中的验证异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public BaseResponse constraintViolationException(ConstraintViolationException ex) {
        log.error("ConstraintViolationException:", ex);
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        String message = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));
        return BaseResponse.result(ExceptionCode.BASE_VALID_PARAM.getCode(), message);
    }

    /**
     * spring 封装的参数验证异常， 在conttoller中没有写result参数时，会进入
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error("MethodArgumentNotValidException:", ex);
        return BaseResponse.result(ExceptionCode.BASE_VALID_PARAM.getCode(), ex.getBindingResult().getFieldError().getDefaultMessage());
    }

    /**
     * 其他异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public BaseResponse otherExceptionHandler(Exception ex) {
        log.error("Exception:", ex);
        return BaseResponse.result(ExceptionCode.SYSTEM_BUSY.getCode(), ExceptionCode.SYSTEM_BUSY.getMsg());
    }



}
