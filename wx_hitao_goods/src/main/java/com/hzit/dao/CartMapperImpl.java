package com.hzit.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.entity.ShopGoodsCart;
@Component
public class CartMapperImpl implements CartMapper {
	@Autowired
	private RedisTemplate redisTemplate;
	@Override
	public boolean addCart(int memberId, ShopGoodsCart shopGoodsCart) {
		HashOperations<String, Integer, Object> hash=redisTemplate.opsForHash();
		String memberId2=String.valueOf(memberId);
		ShopGoodsCart sgc=(ShopGoodsCart)hash.get(memberId2, shopGoodsCart.getGoodsId());
		//System.out.println(sgc);
		if(sgc==null) {
			hash.put(memberId2, shopGoodsCart.getGoodsId(), shopGoodsCart);
			return true;
		}else {
			sgc.setNumber(sgc.getNumber()+shopGoodsCart.getNumber());
			hash.put(memberId2, shopGoodsCart.getGoodsId(), shopGoodsCart);
			return false;
		}
	}

	@Override
	public boolean deleteCart(int memberId, Long[] goodsIds) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ShopGoodsCart> cartList(int memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(int memberId, ShopGoodsCart shopGoodsCart) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long cartCount(int memberId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
