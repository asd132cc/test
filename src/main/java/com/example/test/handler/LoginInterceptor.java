package com.example.test.handler;

/**
 * 自定义拦截器,拦截controller中方法
 * 拦截后进行用户鉴权
 */

import com.example.test.annotation.LoginAuthorization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    private static Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        // 判断注解是否存在
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod method = (HandlerMethod) handler;
        boolean hasloginannotation = method.getMethod().isAnnotationPresent(
                LoginAuthorization.class);
        // 不存在登录验证注解，进入下一个拦截器或者controller中方法
        if (!hasloginannotation) {
            return true;
        }

        LoginAuthorization loginauthorization = method.getMethod()
                .getAnnotation(LoginAuthorization.class);

        // 登录状态检查
        String username = (String) request.getSession().getAttribute(
                loginauthorization.value());

        // 验证失败,使用response返回指定信息
        // 1.返回视图
        if (username == null || "".equals(username)) {
            switch (loginauthorization.value()) {
                case "userName":
                    if (log.isDebugEnabled()) {
                        log.debug("后台用户未登录");
                    }
                    response.sendRedirect("/keyboardproscenium/background/login");
                    break;
                default:
                    response.sendRedirect("404");
                    break;
            }

            /*
             //2.返回json消息 PrintWriter writer = null;
             response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
             response.setCharacterEncoding("UTF-8");
             response.setContentType("application/json; charset=utf-8");
             ObjectMapper objectmapper = new ObjectMapper(); //序列化为json字符串
             String
             string=objectmapper.writeValueAsString(Result.exception(Result
             .E_UNAUTHORIZED, "用户未登录!")); writer = response.getWriter();
             writer.print(string);
             */

            return false;
        } else {
            // 验证成功,进入下一个拦截器或者controller中方法
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse, Object o, Exception e)
            throws Exception {

    }

}
