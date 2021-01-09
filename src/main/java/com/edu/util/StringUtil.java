package com.edu.util;

import cn.hutool.core.util.StrUtil;

/**
 * 字符串工具类
 *
 * @author ham
 */
public class StringUtil {
	private StringUtil() {
		throw new RuntimeException("工具类不能被实例化");
	}

	/**
	 * 空值判断
	 *
	 * @param str 值
	 * @return 判断结果
	 */
	public static boolean isEmpty(String str) {
		return StrUtil.isEmpty(str);
	}

	/**
	 * 非空判断
	 *
	 * @param str 值
	 * @return 判断结果
	 */
	public static boolean isNotEmpty(String str) {
		return StrUtil.isNotEmpty(str);
	}
}
