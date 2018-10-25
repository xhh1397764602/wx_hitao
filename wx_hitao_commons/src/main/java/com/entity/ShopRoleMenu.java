package com.entity;

import java.io.Serializable;
/**
 * <p>
 * 角色菜单表
 * </p>
 *
 * @author xianyaoji
 * @since 2018-08-06
 */
public class ShopRoleMenu implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 编号
     */
    private Integer id;
    private Integer roleId;
    private Integer menuId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
 
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
 
    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
 


    @Override
    public String toString() {
        return "ShopRoleMenu{" +
        "id=" + id +
        ", roleId=" + roleId +
        ", menuId=" + menuId +
        "}";
    }
}