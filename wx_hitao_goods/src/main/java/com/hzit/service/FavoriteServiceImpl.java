package com.hzit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.ShopFavorites;
import com.hzit.mapper.FavoritesMapper;
import com.utils.ServerResponse;
@Service
public class FavoriteServiceImpl implements FavoriteService {

	@Autowired
	private FavoritesMapper mapper;
	@Override
	public ServerResponse<List<ShopFavorites>> findFavorites(Integer memberId) {
		Map<String, Object> map=new HashMap<>();
		map.put("memberId", memberId);
		return ServerResponse.createBySuccess(mapper.searchFavorites(map));
	}

	@Override
	public ServerResponse<Integer> deleteFavorite(Integer favId) {
		int result=mapper.deleteById(favId);
		if(result!=0) {
		return	ServerResponse.createBySuccessMessage("删除成功！");
		}else {
			return ServerResponse.createByErrorMessage("删除失败！");
		}
	}

}
