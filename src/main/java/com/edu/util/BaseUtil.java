package com.edu.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import cn.hutool.core.util.ArrayUtil;

/**
 * 基础工具
 * @author muhan
 *
 */
public final class BaseUtil {
	private BaseUtil() {
		throw new RuntimeException("工具类不能被实例！");
	}

	/**
	 * 获取数据库形式名称
	 *
	 * @param propertyName 属性名
	 * @return 数据库形式名称
	 */
	public static String getTableName(String propertyName) {
		char[] chars = propertyName.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i=0,len=chars.length;i<len;i++) {
			if(chars[i] > 96) {
				sb.append(chars[i]);
				continue;
			}
			if(0 != i) {
				sb.append('_');
			}
			sb.append((char)(chars[i]+32));
		}
		return sb.toString();
	}
	/**
	 * 获取属性字段
	 * @param tableName
	 * @return
	 */
	public static String getPropertyName(String tableName) {
		StringBuilder sb = new StringBuilder();
		char[] chars = tableName.toCharArray();
		char tmp;
		int p=0,len=chars.length;
		while(p<len) {
			tmp = chars[p];
			if('_' == tmp) {
				tmp = (char)(chars[++p]-32);
			}
			sb.append(tmp);
			p++;
		}
		return sb.toString();
	}
	/**
	 * 获取参数
	 * @param tableName
	 * @param idKey
	 * @param idVal
	 * @param desc
	 * @return
	 */
	public static Map<String,Object> getDeleteParam(String tableName, String idKey, Integer idVal, String desc, String sysUserNo) {
		Map<String,Object> deleteParam = new HashMap<>();
		deleteParam.put("tableName", tableName);
		deleteParam.put("tableId", idVal);
		deleteParam.put("condite", idKey+"="+idVal);
		deleteParam.put("deleteDesc", desc);
		deleteParam.put("sysUserNo", sysUserNo);
		return deleteParam;
	}
	/**
	  *  全条件
	 * @param <T>
	 * @param obj
	 * @param likes
	 * @return
	 */
	public static <T> String getCondition(Object obj, String...likes) {
		List<String> likeList = Arrays.asList(likes);
		Field[] fields = obj.getClass().getDeclaredFields();
		List<String> collect = Arrays.stream(fields)
		.map(field->{
			try {
				String fieldName = field.getName();
				String tbName = getTableName(fieldName);
				field.setAccessible(true);
				Object fieldVal = field.get(obj);
				if("isDelete".equals(fieldName)) {
					return String.format("%s=0",tbName);
				}
				if(null != fieldVal && !"serialVersionUID".equals(fieldName)) {
					return String.format("%s=%s",tbName,fieldVal);
				}
				return null;
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}).filter(condite -> null != condite)
		.collect(Collectors.toList());
		int len = collect.size();
		if(len == 0) {
			return "";
		}
		if(len == 1) {
			return String.format("where %s", collect.get(0));
		}
		String conition = collect.stream()
		.reduce((condite1,condite2)->String.format("%s and %s", condite1,condite2))
		.get();
		return  String.format("where %s", conition);
	}

	/**
	 * 获取in条件
	 * @param canditionName
	 * @param ids
	 * @return
	 */
	public static String getConditeIn(String canditionName, Integer[] ids) {
		return String.format("where %s in (%s)", canditionName, ArrayUtil.join(ids, ","));
	}
}
