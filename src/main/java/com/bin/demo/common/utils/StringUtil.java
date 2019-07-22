package com.bin.demo.common.utils;

/**
 * package: com.bin.demo.common.utils
 * class: StringUtil
 * description: TODO用一句话描述该文件做什么
 *
 * @author 85321 ZhengZhouBin
 * @date 2019/7/22 0022.
 **/
public class StringUtil {
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    public static boolean contains(String str, String sub) {
        return str.contains(sub);
    }

    /**
     * 把字符串转换成long类型
     *
     * @param str
     * @return
     */
    public static long strToLong(String str)
    {
        long l = 0l;
        int flag = 1;
        for (int i = 0; i < str.length(); i++)
        {
            if (i == 0)
            {
                if (str.charAt(i) == '-')
                {
                    flag = -1;
                    continue;
                }
            }
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
            {
                l = l * 10 + str.charAt(i) - '0';
            } else
            {
                break;
            }
        }
        return l * flag;
    }
}
