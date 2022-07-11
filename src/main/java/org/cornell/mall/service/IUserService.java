package org.cornell.mall.service;

import org.cornell.mall.pojo.User;
import org.cornell.mall.vo.ResponseVo;

public interface IUserService {
    /**
     * TODO
     * 1.注册功能
     * 2.登录功能
     */
    ResponseVo<User> register(User user);
    ResponseVo<User> login(String username, String password);
}
