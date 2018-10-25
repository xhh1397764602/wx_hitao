package com.utils;

import java.util.List;

import com.entity.ShopFrontCategory;

public class CategoryContentUtil {
 private String catName;
 private Integer catId;
 private List<ShopFrontCategory> childrens;
public String getCatName() {
	return catName;
}
public void setCatName(String catName) {
	this.catName = catName;
}
public Integer getCatId() {
	return catId;
}
public void setCatId(Integer catId) {
	this.catId = catId;
}
public List<ShopFrontCategory> getChildrens() {
	return childrens;
}
public void setChildrens(List<ShopFrontCategory> childrens) {
	this.childrens = childrens;
}
 
}
