package com.edu.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 角色表
 *
 * @author ham
 */
@Data
public class SysRole {
    /**
     * 角色id
     */
    private String roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 菜单列表
     */
    private List<SysMenu> menus = new ArrayList<>();
}
