package org.cornell.mall;

import lombok.extern.slf4j.Slf4j;
import org.cornell.mall.consts.MallConst;
import org.cornell.mall.exception.UserLoginException;
import org.cornell.mall.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle...");
        User user = (User) request.getSession().getAttribute(MallConst.CURRENT_USER);
        if (user != null) {
            log.info("user=null");
            throw new UserLoginException();
            //return ResponseVo.error(ResponseEnum.NEED_LOGIN);
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
