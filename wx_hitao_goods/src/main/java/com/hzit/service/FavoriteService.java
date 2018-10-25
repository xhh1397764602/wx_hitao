package com.hzit.service;

import java.util.List;

import com.entity.ShopFavorites;
import com.utils.ServerResponse;

public interface FavoriteService {

	ServerResponse<List<ShopFavorites>> findFavorites(Integer memberId);
	ServerResponse<Integer> deleteFavorite(Integer favId);
}
