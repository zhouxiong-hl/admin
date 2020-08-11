package com.fangchuang.haolinbao.Util;

import java.security.MessageDigest;

public class MD5Util {
    /***
           * MD5加码 生成32位md5码
     */
    public static String MD5(String str) throws Exception{
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes("UTF-8"));
            byte s[] = md.digest();
            String result = "";
            for(int i = 0; i < s.length; i++)
                result = result + Integer.toHexString(0xff & s[i] | 0xffffff00).substring(6);

            return result;
        }
        catch(Exception e)
        {
            return null;
        }
    }
}
