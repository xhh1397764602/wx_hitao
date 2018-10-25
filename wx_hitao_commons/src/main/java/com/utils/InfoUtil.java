package com.utils;

import java.util.List;

import com.entity.ShopAdmin;


public class InfoUtil {
 
	private ShopAdmin shopAdmin;
	private List<Permissions> permissions;
	private String[] roles;
	private  String avatar;
	public ShopAdmin getShopAdmin() {
		return shopAdmin;
	}
	public void setShopAdmin(ShopAdmin shopAdmin) {
		this.shopAdmin = shopAdmin;
	}
	public List<Permissions> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permissions> permissions) {
		this.permissions = permissions;
	}

	public String[] getRoles() {
		return roles;
	}
	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	public  String getAvatar() {
		return avatar;
	}
	public  void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
}
