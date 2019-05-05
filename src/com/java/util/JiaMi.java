package com.java.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;

/**
 * author wzh
 * Created on 2019/3/25
 */
public class JiaMi {
    private static String MD5Test(String str) {
        String s=null;
        try {
            s= new String(DigestUtils.md5Hex(str.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 加密解密算法 执行一次加密，两次解密
     */
    public static String convertMD5(String inStr){

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++){
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }

//    // 测试主函数
//    public static void main(String args[]) {
//        String s = new String("wzh666");
//        System.out.println("原始：" + s);
//        System.out.println("加密的：" + base64Encode(s));
//        try {
//            System.out.println("解密的：" + base64Decode(base64Encode(s)));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * Base64 encode
     * */
    public static String base64Encode(String data){
        return Base64.encodeBase64String(data.getBytes());
    }

    /**
     * Base64 decode
     * @throws UnsupportedEncodingException
     * */
    public static String base64Decode(String data) throws UnsupportedEncodingException{
        return new String(Base64.decodeBase64(data.getBytes()),"utf-8");
    }
}