package com.zc.shirospringboot.model;

/**
 * description: SimpleByteSource <br>
 * date: 2020/9/22 20:55 <br>
 * author: 19323 <br>
 */

import java.io.Serializable;

public class SimpleByteSource extends org.apache.shiro.util.SimpleByteSource
        implements Serializable {

    private static final long serialVersionUID = 5528101080905698238L;

    public SimpleByteSource(byte[] bytes) {
        super(bytes);
        // TODO 自动生成的构造函数存根
    }

}