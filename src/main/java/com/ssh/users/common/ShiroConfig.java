package com.ssh.users.common;

import com.ssh.users.Shiro.CustomRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    /**
     * 注入自定义的Realm
     * @return
     */
    @Bean
    public CustomRealm myAuthRealm(){
        CustomRealm customRealm = new CustomRealm();
        System.out.println("**********realm注册完成**********");
        return customRealm;
    }

    /**
     * 注入安全管理器
     * @return
     */
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(myAuthRealm());
        System.out.println("**********securityManager注册**********");
        return securityManager;
    }

    /**
     * 注入shiro过滤器
     * @param securityManager 安全管理器
     * @return
     */
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        //定义shiroFactoryBean
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置自定义的securityManager 安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //设置默认登录的URL,身份认证失败会访问这个URL
        shiroFilterFactoryBean.setLoginUrl("/login");

        //设置登录成功之后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/success");

        //设置未授权页面，全是认证失败会访问该URL
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

        // LinkedHashMap 是有序的，进行顺序拦截器配置
        Map<String,String> filterChainMap = new LinkedHashMap<>();

        // 配置可以匿名访问的地址，可以根据实际情况自己添加，放行一些静态资源等，anon 表示放行
        filterChainMap.put("/css/**", "anon");
        filterChainMap.put("/imgs/**", "anon");
        filterChainMap.put("/js/**", "anon");
        filterChainMap.put("/swagger-*/**", "anon");
        filterChainMap.put("/swagger-ui.html/**", "anon");

        //登录URL放行
        filterChainMap.put("/users/login","anon");

//        // 以“/user/admin” 开头的用户需要身份认证，authc 表示要进行身份认证
//        filterChainMap.put("/user/超级管理*", "authc");
//        // “/user/student” 开头的用户需要角色认证，是“admin”才允许
//        filterChainMap.put("/user/student*/**", "roles[admin]");
//        // “/user/teacher” 开头的用户需要权限认证，是“user:create”才允许
//        filterChainMap.put("/user/teacher*/**", "perms[\"user:create\"]");

        // 配置 logout 过滤器
        filterChainMap.put("/logout", "logout");

        // 设置 shiroFilterFactoryBean 的 FilterChainDefinitionMap
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        System.out.println("====shiroFilterFactoryBean注册完成====");
        return shiroFilterFactoryBean;

    }

}