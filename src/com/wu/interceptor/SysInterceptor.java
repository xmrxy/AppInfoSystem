package com.wu.interceptor;

import com.wu.pojo.BackendUser;
import com.wu.pojo.DevUser;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        DevUser devUser = (DevUser) request.getSession().getAttribute("devUser");
        BackendUser backendUser = (BackendUser) request.getSession().getAttribute("backendUser");
        if (devUser!=null||backendUser!=null){
            return true;
        }else {
            response.sendRedirect(request.getContextPath()+"/403.jsp");
            return false;
        }


    }
}
