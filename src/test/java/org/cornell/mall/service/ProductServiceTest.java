package org.cornell.mall.service;

import com.github.pagehelper.PageInfo;
import org.cornell.mall.MallApplicationTests;
import org.cornell.mall.enums.ResponseEnum;
import org.cornell.mall.service.impl.ProductServiceImpl;
import org.cornell.mall.vo.ProductDetailVo;
import org.cornell.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceTest extends MallApplicationTests {
    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void list() {
        ResponseVo<PageInfo> responseVo = productService.list(null, 1, 1);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
    @Test
    public void detail() {
        ResponseVo<ProductDetailVo> responseVo = productService.detail(26);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}