package com.java.util;


import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;

/**
 * @Description MD5Util
 * @Author WYR
 * @CreateTime 2019-03-31 16:25
 */
public class MD5Util {
    public static void main(String[] args) {
        String s1 = "1";
        System.out.println(s1+" hashCode()："+s1.hashCode());
        System.out.println(s1 + "加密后：" + MD5Test(s1));
    }

    public static String MD5Test(String str) {
        try {
            String md5Str = new String(DigestUtils.md5Hex(str.getBytes("UTF-8")));
            return md5Str;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
