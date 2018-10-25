package com.hzit.mapper;

import com.entity.ShopFrontCategory;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xxh
 * @since 2018-10-24
 */
public interface FrontCategoryMapper{

    int addFrontCategory(ShopFrontCategory obj);

    int addFrontCategorySelective(ShopFrontCategory obj);

    int deleteById(int frontCatId);
                                        
    int deleteByIds(String[] ids);

    int updateById(ShopFrontCategory frontCategory);

    int updateSelectiveById(ShopFrontCategory frontCategory);

    ShopFrontCategory findOne(Integer frontCatId);
                                        
    List<ShopFrontCategory> searchFrontCategory(Map<String,Object> map);
    
    List<ShopFrontCategory> findCategoryByPId(int parentId);
}