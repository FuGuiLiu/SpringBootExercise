package com.sky.idea.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author Administrator
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    public DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //设置所有人都可以访问
        http.authorizeRequests().antMatchers("/").permitAll()
//                添加路径匹配器只有vip1可以访问
                .antMatchers("/level1/**").hasRole("vip1")
//        添加路径匹配器只有vip2可以访问
                .antMatchers("/level2/**").hasRole("vip2")
//        添加路径匹配器只有vip3可以访问
                .antMatchers("/level3/**").hasRole("vip3");

        //开启登录授权功能  loginPage() 填写用户信息的页面    loginProcessingUrl()具体处理用户信息
        http.formLogin().loginPage("/toLogin").loginProcessingUrl("/login");

        //关闭csrf防攻击功能
        http.csrf().disable();

        //开启注销功能  logout注销  deleteCookie删除 cookie  invalidateHttpSession()是否清空session true为清空,false 反之,
        // logoutSuccessUrl()登出成功跳转到的页面
        http.logout().deleteCookies("remove").invalidateHttpSession(false).logoutSuccessUrl("/");

//        开启记住我功能   rememberMeParameter() 自定义记住我保存信息到cookie中,参数与表单name属性一直
        http.rememberMe().rememberMeParameter("rememberMe");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        inMemoryAuthentication  是在对内存中权限用户镜像判定  passwordEncoder 密码编码器用来加密,不加密的话版本可能不支持,使用 BCryptPasswordEncoder加密密码
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                // withUser 内存中用户名   password 内存中的密码  roles 角色认证的类型,也就是对应的角色,可以访问页面的权限  and()方法用来拼接添加多内存用户实现不同用户权限
                .withUser("root").password(new BCryptPasswordEncoder().encode("root")).roles("vip1", "vip2", "vip3").and()
                .withUser("刘富贵").password(new BCryptPasswordEncoder().encode("liufugui")).roles("vip2", "vip3").and()
                .withUser("guests").password(new BCryptPasswordEncoder().encode("guests")).roles("vip1");
//使用数据库的用户信息进行授权
        //auth.jdbcAuthentication().dataSource(dataSource);
    }
}
