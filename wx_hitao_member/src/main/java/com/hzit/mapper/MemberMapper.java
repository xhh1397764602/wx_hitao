package com.hzit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.entity.ShopMember;
@Mapper
public interface MemberMapper {
	/**
	 * 通过ID查询会员
	 * @param i
	 * @return
	 */
	public ShopMember memberById(int memberId);
	/**
	 * 通过会员ID逻辑删除
	 */
	public int memberIsDel(@Param("memberId")int memberId,@Param("isDel")int isDel);
	/**
	 * 查询分页查询会员
	 * @param map
	 * @return
	 */
	List<ShopMember> pageData();
	/**
	 * 添加会员
	 * @param shopMember
	 * @return
	 */
	public int addMember(ShopMember shopMember);
	/**
	 * 根据ID修改数据
	 */
	public int updateById(ShopMember shopMember);
	/**
	 * 根据条件查询数据
	 * @param shopMember
	 * @return
	 */
	ShopMember searchShopMember(ShopMember shopMember);
}
