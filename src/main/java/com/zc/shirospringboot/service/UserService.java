package com.zc.shirospringboot.service;

import com.zc.shirospringboot.model.UserSys;
import com.zc.shirospringboot.until.SaltUntils;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created bywintec on 2020/9/22
 */
public interface UserService {

    public Integer register(UserSys userSys);


    public UserSys FinfUserByUsername(String username);

}