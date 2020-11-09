package com.sky.boot.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Administrator
 * @Configuration 标注此类是一个配置类
 */
@Configuration
public class ShiroConfig {
    /**
     * @param defaultWebSecurityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier(value = "WebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        /**
         * 添加shiro内置过滤器
         *
         * anon     所有的用户都可以访问
         * authc    必须认证了才能访问
         * user     必须拥有记住我功能才能访问
         * perms    拥有对某个资源的权限才能访问
         * role     拥有某个角色权限才能访问
         */
        // 初始化拦截参数map
        Map<String, String> filterMap = new LinkedHashMap<>();

        // 配置拦截授权信息
        filterMap.put("/user/**", "authc");

        // 设置拦截参数
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);


        // 如果没有权限去toLogin 页面
        shiroFilterFactoryBean.setLoginUrl("/toLogin");

        return shiroFilterFactoryBean;
    }

    /**
     * 将shiro安全管理器加入到ioc容器中
     *
     * @param realm
     * @return
     */
    @Bean(name = "WebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier(value = "getRealm") Realm realm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
//要通过默认安全管理器用户的数据,而用户的安全数据存在在realm安全领域中,需要与realm进行绑定,实现管理数据
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }

    /**
     * 交给Spring ioc容器托管
     *
     * @return realm
     */
    @Bean
    public Realm getRealm() {
        return new Realm();
    }
}
