package com.hzit.service;

import java.util.List;

import com.entity.ShopFavorites;
import com.entity.ShopGoods;
import com.utils.CategoryContentUtil;
import com.utils.CategoryUtil;
import com.utils.GoodsMsgUtil;
import com.utils.ServerResponse;


public interface GoodsService {

	ServerResponse<List<ShopGoods>> findGoods();
	ServerResponse<GoodsMsgUtil> findGoodsById(int goodsId,Integer memberId);
    ServerResponse<CategoryUtil> frontCate(Integer parentId);
    ServerResponse<Integer> getCount();
    ServerResponse<List<CategoryContentUtil>> currentCate(Integer frontCatId);
    ServerResponse<Integer>  addOrDelete(ShopFavorites shopFavorites);
    ServerResponse<Integer> checkout(Integer goodsId,Integer number);
}
