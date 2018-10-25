package com.hzit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.ShopAddress;
import com.hzit.mapper.AddressMapper;
import com.utils.ServerResponse;
@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressMapper mapper;

	@Override
	public ServerResponse<Integer> addAdress(ShopAddress shopAddress) {
		int result=mapper.addAddress(shopAddress);
		if(result!=0) {
			return ServerResponse.createBySuccessMessage("添加成功！");
		}else{
			return ServerResponse.createByErrorMessage("添加失败！");
		}
	}

	@Override
	public ServerResponse<ShopAddress> findOne(Integer id) {
		
		return ServerResponse.createBySuccess(mapper.findOne(id));
	}

	@Override
	public ServerResponse<Integer> updateAddress(ShopAddress shopAddress) {
		int result=mapper.updateById(shopAddress);
		if(result!=0) {
			return ServerResponse.createBySuccessMessage("编辑成功！");
		}else {
			return ServerResponse.createByErrorMessage("编辑失败！");
		}
	}

	@Override
	public ServerResponse<Integer> deleteById(Integer id) {
		int result =mapper.deleteById(id);
		if(result!=0) {
			return ServerResponse.createBySuccessMessage("删除成功！");
		}else {
			return ServerResponse.createByErrorMessage("删除失败！");
		}
	}

}
