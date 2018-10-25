package com.hzit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.ShopFavorites;
import com.hzit.service.FavoriteService;
import com.utils.ServerResponse;

@RestController
@RequestMapping("/fav")
public class FavoriteController {

	@Autowired
	private FavoriteService service;
	/**
	 * 获取收藏商品
	 * @param memberId
	 * @return
	 */
	@GetMapping("findFav")
	public ServerResponse<List<ShopFavorites>> findFavorites(Integer memberId){
		return service.findFavorites(memberId);
	}
	/**
	 * 删除收藏
	 * @param favId
	 * @return
	 */
	@GetMapping("delete")
	public ServerResponse<Integer> deleteFavorite(Integer favId) {
		return service.deleteFavorite(favId);
	}
}
