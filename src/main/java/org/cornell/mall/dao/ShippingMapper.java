package org.cornell.mall.dao;

import org.apache.ibatis.annotations.Param;
import org.cornell.mall.pojo.Shipping;

import java.util.List;
import java.util.Set;

public interface ShippingMapper {
    int deleteByPrimaryKey(Integer id);

    int deleteByIdAndUid(@Param("uid") Integer uid,
                         @Param("shippingId") Integer shippingId);

    int insert(Shipping record);

    int insertSelective(Shipping record);

    Shipping selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shipping record);

    int updateByPrimaryKey(Shipping record);

    List<Shipping> selectByUid(Integer uid);

    Shipping selectByUidAndShippingId(@Param("uid") Integer uid,
                                      @Param("shippingId") Integer shippingId);

    List<Shipping> selectByIdSet(@Param("idSet") Set idSet);
}