package com.edu.vo;

import com.edu.enums.ResultCode;
import com.edu.util.JsonUtil;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author ham
 */
@Data
public class Result implements Serializable{
	private static final long serialVersionUID = -3813061342408268245L;

	/**
	 * 码值
	 */
	private Integer code;

	/**
	 * 描述
	 */
	private String message;

	/**
	 * 数据
	 */
	private Object data;
	
	public Result(ResultCode resultCode) {
		this.code = resultCode.getCode();
		this.message = resultCode.getMessage();
	}

	public Result(Integer code,String message) {
		this.code = code;
		this.message = message;
	}

	public Result(ResultCode resultCode, Object data) {
		this.code = resultCode.getCode();
		this.message = resultCode.getMessage();
		this.data = data;
	}

	/**
	 * 返回成功
	 *
	 * @return
	 */
	public static Result success() {
		return new Result(ResultCode.SUCCESS);
	}

	/**
	 * 返回成功
	 *
	 * @param data 数据
	 *
	 * @return
	 */
	public static Result success(Object data) {
		return new Result(ResultCode.SUCCESS, data);
		
	}

	/**
	 * 返回失败
	 *
	 * @return
	 */
	public static Result failure() {
		return new Result(ResultCode.FAILURE);
	}

	/**
	 * 参数为空
	 *
	 * @return
	 */
	public static Result isEmpty() {
		return new Result(ResultCode.RARAM_IS_BLANK);
	}

	/**
	 * 返回失败
	 *
	 * @param resultCode
	 * @return
	 */
	public static Result failure(ResultCode resultCode) {
		return new Result(resultCode);
	}

	/**
	 * 返回失败
	 *
	 * @param resultCode
	 * @param data
	 * @return
	 */
	public static Result failure(ResultCode resultCode,Object data) {
		return new Result(resultCode,data);
	}

	public static String getStrResult(ResultCode resultCode) {
		return JsonUtil.toPrettyJson(new Result(resultCode));
	}

	public static Result getResult(ResultCode resultCode) {
		return new Result(resultCode);
	}

	public static String getMyResult(Integer code,String message) {
		return JsonUtil.toPrettyJson(new Result(code,message));
	}

	public static Result getResult(Integer code,String message) {
		return new Result(code,message);
	}
}
