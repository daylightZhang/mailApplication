package org.cornell.mall.service.impl;

import org.cornell.mall.dao.UserMapper;
import org.cornell.mall.pojo.User;
import org.cornell.mall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 注册方法的实现
     * @param user
     */
    @Override
    public void register(User user) {
        // 1.用户名不能重复
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if (countByUsername > 1){
            throw new RuntimeException("该username已注册");
        }
        // 2.email不能重复
        int countByEmail = userMapper.countByEmail(user.getEmail());
        if (countByEmail > 1){
            throw new RuntimeException("该email已注册");
        }
        // 3.MD5加密密码
        user.setPassword(DigestUtils.md5DigestAsHex(
                user.getPassword().getBytes(StandardCharsets.UTF_8)
                ));
        //写入数据库
        int resultCount = userMapper.insertSelective(user);
        if (resultCount == 0){
            throw new RuntimeException("注册失败");
        }
    }
}
