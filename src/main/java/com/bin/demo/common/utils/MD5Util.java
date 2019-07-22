package com.bin.demo.common.utils;

import java.security.MessageDigest;


public class MD5Util {

    public static void main(String[] args){

        System.out.println(encrypt("bill1234"));
    }
    /**
     * 加密
     * @param str
     * @return
     */
    public static String encrypt(String str){
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值

            return byte2hex(md.digest());
//            return new BigInteger(1, md.digest()).toString(16);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static String byte2hex(byte[] b) //二行制转字符串
    {
        StringBuilder hs = new StringBuilder();
        String stmp = "";
        for (int n = 0; n < b.length; n++)
        {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs.append("0").append(stmp);
            else
                hs.append(stmp);
        }
        return hs.toString().toLowerCase();
    }
}
