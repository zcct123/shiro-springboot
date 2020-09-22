package com.zc.shirospringboot.service;

import com.zc.shirospringboot.mapper.UserSysMapper;
import com.zc.shirospringboot.model.UserSys;
import com.zc.shirospringboot.until.SaltUntils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;


/**
 * Created bywintec on 2020/9/22
 */
@Service
@Slf4j

public class UserServiceImpl implements UserService{

    @Resource
    UserSysMapper userSysMapper;

    @Transactional
    public Integer  register(UserSys userSys)
    {
        userSys.setBz1(SaltUntils.getSalt(8));
        //MD5
        Md5Hash md5Hash = new Md5Hash(userSys.getPassword(), userSys.getBz1(), 1024);
        userSys.setPassword(md5Hash.toHex());
        log.info(userSys.toString());
       return userSysMapper.add(userSys);
    }

    @Transactional
    public UserSys FinfUserByUsername(String username)
    {
        return userSysMapper.findByUsername(username);
    }

}
