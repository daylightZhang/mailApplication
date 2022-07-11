package org.cornell.mall.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.cornell.mall.dao.UserMapper;
import org.cornell.mall.enums.ResponseEnum;
import org.cornell.mall.enums.RoleEnum;
import org.cornell.mall.pojo.User;
import org.cornell.mall.service.IUserService;
import org.cornell.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 注册方法的实现
     * @param user
     */
    @Override
    public ResponseVo<User> register(User user) {
        // 1.用户名不能重复
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if (countByUsername >= 1){
            return ResponseVo.error(ResponseEnum.USERNAME_EXIST);
        }
        // 2.email不能重复
        int countByEmail = userMapper.countByEmail(user.getEmail());
        if (countByEmail >= 1){
            return ResponseVo.error(ResponseEnum.EMAIL_EXIST);
        }
        user.setRole(RoleEnum.CUSTOMER.getCode());
        // 3.MD5加密密码
        user.setPassword(DigestUtils.md5DigestAsHex(
                user.getPassword().getBytes(StandardCharsets.UTF_8)
                ));
        //写入数据库
        int resultCount = userMapper.insertSelective(user);
        if (resultCount == 0){
            return ResponseVo.error(ResponseEnum.ERROR);
        }
        return ResponseVo.success();
    }

    @Override
    public ResponseVo<User> login(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            //用户名不存在
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }

        if (!user.getPassword().equalsIgnoreCase(
                DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)))){
            return ResponseVo.error(ResponseEnum.USERNAME_OR_PASSWORD_ERROR);
        }
        user.setPassword("");
        return ResponseVo.success(user);
    }
}
