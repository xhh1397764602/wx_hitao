package com.hzit.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.entity.ShopArea;
/**
 * 地区表mapper接口
 * @param map
 * @return
 */
public interface ShopAreaMapper {
	/**
	 * 添加区域
	 * @param obj
	 * @return
	 */
    int addShopArea(ShopArea obj);
    /**
     * 动态添加
     * @param obj
     * @return
     */
    int addShopAreaSelective(ShopArea obj);
    /**
     * 通过ID删除
     * @param areaId
     * @return
     */
    int deleteById(int areaId);
    /**
     * 通过ID删除多个
     * @param ids
     * @return
     */
    int deleteByIds(String[] ids);
    /**
     * 通过ID更新
     * @param shopArea
     * @return
     */
    int updateById(ShopArea shopArea);
    /**
     * 通过ID动态更新
     * @param shopArea
     * @return
     */
    int updateSelectiveById(ShopArea shopArea);
    /**
     * ID查询
     * @param areaId
     * @return
     */
    ShopArea findOne(Integer areaId);
    /**
     * 对象查询
     * @param map
     * @return
     */
    List<ShopArea> searchShopArea(Map<String,Object> map);
}
