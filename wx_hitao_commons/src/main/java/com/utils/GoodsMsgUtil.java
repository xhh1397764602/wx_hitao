package com.utils;

import java.util.List;

import com.entity.ShopGoods;
import com.entity.ShopGoodsContent;

public class GoodsMsgUtil {

	private ShopGoods shopGoods;
	private ShopGoodsContent goodsContent;
	private List<GoodsAttrUtil> goodsAttr;
	private Integer isFavorites;
	public ShopGoods getShopGoods() {
		return shopGoods;
	}
	public void setShopGoods(ShopGoods shopGoods) {
		this.shopGoods = shopGoods;
	}
	public ShopGoodsContent getGoodsContent() {
		return goodsContent;
	}
	public void setGoodsContent(ShopGoodsContent goodsContent) {
		this.goodsContent = goodsContent;
	}
	public Integer getIsFavorites() {
		return isFavorites;
	}
	public void setIsFavorites(Integer isFavorites) {
		this.isFavorites = isFavorites;
	}
	public List<GoodsAttrUtil> getGoodsAttr() {
		return goodsAttr;
	}
	public void setGoodsAttr(List<GoodsAttrUtil> goodsAttr) {
		this.goodsAttr = goodsAttr;
	}
	
}
