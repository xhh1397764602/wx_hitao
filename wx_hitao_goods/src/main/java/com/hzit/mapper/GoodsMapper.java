package com.hzit.mapper;

import java.util.List;
import java.util.Map;

import com.entity.ShopGoods;






public interface GoodsMapper {
	/**
	 * 查询商品
	 * @param map
	 * @return
	 */
	List<ShopGoods> pageData();
	/**
	 * 添加商品
	 * @param shopGoods
	 * @return
	 */
	int addGood(ShopGoods shopGoods);
	/**
	 * 修改商品
	 * @param shopGoods
	 * @return
	 */
	int updateGood(ShopGoods shopGoods);
	/**
	 * 删除商品
	 */
	int deleteGoods(int goodsId);
	/**
	 * 逻辑删除
	 * @param goodsId
	 * @return
	 */
	int isDel(ShopGoods shopGoods);
	/**
	 * 根据id查数据
	 * @param goodsId
	 * @return
	 */
	ShopGoods findOne(int goodsId);
	/**
	 * 获取商品总条数
	 * @return
	 */
	int getCount();
	ShopGoods checkout(Map<String, Object> map);
}
