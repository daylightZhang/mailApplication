package org.cornell.mall.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.cornell.mall.MallApplicationTests;
import org.cornell.mall.form.CartAddForm;
import org.cornell.mall.form.CartUpdateForm;
import org.cornell.mall.service.impl.CartServiceImpl;
import org.cornell.mall.vo.CartVo;
import org.cornell.mall.vo.ResponseVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class CartServiceTest extends MallApplicationTests {
    @Autowired
    private CartServiceImpl cartService;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Test
    public void add() {
        CartAddForm form = new CartAddForm();
        form.setProductId(29);
        form.setSelected(true);
        ResponseVo<CartVo> list = cartService.add(2, form);
        log.info("list={}", gson.toJson(list));
    }

    @Test
    public void listTest(){
        ResponseVo<CartVo> list = cartService.list(1);
        log.info("list={}", gson.toJson(list));
    }

    @Test
    public void update(){
        CartUpdateForm form = new CartUpdateForm();
        form.setQuantity(10);
        form.setSelected(false);
        ResponseVo<CartVo> responseVo = cartService.update(1, 26, form);
        log.info("list={}", gson.toJson(responseVo));
    }
    @Test
    public void delete() {
        ResponseVo<CartVo> responseVo = cartService.delete(1, 26);
        log.info("list={}", gson.toJson(responseVo));
    }
    @Test
    public void selectAll() {
        ResponseVo<CartVo> responseVo = cartService.selectAll(1);
        log.info("list={}", gson.toJson(responseVo));
    }
    @Test
    public void unSelectAll() {
        ResponseVo<CartVo> responseVo = cartService.unSelectAll(1);
        log.info("list={}", gson.toJson(responseVo));
    }
    @Test
    public void sum() {
        ResponseVo<Integer> responseVo = cartService.sum(1);
        log.info("list={}", gson.toJson(responseVo));
    }
}