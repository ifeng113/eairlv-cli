package com.eairlv.cli.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lv
 * @create 2018-10-31 17:53
 * @desc
 **/
@Log4j2
public class InterceptorConfig implements HandlerInterceptor {

    public static final String JWT_HEADER = "Authorization";

    public static final ThreadLocal<String> JWT = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String jwt = request.getHeader(JWT_HEADER);
        if (jwt != null){
            JWT.set(jwt);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        JWT.remove();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
