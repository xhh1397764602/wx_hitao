package com.hzit.serviceimpl;

import java.util.List;

import com.entity.ShopGoodsCart;
import com.utils.ServerResponse;

public interface CartService {

	 /**
     * 添加商品到购物车中(如果该商品不存在购物中则添加到购物车中，如果已经存在，则修改购物中该商品的数量)
     * @param  memberId
     * @param shopGoodsCart
     * @return
     */
	ServerResponse addCart(Integer memberId,Integer number,Integer goodsId);

    /**
     * 删除购物车信息
     * @param memberId
     * @param goodsIds
     * @return
     */
	ServerResponse deleteCart(int memberId,Long[] goodsIds);

    /**
     * 获取购物车信息
     * @return
     */
	ServerResponse cartList(int memberId);

    /**
     * 编辑购物车信息
     * @param memberId
     * @param shopGoodsCart
     * @return
     */
	ServerResponse update(int memberId,ShopGoodsCart shopGoodsCart);

    /**
     * 获取会员的购物车商品数量
     * @param memberId
     * @return
     */
    long cartCount(int memberId);
}
