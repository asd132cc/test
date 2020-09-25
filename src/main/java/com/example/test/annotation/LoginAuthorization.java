package com.example.test.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解,用于用户登录鉴权
 * 由com.ssm.handler.LoginInterceptor拦截器检测是否存在以及调用相应方法
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LoginAuthorization {


    String backgoundusername = "userName";//后台用户session键值

    String value();
}
