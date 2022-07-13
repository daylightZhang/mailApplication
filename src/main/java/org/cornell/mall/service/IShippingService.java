package org.cornell.mall.service;

import com.github.pagehelper.PageInfo;
import org.cornell.mall.form.ShippingForm;
import org.cornell.mall.vo.ResponseVo;

import java.util.Map;

public interface IShippingService {
    /**
     * 添加地址的方法
     * @param uid
     * @param form
     * @return
     */
    ResponseVo<Map<String, Integer>> add(Integer uid, ShippingForm form);

    /**
     * 删除地址方法
     * @param uid
     * @param shippingId
     * @return
     */
    ResponseVo delete(Integer uid, Integer shippingId);

    /**
     * 更新地址
     * @param uid
     * @param shippingId
     * @param form
     * @return
     */
    ResponseVo update(Integer uid, Integer shippingId, ShippingForm form);

    /**
     * 得到地址列表
     * @param uid
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize);
}
