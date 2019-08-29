package com.hk.oa.common.utils;

import com.github.pagehelper.Page;
import com.hk.oa.common.constant.BaseContextConstants;
import com.hk.oa.common.vo.QueryVo;
import com.hk.oa.common.vo.ResponseListResult;
import com.hk.oa.common.vo.ResponseResult;

import java.util.Date;
import java.util.List;

public class ResponseResultUtil {

	/**
	 * buildSuccessResponseResult:创建状态响应
	 * @author dingshuyan
	 * @param message
	 * @param data
	 * @return
	 * @since JDK 1.8
	 */
	public static <T> ResponseResult<T> buildResponseResult(String state, String msgCode, String message, T data){
		ResponseResult<T> responseResult = new ResponseResult<T>();
		responseResult.setData(data);
		responseResult.setMessage(message);
		responseResult.setState(state);
		responseResult.setMsgCode(msgCode);
		responseResult.setTimestamp(new Date());
		return responseResult;
	}

	/**
	 * buildSuccessResponseResult:创建成功状态响应
	 * @author dingshuyan
	 * @param message
	 * @param data
	 * @return
	 * @since JDK 1.8
	 */
	public static <T> ResponseResult<T> buildSuccessResponseResult(String message, T data){
		ResponseResult<T> responseResult = new ResponseResult<T>();
		responseResult.setData(data);
		responseResult.setMessage(message);
		responseResult.setState(BaseContextConstants.SUCCESS_STATE);
		responseResult.setMsgCode(BaseContextConstants.SUCCESS_CODE);
		responseResult.setTimestamp(new Date());
		return responseResult;
	}

	/**
	 * buildSuccessResponseResult:创建失败状态响应
	 * @author dingshuyan
	 * @param msgCode
	 * @param message
	 * @return
	 * @since JDK 1.8
	 */
	public static <T> ResponseResult<T> buildFailResponseResult(String msgCode, String message){
		ResponseResult<T> responseResult = new ResponseResult<T>();
		responseResult.setMessage(message);
		responseResult.setState(BaseContextConstants.FAIL_STATE);
		responseResult.setMsgCode(msgCode);
		responseResult.setTimestamp(new Date());
		return responseResult;
	}

	/**
	 * buildSuccessResponseResultList:创建成功状态响应
	 * @author dingshuyan
	 * @param message
	 * @param data
	 * @return
	 * @since JDK 1.8
	 */

	public static <T> ResponseListResult<T> buildSuccessResponseResultList(String message, List<T> data){
		ResponseListResult<T> responseListResult = new ResponseListResult<T>();
		responseListResult.setData(data);
		responseListResult.setMessage(message);
		responseListResult.setState(BaseContextConstants.SUCCESS_STATE);
		responseListResult.setMsgCode(BaseContextConstants.SUCCESS_CODE);
		return responseListResult;
	}

	/**
	 * buildFailResponseResultList:创建失败状态响应
	 * @author dingshuyan
	 * @param msgCode
	 * @param message
	 * @return
	 * @since JDK 1.8
	 */
	public static <T> ResponseListResult<T> buildFailResponseResultList(String msgCode, String message){
		ResponseListResult<T> responseResult = new ResponseListResult<T>();
		responseResult.setMessage(message);
		responseResult.setState(BaseContextConstants.FAIL_STATE);
		responseResult.setMsgCode(msgCode);
		return responseResult;
	}

	/**
	 * buildFailResponseResultList:创建失败状态响应
	 * @author dingshuyan
	 * @param msgCode
	 * @param message
	 * @param data
	 * @return
	 * @since JDK 1.8
	 */
	public static <T> ResponseListResult<T> buildFailResponseResultList(String msgCode, String message, List<T> data) {
		ResponseListResult<T> responseResult = new ResponseListResult<T>();
		responseResult.setMessage(message);
		responseResult.setState(BaseContextConstants.FAIL_STATE);
		responseResult.setMsgCode(msgCode);
		responseResult.setData(data);
		return responseResult;
	}

	public static <T> ResponseListResult<T> buildResponseResultList(String state,String msgCode, String message, List<T> data) {
		ResponseListResult<T> responseResult = new ResponseListResult<T>();
		responseResult.setMessage(message);
		responseResult.setState(state);
		responseResult.setMsgCode(msgCode);
		responseResult.setData(data);
		return responseResult;
	}

	/**
	 * buildSuccessResponseResult:创建失败状态响应
	 * @author dingshuyan
	 * @param msgCode
	 * @param message
	 * @return
	 * @since JDK 1.8
	 */
	public static <T> ResponseResult<T> buildFailResponseResult(String msgCode, String message, T data){
		ResponseResult<T> responseResult = new ResponseResult<T>();
		responseResult.setMessage(message);
		responseResult.setState(BaseContextConstants.FAIL_STATE);
		responseResult.setMsgCode(msgCode);
		responseResult.setData(data);
		return responseResult;
	}

	/**
	 * 创建一个带分页信息的返回信息。
	 * @param message
	 * @param page
	 * @return
	 */
	public static ResponseResult buildSuccessPageResponseResult(String message, Page page){
		QueryVo queryVo = new QueryVo();
		queryVo.setPage(page.getPageNum());
		queryVo.setPageSize(page.getPageSize());
		queryVo.setTotal(page.getTotal());
		queryVo.setData(page);
		return buildSuccessResponseResult(message,queryVo);
	}


}

