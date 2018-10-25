package com.hzit.service;


import com.entity.ShopAddress;
import com.utils.ServerResponse;

public interface AddressService {

	ServerResponse<Integer> addAdress(ShopAddress shopAddress);
	ServerResponse<ShopAddress> findOne(Integer id);
	ServerResponse<Integer> updateAddress( ShopAddress shopAddress);
	ServerResponse<Integer> deleteById(Integer id);
}
