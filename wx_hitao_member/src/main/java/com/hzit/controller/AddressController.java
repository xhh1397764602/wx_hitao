package com.hzit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.ShopAddress;
import com.hzit.service.AddressService;
import com.utils.ServerResponse;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService service;
	/**
	 * 添加收货地址
	 * @param shopAddress
	 * @return
	 */
	@PostMapping("/add")
	public ServerResponse<Integer> addAdress(@RequestBody ShopAddress shopAddress){
		return service.addAdress(shopAddress);
	}
	/**
	 * 根据id查收收货地址
	 * @param id
	 * @return
	 */
	@GetMapping("findOne")
	public ServerResponse<ShopAddress> findOne(Integer id){
		return service.findOne(id);
	}
	/**
	 * 编辑收货地址
	 * @param shopAddress
	 * @return
	 */
	@PostMapping("/updateAddress")
	public ServerResponse<Integer> updateAddress(@RequestBody ShopAddress shopAddress){
		return service.updateAddress(shopAddress);
	}
	/**
	 * 根据id删除收货地址
	 * @param id
	 * @return
	 */
	@GetMapping("/deleteById")
	public ServerResponse<Integer> deleteById(Integer id){
		return service.deleteById(id);
	}
}
