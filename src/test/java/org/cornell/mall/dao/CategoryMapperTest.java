package org.cornell.mall.dao;

import org.cornell.mall.MallApplicationTests;
import org.cornell.mall.pojo.Category;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryMapperTest extends MallApplicationTests {
    @Autowired
    private CategoryMapper categoryMapper;
    @Test
    public void findById() {
        Category byId = categoryMapper.selectByPrimaryKey(100001);
        System.out.println(byId);
    }

    @Test
    public void queryById() {
        Category id = categoryMapper.selectByPrimaryKey(100001);
        System.out.println(id);
    }
}