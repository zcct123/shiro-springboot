package com.zc.shirospringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Created bywintec on 2020/9/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserSys {
    @Override
    public String toString() {
        return "UserSys{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", bz1='" + bz1 + '\'' +
                '}';
    }

    private  Integer  id;
    private  String   username;
    private  String   password;
    private  String   bz1;
}
