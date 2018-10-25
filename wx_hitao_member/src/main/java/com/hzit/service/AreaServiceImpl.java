package com.hzit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.ShopArea;
import com.hzit.mapper.ShopAreaMapper;
import com.utils.ServerResponse;

@Service
public class AreaServiceImpl implements AreaService {
	@Autowired
	private ShopAreaMapper mapper;

	@Override
	public ServerResponse<List<ShopArea>> findAreas(Integer areaParentId) {
		Map<String, Object> map=new HashMap<>();
		map.put("areaParentId", areaParentId);
		return ServerResponse.createBySuccess(mapper.searchShopArea(map));
	}

}
