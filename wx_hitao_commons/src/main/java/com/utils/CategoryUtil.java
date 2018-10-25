package com.utils;

import java.util.List;

import com.entity.ShopFrontCategory;

public class CategoryUtil {

	private List<ShopFrontCategory> category;
	private List<CategoryContentUtil> categoryContent;
	public List<ShopFrontCategory> getCategory() {
		return category;
	}
	public void setCategory(List<ShopFrontCategory> category) {
		this.category = category;
	}
	public List<CategoryContentUtil> getCategoryContent() {
		return categoryContent;
	}
	public void setCategoryContent(List<CategoryContentUtil> categoryContent) {
		this.categoryContent = categoryContent;
	}
	
}
