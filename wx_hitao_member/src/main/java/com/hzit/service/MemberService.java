package com.hzit.service;

import java.util.List;

import com.entity.ShopAddress;
import com.entity.ShopMember;
import com.utils.MemberLoginUtil;
import com.utils.ServerResponse;

public interface MemberService {

	/**
	 * 登录验证
	 * @param shopMember
	 * @return
	 */
	ServerResponse<MemberLoginUtil> login(ShopMember shopMember);
	/**
	 * 添加会员
	 * @param shopMember
	 * @return
	 */
	ServerResponse<Integer> addMember(ShopMember shopMember);
	/**
	 * 编辑会员信息
	 * @param shopMember
	 * @return
	 */
	ServerResponse<Integer> updateById(ShopMember shopMember);
	ServerResponse<List<ShopAddress>> address(Integer memberId);
}
