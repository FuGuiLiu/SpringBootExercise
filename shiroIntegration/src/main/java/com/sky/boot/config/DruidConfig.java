package com.sky.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * 相当于这是个springApplication.xml文件 ,标注这个项目是个测试类
 */
@Configuration
public class DruidConfig {

    /**
     * @ConfigurationProperties 与配置文件绑定
     * @Bean 将数据源引入到容器中
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource getDataSource() {
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean getServletRegistration() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");
        Map<String, String> initParameters = new HashMap<>();

        initParameters.put("loginUsername", "sky");
        initParameters.put("loginPassword", "sky");

        initParameters.put("allow", "127.0.0.1");

        servletRegistrationBean.setInitParameters(initParameters);

        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean getFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        Map<String, String> initParameters = new HashMap<>();

        initParameters.put("exclusions", "*.css,*.js,/druid/*");

        filterRegistrationBean.setInitParameters(initParameters);
        return filterRegistrationBean;
    }
}
