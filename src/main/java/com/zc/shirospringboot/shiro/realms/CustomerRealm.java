package com.zc.shirospringboot.shiro.realms;

import com.zc.shirospringboot.mapper.UserSysMapper;
import com.zc.shirospringboot.model.UserSys;
import com.zc.shirospringboot.service.UserService;
import com.zc.shirospringboot.service.UserServiceImpl;
import com.zc.shirospringboot.until.ApplicationContextUntil;
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

@Slf4j
public class CustomerRealm extends AuthorizingRealm {

    @Resource
    UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {


        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        return  simpleAuthorizationInfo;
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
                    , ByteSource.Util.bytes(userSys.getBz1()),this.getName());
            return simpleAuthenticationInfo;

        }

        return null;
    }
}
