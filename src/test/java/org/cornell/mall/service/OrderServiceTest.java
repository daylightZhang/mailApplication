package org.cornell.mall.service;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.cornell.mall.MallApplicationTests;
import org.cornell.mall.form.CartAddForm;
import org.cornell.mall.service.impl.CartServiceImpl;
import org.cornell.mall.service.impl.OrderServiceImpl;
import org.cornell.mall.vo.CartVo;
import org.cornell.mall.vo.OrderVo;
import org.cornell.mall.vo.ResponseVo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
public class OrderServiceTest extends MallApplicationTests {
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private CartServiceImpl cartService;
    private Integer uid = 2;
    private Integer shippingId = 7;
    private Gson gson = new Gson();
    //@Test
    public ResponseVo<OrderVo> creare() {
        ResponseVo<OrderVo> orderVoResponseVo = orderService.creare(uid, shippingId);
        log.info("result = {}", gson.toJson(orderVoResponseVo));
        return orderVoResponseVo;
    }

    @Before
    public void add() {
        CartAddForm form = new CartAddForm();
        form.setProductId(29);
        form.setSelected(true);
        ResponseVo<CartVo> list = cartService.add(2, form);
        log.info("list={}", gson.toJson(list));
    }

    @Test
    public void list() {
        ResponseVo<PageInfo> responseVo = orderService.list(uid, 1, 10);
        log.info("result={}", gson.toJson(responseVo));
    }
    @Test
    public void detail() {
        ResponseVo<OrderVo> vo = creare();
        ResponseVo<OrderVo> responseVo = orderService.detail(uid, vo.getData().getOrderNo());
        log.info("result={}", gson.toJson(responseVo));
    }
    @Test
    public void cancel(){
        ResponseVo<OrderVo> vo = creare();
        ResponseVo responseVo = orderService.cancel(uid, vo.getData().getOrderNo());
        log.info("result={}", gson.toJson(responseVo));
    }
}