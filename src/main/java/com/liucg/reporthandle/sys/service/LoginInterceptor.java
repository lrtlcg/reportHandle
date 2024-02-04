package com.liucg.reporthandle.sys.service;

import com.alibaba.fastjson.JSONObject;
import com.liucg.reporthandle.pub.BizException;
import com.liucg.reporthandle.pub.ExceptionCodeEnum;
import com.liucg.reporthandle.utils.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求拦截器
 * @author MI
 * @date 2023/10/03
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    /***
     * 在请求处理之前进行调用(Controller方法调用之前)
     @param request
     @param response
     @param handler
     @return boolean
     @throws Exception
     */
    @Resource
    TokenUtil tokenUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("========================被拦截器拦截了");
        /**
         * 从请求头中取出token，并判断其是否存在和合法
         */
        String token = request.getHeader("token");
        boolean flag=false;
        if (token != null && tokenUtil.verifyToken(token)) {
            flag=true;

        }else {
            flag=false;
            throw new BizException(ExceptionCodeEnum.INVALID_TOKEN);
        }
        return flag;
    }

    /***
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     @param request
     @param response
     @param handler
     @param modelAndView
     @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    /***
     * 整个请求结束之后被调用，也就是在DispatchServlet渲染了对应的视图之后执行（主要用于进行资源清理工作）
     @param request
     @param response
     @param handler
     @param ex
     @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}


