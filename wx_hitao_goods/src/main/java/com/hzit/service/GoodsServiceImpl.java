package com.hzit.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.entity.ShopFavorites;
import com.entity.ShopFrontCategory;
import com.entity.ShopGoods;
import com.hzit.mapper.FavoritesMapper;
import com.hzit.mapper.FrontCategoryMapper;
import com.hzit.mapper.GoodsAttrMapper;
import com.hzit.mapper.GoodsContentMapper;
import com.hzit.mapper.GoodsMapper;
import com.utils.CategoryContentUtil;
import com.utils.CategoryUtil;
import com.utils.GoodsAttrUtil;
import com.utils.GoodsMsgUtil;
import com.utils.ServerResponse;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsmapper;
	@Autowired
	private GoodsContentMapper goodsContentMapper;
	@Autowired
	private GoodsAttrMapper goodsAttrMapper;
	@Autowired
	private FrontCategoryMapper frontCategoryMapper;
	@Autowired
	private FavoritesMapper favoritesMapper;

	@Override
	public ServerResponse<List<ShopGoods>> findGoods() {
		return ServerResponse.createBySuccess(goodsmapper.pageData());
	}

	@Override
	public ServerResponse<GoodsMsgUtil> findGoodsById(int goodsId,Integer memberId) {
		GoodsMsgUtil goodsMsgUtil = new GoodsMsgUtil();
		String value = goodsAttrMapper.findGooodsById(goodsId).getAttrValue();
		List<GoodsAttrUtil> list = JSON.parseArray(value, GoodsAttrUtil.class);
		goodsMsgUtil.setGoodsAttr(list);
		goodsMsgUtil.setGoodsContent(goodsContentMapper.findGooodsById(goodsId));
		goodsMsgUtil.setIsFavorites(0);
		goodsMsgUtil.setShopGoods(goodsmapper.findOne(goodsId));
		if (goodsmapper.findOne(goodsId) == null) {
			return ServerResponse.createByErrorMessage("查询失败");
		} else {

			return ServerResponse.createBySuccess(goodsMsgUtil);
		}
	}

	@Override
	public ServerResponse<CategoryUtil> frontCate(Integer parentId) {
		CategoryUtil categoryUtil = new CategoryUtil();
		List<ShopFrontCategory> list = frontCategoryMapper.findCategoryByPId(parentId);
		categoryUtil.setCategory(list);
		categoryUtil.setCategoryContent(cate(list.get(0).getFrontCatId()));
		return ServerResponse.createBySuccess(categoryUtil);
	}

	@Override
	public ServerResponse<Integer> getCount() {
		return ServerResponse.createBySuccess(goodsmapper.getCount());
	}
    /**
     * 获取二三级类目
     */
	public List<CategoryContentUtil> cate(Integer catId){
		List<CategoryContentUtil> list2 = new ArrayList<>();
		List<ShopFrontCategory> list3 = frontCategoryMapper.findCategoryByPId(catId);
		for (int j = 0; j < list3.size(); j++) {
			CategoryContentUtil categoryContentUtil = new CategoryContentUtil();
			categoryContentUtil.setCatName(list3.get(j).getCatName());
			categoryContentUtil.setChildrens(frontCategoryMapper.findCategoryByPId(list3.get(j).getFrontCatId()));
			list2.add(categoryContentUtil);
		}
		return list2;
	}

	@Override
	public ServerResponse<List<CategoryContentUtil>> currentCate(Integer frontCatId) {
		
		return ServerResponse.createBySuccess(cate(frontCatId));
	}

	@Override
	public ServerResponse<Integer> addOrDelete(ShopFavorites shopFavorites) {
		if(favoritesMapper.findFavorite(shopFavorites)==null) {
			shopFavorites.setFavTime(new Date());
			ShopGoods shopGoods=goodsmapper.findOne(shopFavorites.getGoodsId());
			shopFavorites.setGoodsJingle(shopGoods.getGoodsJingle());
			shopFavorites.setGoodsName(shopGoods.getGoodsName());
			shopFavorites.setMainImage(shopGoods.getMainImage());
			int result=favoritesMapper.addFavorites(shopFavorites);
			if(result==0) {
				return ServerResponse.createByErrorMessage("收藏失败");
			}else {
				return ServerResponse.createBySuccessMessage("收藏成功");
			}
		}else {
			int result=favoritesMapper.deleteById(favoritesMapper.findFavorite(shopFavorites).getFavId());
			if(result==0) {
				return ServerResponse.createByErrorMessage("取消收藏失败");
			}else {
				return ServerResponse.createBySuccessMessage("取消收藏成功");
			}
		}
	}

	@Override
	public ServerResponse<Integer> checkout(Integer goodsId, Integer number) {
		Map<String,Object> map=new HashMap<>();
		map.put("goodsId", goodsId);
		map.put("goodsStorage", number);
		if(goodsmapper.checkout(map)!=null) {
			return ServerResponse.createBySuccessMessage("库存充裕");
		}
		return ServerResponse.createByErrorMessage("库存不足");
	}
	
}
