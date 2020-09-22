package com.zc.shirospringboot.until;

import com.zc.shirospringboot.model.SimpleByteSource;
import org.apache.shiro.util.ByteSource;


/**
 * description: ByteSourceUtils <br>
 * date: 2020/9/22 20:55 <br>
 * author: 19323 <br>
 */
public class ByteSourceUtils {
    public static ByteSource bytes(byte[] bytes) {

        return  new SimpleByteSource(bytes);
    }

    public static ByteSource bytes(String arg0) {
        return new SimpleByteSource(arg0.getBytes());
    }
}