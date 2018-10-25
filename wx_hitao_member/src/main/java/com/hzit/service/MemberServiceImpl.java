package com.hzit.service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.ShopAddress;
import com.entity.ShopMember;
import com.hzit.mapper.AddressMapper;
import com.hzit.mapper.MemberMapper;
import com.utils.JwtTokenUtil;
import com.utils.MemberLoginUtil;
import com.utils.ServerResponse;
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private AddressMapper addressMapper;
	@Override
	public ServerResponse<MemberLoginUtil> login(ShopMember shopMember) {
		if(shopMember.getPasswordSalt()==null||"".equals(shopMember.getPasswordSalt())||shopMember.getMemberName()==null||"".equals(shopMember.getMemberName()))
		{
			return ServerResponse.createByErrorMessage("登录失败！用户/密码为空");
		}else {
			ShopMember member=memberMapper.searchShopMember(shopMember);
			MemberLoginUtil mlu=new MemberLoginUtil();
			if(member==null) {
				return ServerResponse.createByErrorMessage("登录失败！用户/密码错误");
			}else {
				String memberId=member.getMemberId().toString();
				try {
					Map<String, Object> map=new HashMap<>();
					map.put("memberId", member.getMemberId());
					map.put("isDefault", 1);
					mlu.setToken(JwtTokenUtil.createToken(member.getMemberName(), memberId));
					mlu.setShopMember(member);
					mlu.setCartCount(1);
					mlu.setDefaultAddress(addressMapper.searchAddress(map).get(0));
					return ServerResponse.createBySuccess("登录成功",mlu);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
			}
			return null;
		}
		
	}
	@Override
	public ServerResponse<Integer> addMember(ShopMember shopMember) {
		ShopMember shopMember2=new ShopMember();
		shopMember2.setMemberName(shopMember.getMemberName());
		if(memberMapper.searchShopMember(shopMember2)!=null) {
			return ServerResponse.createBySuccessMessage("该用户名称已存在！");
		}else {
			int result=memberMapper.addMember(shopMember);
			if(result!=0) {
				return ServerResponse.createBySuccessMessage("注册成功！");
			}else {
				return ServerResponse.createByErrorMessage("注册失败！");
			}
		}
		
	}
	@Override
	public ServerResponse<Integer> updateById(ShopMember shopMember) {
		int result=memberMapper.updateById(shopMember);
		if(result!=0) {
			return ServerResponse.createBySuccessMessage("会员信息编辑成功！");
		}else {
			return ServerResponse.createByErrorMessage("会员信息编辑失败！");
		}
	}
	@Override
	public ServerResponse<List<ShopAddress>> address(Integer memberId) {
		Map<String, Object> map=new HashMap<>();
		map.put("memberId", memberId);
		return ServerResponse.createBySuccess(addressMapper.searchAddress(map));
	}

}
