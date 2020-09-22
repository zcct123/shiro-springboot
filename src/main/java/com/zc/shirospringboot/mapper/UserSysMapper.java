package com.zc.shirospringboot.mapper;

import com.zc.shirospringboot.model.UserSys;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created bywintec on 2020/9/22
 */
@Mapper
public interface UserSysMapper {

    public Integer add( @Param("entity") UserSys userSys);

    public UserSys findByUsername(String username);
}
