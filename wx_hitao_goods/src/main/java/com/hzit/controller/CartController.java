package com.hzit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.CartUtil;
import com.hzit.serviceimpl.CartService;
import com.utils.ServerResponse;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	
	@PostMapping("/add")
public ServerResponse add(@RequestBody CartUtil cartUtil) {
		return cartService.addCart(cartUtil.getMemberId(),cartUtil.getNumber(), cartUtil.getGoodsId());
	}
}
