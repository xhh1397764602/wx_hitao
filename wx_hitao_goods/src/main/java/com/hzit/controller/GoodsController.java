package com.hzit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.ShopFavorites;
import com.entity.ShopGoods;
import com.hzit.service.GoodsService;
import com.utils.CategoryContentUtil;
import com.utils.CategoryUtil;
import com.utils.GoodsMsgUtil;
import com.utils.ServerResponse;

@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private GoodsService service;
	/**
	 * 
	 * @return 返回首页商品信息
	 */
	@GetMapping("/findGoods")
	public ServerResponse<List<ShopGoods>> findGoods(){
		return service.findGoods();
	}
	/**
	 * 
	 * @param goodsId 商品id
	 * @return 商品详细信息
	 */
	@GetMapping("/details")
	public ServerResponse<GoodsMsgUtil> details(Integer goodsId,Integer memberId){
		return service.findGoodsById(goodsId,memberId);
	}
	/**
	 * 商品三级类目展示(只展示了食品下的二三级)
	 * @return
	 */
	@GetMapping("/frontCate")
	public ServerResponse<CategoryUtil> frontCate(@RequestParam(value="parentId",defaultValue="0") Integer parentId){
		return service.frontCate(parentId);
	}
	/**
	 * 商品总条数
	 * @return
	 */
	@GetMapping("/goodsCount")
	public ServerResponse<Integer> goodsCount(){
		return service.getCount();
	}
	/**
	 * 根据一级类目编号查询二三级
	 * @param frontCatId
	 * @return
	 */
	@GetMapping("/currentCate")
	public ServerResponse<List<CategoryContentUtil>> currentCate(Integer frontCatId){
		return service.currentCate(frontCatId);
	}
	/**
	 * 添加/取消收藏
	 * @param shopFavorites
	 * @return
	 */
	@PostMapping("/addOrDelete")
	public ServerResponse<Integer> addOrDelete(@RequestBody ShopFavorites shopFavorites){
		return service.addOrDelete(shopFavorites);
		
	}
	/**
	 * 查询库存
	 * @param goodsId
	 * @param number
	 * @return
	 */
	@GetMapping("/checkout")
	public ServerResponse<Integer> checkout(Integer goodsId,Integer number){
		return service.checkout(goodsId, number);
	}
}
