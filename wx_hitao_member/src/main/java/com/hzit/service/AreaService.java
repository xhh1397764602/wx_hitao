package com.hzit.service;

import java.util.List;

import com.entity.ShopArea;
import com.utils.ServerResponse;

public interface AreaService {

	ServerResponse<List<ShopArea>> findAreas(Integer areaParentId);
}
