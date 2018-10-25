package com.entity;

import java.util.Arrays;

public class CartUtil {

	private Integer number;
	private Integer goodsId;
	private Integer memberId;
	private Integer[] goodsIds;
	public Integer[] getGoodsIds() {
		return goodsIds;
	}
	public void setGoodsIds(Integer[] goodsIds) {
		this.goodsIds = goodsIds;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	@Override
	public String toString() {
		return "CartUtil [number=" + number + ", goodsId=" + goodsId + ", memberId=" + memberId + ", goodsIds="
				+ Arrays.toString(goodsIds) + "]";
	}
	
}
