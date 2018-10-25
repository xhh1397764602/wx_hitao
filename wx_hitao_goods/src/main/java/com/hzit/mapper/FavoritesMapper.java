package com.hzit.mapper;



import com.entity.ShopFavorites;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 买家收藏表 Mapper 接口
 * </p>
 *
 * @author xxh
 * @since 2018-10-24
 */
public interface FavoritesMapper{

    int addFavorites(ShopFavorites obj);

    int addFavoritesSelective(ShopFavorites obj);

    int deleteById(int favId);
                                
    int deleteByIds(String[] ids);

    int updateById(ShopFavorites favorites);

    int updateSelectiveById(ShopFavorites favorites);

    ShopFavorites findOne(Integer favId);
                                
    List<ShopFavorites> searchFavorites(Map<String,Object> map);
    
    ShopFavorites findFavorite(ShopFavorites favorites);
}