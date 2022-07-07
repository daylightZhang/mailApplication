package org.cornell.mall.service.impl;

import org.cornell.mall.MallApplicationTests;
import org.cornell.mall.enums.RoleEnum;
import org.cornell.mall.pojo.User;
import org.cornell.mall.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@Transactional
public class UserServiceImplTest extends MallApplicationTests {
    @Autowired
    private IUserService userService;
    @Test
    public void register() {
        User user = new User("jack", "123456", "jack@qq.com", RoleEnum.CUSTOMER.getCode()) ;
        userService.register(user);


    }
}