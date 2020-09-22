package com.zc.shirospringboot.config;

import com.zc.shirospringboot.shiro.realms.CustomerRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 整合shiro
 */
@Configuration
public class ShiroConfig {


    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager)
    {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //给filter设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //配置系统的寿险资源
        Map<String,String> map = new HashMap<String, String>();
        map.put("/user/login","anon"); //auon 公共资源
        map.put("/login.jsp","anon"); //auon 公共资源
        map.put("/register.jsp","anon");
        map.put("/user/register","anon"); //auon 公共资源
        map.put("/**","authc"); //authc 代表请求这个资源需要认证和授权

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        //配置系统公共资源

        //默认认证界面路径
        shiroFilterFactoryBean.setLoginUrl("login.jsp"); //默认的
        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("ream1") Realm realm1){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm1);
        //给安全模拟器设置realm
        return  defaultWebSecurityManager;

    }
    @Bean(name = "ream1")
    public Realm getRealm()
    {
        CustomerRealm customerRealm = new CustomerRealm();
        //修改凭证校验匹配器
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");

        //设置散列次数
        credentialsMatcher.setHashIterations(1024);
        customerRealm.setCredentialsMatcher(credentialsMatcher);
        return customerRealm;
    }
}
