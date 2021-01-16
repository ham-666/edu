package com.edu.entity;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * 系统菜单实体
 *
 * @author ham
 */
@Data
public class SysMenu {
    /**
     * 菜单id
     */
    private String menuId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 父菜单id
     */
    private String parentMenuId = "0";

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 菜单链接地址
     */
    private String menuUrl = "#";

    /**
     * 菜单级别
     */
    private Integer menuLevel = 0;

    /**
     * 菜单顺序
     */
    private Integer menuSort = 0;

    /**
     * 激活标志符:0-未激活(默认)，1-已激活
     */
    private Integer active = 0;

    /**
     * 按钮列表
     */
    private Set<SysButton> buttons = new HashSet<>();
}
