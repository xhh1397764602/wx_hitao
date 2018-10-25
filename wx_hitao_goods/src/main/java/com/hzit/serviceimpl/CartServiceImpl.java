package com.hzit.serviceimpl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.ShopGoods;
import com.entity.ShopGoodsCart;
import com.hzit.dao.CartMapper;
import com.hzit.mapper.GoodsMapper;
import com.utils.ServerResponse;
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper;
	
	@Autowired
	private GoodsMapper goodsMapper;
	@Override
	public ServerResponse addCart(Integer memberId,Integer number,Integer goodsId) {
		ShopGoodsCart shopGoodsCart=new ShopGoodsCart();
		ShopGoods shopGoods=goodsMapper.findOne(goodsId);
		shopGoodsCart.setGoodsId(goodsId);
		shopGoodsCart.setNumber(number);
		shopGoodsCart.setGoodsJingle(shopGoods.getGoodsJingle());
		shopGoodsCart.setGoodsPrice(shopGoods.getGoodsPrice());
		shopGoodsCart.setMainImage(shopGoods.getMainImage());
		shopGoodsCart.setTotalFee(shopGoods.getGoodsPrice().multiply(new BigDecimal(shopGoodsCart.getNumber())));
		boolean result=cartMapper.addCart(memberId, shopGoodsCart);
		if(result) {
			return ServerResponse.createBySuccessMessage("该商品已经添加到购物车中！");
		}
		return ServerResponse.createBySuccessMessage("该商品已存在购物车中！");
	}

	@Override
	public ServerResponse deleteCart(int memberId, Long[] goodsIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerResponse cartList(int memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServerResponse update(int memberId, ShopGoodsCart shopGoodsCart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long cartCount(int memberId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
