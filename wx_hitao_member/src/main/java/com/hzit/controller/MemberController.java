package com.hzit.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.ShopAddress;
import com.entity.ShopMember;
import com.hzit.service.MemberService;
import com.utils.MemberLoginUtil;
import com.utils.ServerResponse;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService service;
	/**
	 * 登录验证
	 * @param shopMember
	 * @return
	 */
	@PostMapping("/login")
	public ServerResponse<MemberLoginUtil> checklogin(@RequestBody ShopMember shopMember){
		return service.login(shopMember);
	}
	/**
	 * 注册会员
	 * @param shopMember
	 * @return
	 */
	@PostMapping("/register")
	public ServerResponse<Integer> register(@RequestBody ShopMember shopMember){
		return service.addMember(shopMember);
	} 
	/**
	 * 编辑会员信息
	 * @param shopMember
	 * @return
	 */
	@PostMapping("/update")
	public ServerResponse<Integer> update(@RequestBody ShopMember shopMember){
		return service.updateById(shopMember);
	}
	/**
	 * 获取收货地址列表
	 * @param memberId
	 * @return
	 */
	@GetMapping("/address")
	public ServerResponse<List<ShopAddress>> address(Integer memberId){
		return service.address(memberId);
	} 
}
