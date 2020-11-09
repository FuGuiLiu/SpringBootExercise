package com.sky.idea.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author Administrator
 */
public class CustomizeLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
//        获取请求的语言环境
        String language = request.getParameter("lang");

//获取默认的语言环境
        Locale locale = Locale.getDefault();
        //如果请求的参数是国际化配置
        if (!StringUtils.isEmpty(language)) {
            //将请求的语言拆分为国家和地区
            String[] ca = language.split("_");
            //如果请求的语言环境不为空则重新创建一个新的语言环境交给解析器解析
            locale = new Locale(ca[0], ca[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
