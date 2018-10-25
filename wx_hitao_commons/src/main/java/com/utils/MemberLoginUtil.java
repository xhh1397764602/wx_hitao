package com.utils;

import com.entity.ShopAddress;
import com.entity.ShopMember;

public class MemberLoginUtil {

	private Integer cartCount;
	private ShopMember shopMember;
	private String token;
	private ShopAddress defaultAddress;
	public Integer getCartCount() {
		return cartCount;
	}
	public void setCartCount(Integer cartCount) {
		this.cartCount = cartCount;
	}
	public ShopMember getShopMember() {
		return shopMember;
	}
	public void setShopMember(ShopMember shopMember) {
		this.shopMember = shopMember;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public ShopAddress getDefaultAddress() {
		return defaultAddress;
	}
	public void setDefaultAddress(ShopAddress defaultAddress) {
		this.defaultAddress = defaultAddress;
	}
	
}
