package com.hzit.mapper;



import com.entity.ShopAddress;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 买家地址信息表 Mapper 接口
 * </p>
 *
 * @author xxh
 * @since 2018-10-23
 */
public interface AddressMapper{

    int addAddress(ShopAddress obj);

    int addAddressSelective(ShopAddress obj);

    int deleteById(int id);
                                            
    int deleteByIds(String[] ids);

    int updateById(ShopAddress address);

    int updateSelectiveById(ShopAddress address);

    ShopAddress findOne(Integer id);
                                            
    List<ShopAddress> searchAddress(Map<String,Object> map);
}