package com.hzit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.ShopArea;
import com.hzit.service.AreaService;
import com.utils.ServerResponse;

@RestController
@RequestMapping("/area")
public class AreaController {

	@Autowired
	private AreaService service;
	@GetMapping("getShopArea")
	public ServerResponse<List<ShopArea>> findAreas(@RequestParam(value="areaParentId",defaultValue="0") Integer areaParentId){
		return service.findAreas(areaParentId);
	}
}
