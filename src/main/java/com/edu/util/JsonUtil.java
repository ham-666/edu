package com.edu.util;

import cn.hutool.json.JSONUtil;

/**
 * JSON解析工具
 *
 * @author muhan
 *
 */
public class JsonUtil {
	private JsonUtil() {
		throw new RuntimeException("工具类不能被实例化");
	}

	/**
	   * 对象转json
	 * @param obj
	 * @return
	 */
	public static String toPrettyJson(Object obj) {
		return JSONUtil.toJsonPrettyStr(obj);
	}

	/**
	   * 对象转json
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		return JSONUtil.toJsonStr(obj);
	}
}
