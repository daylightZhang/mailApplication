package org.cornell.mall.controller;

import lombok.extern.slf4j.Slf4j;
import org.cornell.mall.form.UserLoginForm;
import org.cornell.mall.form.UserRegisterForm;
import org.cornell.mall.pojo.User;
import org.cornell.mall.service.impl.UserServiceImpl;
import org.cornell.mall.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static org.cornell.mall.consts.MallConst.CURRENT_USER;


@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @PostMapping("/user/register")
    public ResponseVo<User> register(@Valid @RequestBody UserRegisterForm userRegisterForm){
        User user = new User();
        BeanUtils.copyProperties(userRegisterForm, user);
        return userService.register(user);
    }
    @PostMapping("/user/login")
    public ResponseVo<User> login(@Valid @RequestBody UserLoginForm userLoginForm,
                                  HttpSession httpSession){
        ResponseVo<User> userResponseVo = userService.login(userLoginForm.getUsername(), userLoginForm.getPassword());
        // 设置session
        httpSession.setAttribute(CURRENT_USER, userResponseVo.getData());
        log.info("/user/login sessionId={}", httpSession.getId());
        return userResponseVo;
    }
    @GetMapping("/user")
    public ResponseVo<User> userInfo(HttpSession session) {
        log.info("/user sessionId={}", session.getId());
        User user = (User)session.getAttribute(CURRENT_USER);
        return ResponseVo.success(user);
    }

    @PostMapping("/user/logout")
    public ResponseVo logout(HttpSession session){
        log.info("/user/logout sessionId={}", session.getId());
        User user = (User)session.getAttribute(CURRENT_USER);
        session.removeAttribute(CURRENT_USER);
        return ResponseVo.success();
    }
}
