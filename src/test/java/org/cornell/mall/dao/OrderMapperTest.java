package org.cornell.mall.dao;

import org.cornell.mall.MallApplicationTests;
import org.cornell.mall.pojo.OrderItem;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class OrderMapperTest extends MallApplicationTests {
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
        OrderItem item = orderItemMapper.selectByPrimaryKey(1);
        System.out.println(item);
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}