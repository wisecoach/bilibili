package com.wisecoach.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;

@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    /**
     * 这就是在配置web.xml中注册servlet
     * 此处配置的是druid的监控接口
     * @return
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet(
        @Value("${username}") String loginName,
        @Value("${spring.datasource.password}") String loginPassword){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet());
        HashMap<String, String> initParams = new HashMap<>();
        initParams.put("loginUserName", loginName);
        initParams.put("loginPassword", loginPassword);
        initParams.put("allow", "localhost");
        bean.setInitParameters(initParams);
        ArrayList<String> urlArray = new ArrayList<String>();
        urlArray.add("/druid/*");
        bean.setUrlMappings(urlArray);
        return bean;
    }
}
