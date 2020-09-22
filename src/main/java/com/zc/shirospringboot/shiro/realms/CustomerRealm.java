package com.zc.shirospringboot.shiro.realms;

import com.zc.shirospringboot.mapper.UserSysMapper;
import com.zc.shirospringboot.model.UserSys;
import com.zc.shirospringboot.service.UserService;
import com.zc.shirospringboot.service.UserServiceImpl;
import com.zc.shirospringboot.until.ApplicationContextUntil;
import com.zc.shirospringboot.until.ByteSourceUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.io.Serializable;

@Slf4j
public class CustomerRealm extends AuthorizingRealm  {

    @Resource
    UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取身份信息
        UserSys userSys = (UserSys)principalCollection.getPrimaryPrincipal();

        log.info("当前用户信息："+userSys.toString());

        //根据主身份信息获取角色信息 和 权限信息

        if("zczc".equals(userSys.getUsername()))
        {
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

            //添加身份
            simpleAuthorizationInfo.addRole("admin");
            simpleAuthorizationInfo.addRole("user");
            simpleAuthorizationInfo.addStringPermission("user:create:*");
        return  simpleAuthorizationInfo;
        }

        return  null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();
        log.info(principal+"输入的用户名");
      //  UserServiceImpl userService1 = (UserServiceImpl)ApplicationContextUntil.getBean("userServiceImpl");
        UserSys userSys = userService.FinfUserByUsername(principal);


        if(!ObjectUtils.isEmpty(userSys))
        {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userSys,userSys.getPassword()
                    , ByteSourceUtils.bytes(userSys.getBz1()),this.getName());
            return simpleAuthenticationInfo;

        }

        return null;
    }
}
