package org.cornell.mall.service;

import lombok.extern.slf4j.Slf4j;
import org.cornell.mall.MallApplicationTests;
import org.cornell.mall.enums.ResponseEnum;
import org.cornell.mall.service.impl.CategoryServiceImpl;
import org.cornell.mall.vo.CategoryVo;
import org.cornell.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
@Slf4j
public class CategoryServiceTest extends MallApplicationTests {
    @Autowired
    private CategoryServiceImpl categoryService;
    @Test
    public void selectAll() {
        ResponseVo<List<CategoryVo>> listResponseVo = categoryService.selectAll();
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), listResponseVo.getStatus());
    }

    @Test
    public void findSubCategoryId() {
        Set<Integer> result = new HashSet<>();
        categoryService.findSubCategory(100001, result);
        log.info("result = {}", result);
    }
}