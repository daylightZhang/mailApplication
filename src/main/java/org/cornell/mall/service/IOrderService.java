package org.cornell.mall.service;

import com.github.pagehelper.PageInfo;
import org.cornell.mall.vo.OrderVo;
import org.cornell.mall.vo.ResponseVo;

public interface IOrderService {

    ResponseVo<OrderVo> creare(Integer uid, Integer shippingId);

    ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize);

    ResponseVo<OrderVo> detail(Integer uid, Long orderNo);

    ResponseVo cancel(Integer uid, Long orderNo);

    void paid(Long orderNo);
}
