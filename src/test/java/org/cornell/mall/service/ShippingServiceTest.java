package org.cornell.mall.service;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.cornell.mall.MallApplicationTests;
import org.cornell.mall.form.ShippingForm;
import org.cornell.mall.service.impl.ShippingServiceImpl;
import org.cornell.mall.vo.ResponseVo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ShippingServiceTest extends MallApplicationTests {
    @Autowired
    private ShippingServiceImpl shippingService;
    private Integer uid = 2;
    private Gson gson = new Gson();
    private ShippingForm form;
    @Before
    public void before(){
        form = new ShippingForm("张家口",
                "18888888",
                "62555555",
                "浙江",
                "温州",
                "朝阳区",
                "中南海",
                "114514");
    }

    @Test
    public void add() {
        ResponseVo responseVo = shippingService.add(uid, form);
        log.info("list={}", gson.toJson(responseVo));
    }

    @Test
    public void delete() {
        Integer shippingId = 6;
        ResponseVo responseVo = shippingService.delete(uid, shippingId);
        log.info("result={}", responseVo);
    }

    @Test
    public void update() {
        form.setReceiverCity("上海");
        ResponseVo responseVo = shippingService.update(2, 7, form);
        log.info("result={}", responseVo);
    }

    @Test
    public void list() {
        ResponseVo responseVo = shippingService.list(uid, 1, 10);
        log.info("result={}", gson.toJson(responseVo));
    }
}