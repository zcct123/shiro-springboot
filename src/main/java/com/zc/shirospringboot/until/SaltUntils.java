package com.zc.shirospringboot.until;

import java.util.Random;

/**
 * Created bywintec on 2020/9/22
 */
public  class SaltUntils {

    public  static  String getSalt(int n)
    {
        char[] chars = "ABCEFGHIGKLMNOPQRSTUVWSYZabcefghigklmnopqrstuvwsyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <n ; i++) {
            int i1 = new Random().nextInt(chars.length);
            char aChar = chars[i1];
            sb.append(aChar);
        }
        return sb.toString();
   }

//    public static void main(String[] args) {
//        System.out.println(getSalt(8));
//    }
}
