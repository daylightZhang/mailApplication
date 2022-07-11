package org.cornell.mall.service.impl;

import org.cornell.mall.MallApplicationTests;
import org.cornell.mall.enums.ResponseEnum;
import org.cornell.mall.enums.RoleEnum;
import org.cornell.mall.pojo.User;
import org.cornell.mall.service.IUserService;
import org.cornell.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserServiceImplTest extends MallApplicationTests {
    public static final String USERNAME = "joseph";
    public static final String PASSWORD = "123456";
    @Autowired
    private IUserService userService;
    @Test
    public void register() {
        User user = new User(USERNAME, PASSWORD, "jfs9@cornell.com", RoleEnum.CUSTOMER.getCode()) ;
        ResponseVo<User> responseVo = userService.register(user);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
    @Test
    public void login(){
        register();
        ResponseVo<User> responseVo = userService.login(USERNAME, PASSWORD);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(), responseVo.getStatus());
    }
}