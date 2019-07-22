package com.bin.demo.common.utils;


import com.bin.demo.common.basic.Constants;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Util {
    /**
     * 获取本地IP地址
     * @return
     */
    public static String getLocalIp()
    {
        String ip = "";
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
            ip =  addr.getHostAddress().toString();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ip;
    }

    /**
     * 获取当前进程id
     * @return
     */
    public static String getCurrentProcessId()
    {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        String processId = "";
        try
        {
            processId = runtimeMXBean.getName().split("@")[0];
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return processId;

    }

    /**
     * 获取UUID
     * @return
     */
    public static String getUUID()
    {
        String str = "";
        try
       {
           UUID uuid = UUID.randomUUID();
           str = uuid.toString().replace("-","");
       }catch (Exception e)
        {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 判断数组是否为空
     * @param obj
     * @return
     */
    public static boolean isEmptyArray(Object[] obj)
    {
        if(null == obj || obj.length==0)
        {
            return true;
        }else
        {
            return false;
        }
    }

    /**
     * 判断数组是否为空
     * @param obj
     * @return
     */
    public static boolean isEmptyArray(Object[][] obj)
    {
        if(null == obj || obj.length==0)
        {
            return true;
        }else
        {
            return false;
        }
    }

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isNull(String str)
    {
        if(null == str || "".equals(str))
        {
            return true;
        }else
        {
            return false;
        }
    }

    /**
     * 判断obj是否为空,如果进来的是空字符串也返回空
     * @param obj
     * @return
     */
    public static boolean isNullObj(Object obj)
    {
        if(null == obj)
        {
            return true;
        }else
        {
            if(!(obj instanceof String))
            {
                return false;
            }else
            {
                String str = String.valueOf(obj);
                if("".equals(str))
                {
                    return true;
                }else
                {
                    return false;
                }
            }
        }
    }

    /**
     * 判断List是否为空
     * @param list
     * @return
     */
    public static boolean isEmptyList(List list)
    {
        if(null == list || list.size() == 0)
        {
            return true;
        }else
        {
            return false;
        }
    }

    /**
     * 判断Map是否为空
     * @param map
     * @return
     */
    public static boolean isEmptyMap(Map map)
    {
        if(null == map || map.size() == 0)
        {
            return true;
        }else
        {
            return false;
        }
    }

    /**
     * 将String类型的obj转换成String
     * @param obj
     * @return
     */
    public static String toString(Object obj)
    {
        if(null == obj)
        {
            return null;
        }else
        {
            return String.valueOf(obj);
        }
    }

    /**
     * 将默认值""
     * @param obj
     * @return
     */
    public static String toStringValue(Object obj)
    {
        if(null == obj)
        {
            return "";
        }else
        {
            return String.valueOf(obj);
        }
    }

    /**
     * 将默认值defaultValue
     * @param obj
     * @return
     */
    public static String toDefaultStringValue(Object obj,String defaultValue)
    {
        if(null == obj)
        {
            return defaultValue;
        }else
        {
            return String.valueOf(obj);
        }
    }

    /**
     * 将Integer类型的obj转换成Integer
     * @param obj
     * @return
     */
    public static Integer toInteger(Object obj)
    {
        if(isNullObj(obj))
        {
            return null;
        }else
        {
            return Integer.valueOf(String.valueOf(obj));
        }
    }

    /**
     * 将Object类型的obj转换成int
     * @param obj
     * @return
     */
    public static int toIntegerValue(Object obj)
    {
        if(isNullObj(obj))
        {
            return 0;
        }else
        {
            return Integer.parseInt(String.valueOf(obj));
        }
    }

    /**
     * 将Object类型的obj转换成int
     * @param obj
     * @return
     */
    public static int toDefaultIntegerValue(Object obj,int defaultValue)
    {
        if(isNullObj(obj))
        {
            return defaultValue;
        }else
        {
            return Integer.parseInt(String.valueOf(obj));
        }
    }

    /**
     * 将Object类型的obj转换成Double
     * @param obj
     * @return
     */
    public static Double toDouble(Object obj)
    {
        if(isNullObj(obj))
        {
            return null;
        }else
        {
            return Double.valueOf(String.valueOf(obj));
        }
    }

    /**
     * 将Object类型的obj转换成double
     * @param obj
     * @return
     */
    public static double toDoubleValue(Object obj)
    {
        if(isNullObj(obj))
        {
            return 0d;
        }else
        {
            return Double.parseDouble(String.valueOf(obj));
        }
    }

    /**
     * 将Object类型的obj转换成double
     * @param obj
     * @return
     */
    public static double toDefaultDoubleValue(Object obj,double defaultValue)
    {
        if(isNullObj(obj))
        {
            return defaultValue;
        }else
        {
            return Double.parseDouble(String.valueOf(obj));
        }
    }

    /**
     * 将Object类型的obj转换成Long
     * @param obj
     * @return
     */
    public static Long toLong(Object obj)
    {
        if(isNullObj(obj))
        {
            return null;
        }else
        {
            return Long.valueOf(String.valueOf(obj));
        }
    }

    /**
     * 将Object类型的obj转换成long
     * @param obj
     * @return
     */
    public static long toLongValue(Object obj)
    {
        if(isNullObj(obj))
        {
            return 0l;
        }else
        {
            return Long.parseLong(String.valueOf(obj));
        }
    }

    /**
     * 将Object类型的obj转换成long
     * @param obj
     * @return
     */
    public static long toDefaultLongValue(Object obj,long defaultValue)
    {
        if(isNullObj(obj))
        {
            return defaultValue;
        }else
        {
            return Long.parseLong(String.valueOf(obj));
        }
    }


    /**
     * 将Object类型的obj转换成Short
     * @param obj
     * @return
     */
    public static Short toShort(Object obj)
    {
        if(isNullObj(obj))
        {
            return null;
        }else
        {
            return Short.valueOf(String.valueOf(obj));
        }
    }

    /**
     * 将Object类型的obj转换成short
     * @param obj
     * @return
     */
    public static short toShortValue(Object obj)
    {
        if(isNullObj(obj))
        {
            return 0;
        }else
        {
            return Short.parseShort(String.valueOf(obj));
        }
    }

    /**
     * 将Object类型的obj转换成short
     * @param obj
     * @return
     */
    public static short toDefaultShortValue(Object obj,short defaultValue)
    {
        if(isNullObj(obj))
        {
            return defaultValue;
        }else
        {
            return Short.parseShort(String.valueOf(obj));
        }
    }

    /**
     * 将Integer类型的obj转换成Integer
     * @param obj
     * @return
     */
    public static Float toFloat(Object obj)
    {
        if(isNullObj(obj))
        {
            return null;
        }else
        {
            return Float.valueOf(String.valueOf(obj));
        }
    }

    /**
     * 将Object类型的obj转换成int
     * @param obj
     * @return
     */
    public static float toFloatValue(Object obj)
    {
        if(isNullObj(obj))
        {
            return 0f;
        }else
        {
            return Float.parseFloat(String.valueOf(obj));
        }
    }

    /**
     * 将Object类型的obj转换成int
     * @param obj
     * @return
     */
    public static float toFloatValue(Object obj,float defaultValue)
    {
        if(isNullObj(obj))
        {
            return defaultValue;
        }else
        {
            return Float.parseFloat(String.valueOf(obj));
        }
    }

    /**
     * 判断key值在map中是否存在
     * @param map
     * @param key
     * @return
     */
    public static boolean isKeyExist(HashMap map, String key) {
        Iterator keys = map.keySet().iterator();
        while (keys.hasNext()) {
            String keyStr = (String) keys.next();
            if (key.equals(keyStr)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 替换换行符
     * @return
     */
    public static String replaceLineSeparator(String str)
    {
        StringBuilder sb = new StringBuilder();
        if(!isNull(str))
        {
            //'\r'是回车，'\n'是换行 '\t'相当于键盘的Tab键
            sb.append(str.replace("\n","").replace("\r","").replace("\t",""));
        }
        return sb.toString();
    }


    /**
     * 对arrayLists里面的数组进行排列组合如入参传["1","2"] ["3","4"],得到的结果为[["1","3"],["1","4"],["2","3"],["2","4"]]
     * 注意最后的结果都会放在第一位
     * @param arrayLists
     * @return
     */
    public static List<List<List<String>>> doPermutations(List arrayLists){

        int len=arrayLists.size();
        //判断数组size是否小于2，如果小于说明已经递归完成了，否则你们懂得的，不懂？断续看代码
        if (len<2){
            return arrayLists;
        }
        //拿到第一个数组
        int len0;
        if (arrayLists.get(0) instanceof String[]){
            String[] arr0= (String[]) arrayLists.get(0);
            len0=arr0.length;
        }else {
            len0=((ArrayList<String>)arrayLists.get(0)).size();
        }

        //拿到第二个数组
        String[] arr1= (String[]) arrayLists.get(1);
        int len1=arr1.length;

        //计算当前两个数组一共能够组成多少个组合
        int lenBoth=len0*len1;

        //定义临时存放排列数据的集合
        ArrayList<ArrayList<String>> tempArrayLists=new ArrayList<ArrayList<String>>(lenBoth);

        //第一层for就是循环arrayLists第一个元素的
        for (int i=0;i<len0;i++){
            //第二层for就是循环arrayLists第二个元素的
            for (int j=0;j<len1;j++){
                //判断第一个元素如果是数组说明，循环才刚开始
                if (arrayLists.get(0) instanceof String[]){
                    String[] arr0= (String[]) arrayLists.get(0);
                    ArrayList<String> arr=new ArrayList<String>();
                    arr.add(arr0[i]);
                    arr.add(arr1[j]);
                    //把排列数据加到临时的集合中
                    tempArrayLists.add(arr);
                }else {
                    //到这里就明循环了最少一轮啦，我们把上一轮的结果拿出来继续跟arrayLists的下一个元素排列
                    ArrayList<ArrayList<String>> arrtemp= (ArrayList<ArrayList<String>>) arrayLists.get(0);
                    ArrayList<String> arr=new ArrayList<String>();
                    for (int k=0;k<arrtemp.get(i).size();k++){
                        arr.add(arrtemp.get(i).get(k));
                    }
                    arr.add(arr1[j]);
                    tempArrayLists.add(arr);
                }
            }
        }

        //这是根据上面排列的结果重新生成的一个集合
        List newArrayLists=new ArrayList<String>();
        //把还没排列的数组装进来，看清楚i=2的喔，因为前面两个数组已经完事了，不需要再加进来了
        for (int i=2;i<arrayLists.size();i++){
            newArrayLists.add(arrayLists.get(i));
        }
        //排列的数据加到新集合的第一位
        newArrayLists.add(0,tempArrayLists);

        //递归
        return doPermutations(newArrayLists);
    }

    /**
     * 自定义字符串分割函数，提单String.split函数，提高性能
     * 可以提升近9倍的效率
     * @param src
     * @param delimeter
     * @return
     */
    public static String[] split(String src, String delimeter) {
        String srcStr = src;
        String delimeterStr = delimeter;
        if (srcStr == null) {
            return null;
        }
        if (delimeterStr == null) {
            throw new IllegalArgumentException("delimeter should not be null");
        }
        if (delimeterStr.equals("")) { //直接返回每个字符的字符串形式
            String[] array = new String[srcStr.length()];
            for (int i = 0; i < array.length; i++) {
                array[i] = String.valueOf(srcStr.charAt(i));
            }
            return array;
        }
        if (srcStr.length() > delimeterStr.length()) { //源字符串长度大于分隔符字符串长度
            int i = srcStr.indexOf(delimeterStr);
            int j = i;
            int n = 0;
            int lastIndex = srcStr.length() - delimeterStr.length();
            boolean lastStringIsDelimeter = false;
            while (i >= 0) {
                n++;
                i = srcStr.indexOf(delimeterStr, i + delimeterStr.length());
                if (i == lastIndex) { // delimeter is the last string of the src, should not be counted
                    lastStringIsDelimeter = true;
                    break;
                }
            }
            String[] array = new String[n + 1];
            n = i = 0;
            while (j >= 0) {
                if (j - i > 0) {
                    array[n++] = srcStr.substring(i, j);
                } else if (j - i == 0) { // two delimeter is neighbour
                    array[n++] = "";
                }
                i = j + delimeterStr.length();
                j = srcStr.indexOf(delimeterStr, i);
            }
            if (!lastStringIsDelimeter) {
                array[n] = srcStr.substring(i);
            }
            return array;
        } else if (srcStr.length() == delimeterStr.length()) { // 源字符串长度等于 分隔符字符串长度
            if (srcStr.equals(delimeterStr)) {
                return new String[0];
            } else {
                String[] array = new String[1];
                array[0] = srcStr;
                return array;
            }
        } else { // 源字符串长度 小于 分隔符字符串长度 ， 直接返回源字符串
            String[] array = new String[1];
            array[0] = srcStr;
            return array;
        }
    }

    /**
     * 判断当前操作系统是否为Windows
     * @return
     */
    public static boolean isWindows()
    {
        String os = System.getProperty("os.name");
        if(os.toLowerCase().startsWith("win"))
        {
            return true;
        }else
        {
            return false;
        }
    }


    /**
     * 将需要使用的路径根据系统进行适配处理
     * @param adaptPath
     * @return
     */
    public static String adaptSystemPath(String adaptPath)
    {
        if(isNull(adaptPath))
        {
            return "";
        }
        //如果是windows，而配置成了Linux系统的路径格式，将其转化回来
        if(isWindows())
        {
            adaptPath = adaptPath.replace("/", "\\");

        }else
        {
            //如果是Linux系统，而配置成了windows系统的路径格式，将其转化回来
            adaptPath = adaptPath.replace("\\", "/");
        }
        return adaptPath;
    }

    /**
     * 是否隐藏后几位，用*代替
     * flag为true不需要隐藏，false则表示没有权限需要隐藏
     * @param str
     * @param number
     * @return
     */
    public static String hideAfterString(String str, int number, boolean flag)
    {
        if(flag)
        {
            return str;
        }

        if(null == str || "".equals(str) || number <= 0)
        {
            return str;
        }

        if(str.length() <= number)
        {
            return str.replaceAll(".", "*");
        }
        else
        {
            String before = str.substring(0, str.length()-number);
            String after = str.substring(str.length()-number, str.length());
            after = after.replaceAll(".", "*");
            str = before + after;
        }

        return str;
    }

    // 字符串为空时的赋值
    public static String nvl(String strChk) {
        return nvl(strChk, "");
    }

    // 字符串为空时的赋值
    public static String nvl(String strChk, String strExp) {
        if (isNull(strChk))
            return strExp;
        return strChk;
    }

    // 判断字符串是否是日期（年月日）
    public static boolean isDate(String strExp) {
        if (strExp.length() != 10)
            return false;

        try {
            Calendar cal = new GregorianCalendar();
            cal.setLenient(false);
            cal.set(Integer.parseInt(strExp.substring(0, 4)), Integer
                    .parseInt(strExp.substring(5, 7)) - 1, Integer
                    .parseInt(strExp.substring(8, 10)));
            Date ud = cal.getTime();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    // 判断字符串是否是一个在规定长度内的float
    public static boolean isFloat(String strExp, int intWidth) {
        if (isNull(strExp) || intWidth <= 0 || strExp.length() > intWidth)
            return false;
        return isFloat(strExp);
    }

    // 判断字符串是否是一个在规定长度内的float
    public static boolean isFloat(String strExp, int intWidth, int intZero) {
        if (isFloat(strExp) == true) {
            int i = strExp.indexOf(".");
            if (i < 0) {
                if (strExp.length() > intWidth)
                    return false;
                else
                    return true;
            }

            if (strExp.length() - i - 1 > intZero)
                return false;
            return true;
        }
        return false;
    }

    // 判断字符串是否是一个float
    public static boolean isFloat(String strExp) {
        if (isNull(strExp))
            return false;

        try {
            Float.valueOf(strExp);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // 判断字符串是否是一个在规定长度内的integer
    public static boolean isInteger(String strExp, int intWidth) {
        if (isNull(strExp) || intWidth <= 0 || strExp.length() > intWidth)
            return false;
        return isInteger(strExp);
    }

    // 判断字符串是否是一个integer
    public static boolean isInteger(String strExp) {
        if (isNull(strExp))
            return false;

        try {
            Integer.valueOf(strExp);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    // 判断字符串是否是一个数值
    public static boolean isNumeric(String strExp) {
        if (isFloat(strExp) || isInteger(strExp))
            return true;
        return false;
    }

    // 判断字符串是否在规定长度内
    public static boolean isLegalLen(String strExp, int intWidth) {
        if (isNull(strExp))
            return true;

        if (strExp.length() > intWidth)
            return false;
        return true;
    }

    // 将字符串从ISO8859-1型转换成GB2312型
    public static String toGB(String strExp, String strRep) {
        return toGB(nvl(strExp, strRep));
    }

    public static String toGB(String strExp) {
        strExp = (strExp == null) ? "" : strExp;
        return strExp;
    }
    public static String _toGB(String strExp) {
        strExp = (strExp == null) ? "" : strExp;

        try {
            return new String(strExp.getBytes("ISO8859-1"), "GBK");
        } catch (Exception e) {
            return "";
        }
    }
    public static String _toISO8859(String strExp) {
        strExp = (strExp == null) ? "" : strExp;
        try {
            if(isAix())
            {
                return new String(strExp.getBytes("GBK"), "ISO8859-1");
            }else
            {
                return strExp;
            }
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 去除右边的空格
     *
     * @param aszExp
     *            要被去除空格的字符串
     * @return 返回去除右边所有空格后的字符串
     */
    public static String rTrim(String aszExp) {
        int i = 0;
        if (aszExp == null || aszExp.length() == 0)
            return "";
        for (i = aszExp.length(); i > 0; i--) {
            if (aszExp.charAt(i - 1) != ' '&&aszExp.charAt(i - 1)!= '\n')
                break;
        }
        if (i == 0)
            return "";
        else
            return aszExp.substring(0, i);
    }

    /**
     * 去除左边的空格
     *
     * @param aszExp
     *            要被去除空格的字符串
     * @return 返回去除左边所有空格后的字符串
     */
    public static String lTrim(String aszExp) {
        int i = 0;
        if (aszExp == null || aszExp.length() == 0)
            return "";
        for (i = 0; i < aszExp.length(); i++) {
            if (aszExp.charAt(i) != ' '&&aszExp.charAt(i)!= '\n')
                break;
        }

        return aszExp.substring(i);
    }

    /**
     * 去除前后空格
     *
     * @param aszExp
     *            要被去除空格的字符串
     * @return 按要求去除空格后的字符串
     */
    public static String trim(String aszExp) {
        return trim(aszExp, Constants.ALL_TRIM);
    }

    /**
     * 据要求去除空格
     *
     * @param aszExp
     *            要被去除空格的字符串
     * @param aiTrimType
     *            去空格的类型.RIGHT_TRIM:右去空格;LEFT_TRIM:左去空格;ALL_TRIM:去除前后空格
     * @return 按要求去除空格后的字符串
     */
    public static String trim(String aszExp, int aiTrimType) {
        if (aiTrimType == Constants.ALL_TRIM) {
            aszExp = rTrim(aszExp);
            aszExp = lTrim(aszExp);
            return aszExp;
        }else if (aiTrimType == Constants.RIGHT_TRIM)
            return rTrim(aszExp);
        else if (aiTrimType == Constants.LEFT_TRIM)
            return lTrim(aszExp);
        else
            return aszExp;
    }
    /**
     * 字符串替换
     *
     * @author yxl
    去除字符串中的空格、回车、换行符、制表符
     */
    public static String replaceBlank(String aszExp)
    {
        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher m = p.matcher(aszExp);
        aszExp = m.replaceAll("");
        return aszExp;
    }
    /**
     * 字符串替换
     *
     * @author lrq
     * @param source
     *            原始字符串
     * @param oldStr
     *            被替换字符串
     * @param newStr
     *            替换字符串
     * @return 替换后的字符串
     */
    public static String replaceString(String source, String oldStr,
                                       String newStr) {
        if (source == null | oldStr == null | newStr == null)
            return null;

        String result = "";

        int iPosNew = 0, iPosOld = 0;

        while (true) {
            iPosNew = source.indexOf(oldStr, iPosOld);

            if (iPosNew == -1) // 未找到
            {
                result += source.substring(iPosOld, source.length());
                break;
            } else {
                result += source.substring(iPosOld, iPosNew) + newStr;
            }

            iPosOld = iPosNew + oldStr.length();

        }
        return result;
    }

    /**
     * 判断一个字符串在另一个字符串中出现的次数
     *
     * @author lrq
     * @param source
     *            被查找字符串
     * @param target
     *            欲查找字符串
     * @return 出现的次数
     */
    public static int appearTimes(String source, String target) {
        if (source == null | target == null) {
            return 0;
        }

        int i = 0, iCount = 0;

        while (i != -1) {
            i = source.indexOf(target, i);

            if (i != -1) {
                iCount++;
                i += target.length();
            }
        }
        return iCount;
    }

    /**
     * 此方法用于将一个输入字符串input根据某个分隔符sep分解成所需要的字符串数组 例input:12|345|6789|abcde
     * 根据分隔符"|" 可被分解成{"12","345","6789","abcde"} hyt 2005.07.14
     *
     * @param input
     *            String
     * @param sep
     *            String
     * @return String[]
     */
    public static String[] divideString(String input, String sep) {
        String[] result = null;
        String part, left = "";
        int next = 0;
        int times = 0;
        times = appearTimes(input, sep);
        result = new String[times + 1];
        left = input;
        for (int i = 0; i <= times; i++) {
            next = left.indexOf(sep);
            if (next == -1) {
                part = left.substring(0, left.length());
            } else {
                part = left.substring(0, next);
                left = left.substring(next + 1, left.length());
            }
            result[i] = part;
        }

        return result;
    }

    /**
     * 将金额转为大写金额
     *
     * @param s
     * @return阿拉伯数字的小写金额转为大写金额后的字符串
     */
    public static String convertCharge(String s) {
        if (s == null)
            s = "0";
        String money = ""; // 转换后的字符串
        String num = "零壹贰叁肆伍陆柒捌玖";
        String[] unit = { "元", "拾", "佰", "仟", "万", "拾万", "佰万", "仟万", "亿", "拾亿",
                "佰亿", "仟亿" };

        int a = s.indexOf("+"); // 判断s是否包含′+′,如1.67E+4
        int e = s.indexOf("E"); // 判断s是否包含′E′,如1.67E+4
        // 如果包含′E′(该金额是以科学记数法表示,则转换成普通表示法)
        if (e != -1) {
            int index = 0; // 指数值
            if (a == -1)
                index = Integer.parseInt(s.substring(e + 1)); // 取得指数值
            else
                index = Integer.parseInt(s.substring(a + 1)); // 取得指数值
            String sub1 = s.substring(0, e); // 取得尾数值
            int dot = sub1.indexOf("."); // 尾数的小数点位置
            // 如果不含有小数点,则在后面补index个′0′
            if (dot == -1) {
                for (int i = 1; i <= index; i++) {
                    s = sub1 + "0";
                }
            } else { // 如果含有小数点,则向后移动小数点index位
                String sub11 = sub1.substring(0, dot); // 小数点前面的字串
                String sub12 = sub1.substring(dot + 1); // 小数点后面的字串
                if (index >= sub12.length()) {
                    int j = index - sub12.length();
                    for (int i = 1; i <= j; i++) {
                        sub12 = sub12 + "0";
                    }
                } else {
                    sub12 = sub12.substring(0, index) + "."
                            + sub12.substring(index);
                }
                s = sub11 + sub12;
            }
        }
        int sdot = s.indexOf("."); // s中小数点的位置
        String beforeDot = ""; // 小数点前面的字串
        String afterDot = ""; // 小数点后面的字串
        // 如果包含小数点
        if (sdot != -1) {
            beforeDot = s.substring(0, sdot);
            afterDot = s.substring(sdot + 1);
        } else { // 不包含小数点
            beforeDot = s;
        }
        int bl = beforeDot.length();
        boolean zero = false; // 数字是否为零
        int z = 0; // ′0′的个数
        // 逐位取数字
        for (int j = 0, i = bl - 1; j <= bl - 1; j++, i--) {
            int number = Integer.parseInt(String.valueOf(beforeDot.charAt(j)));
            if (number == 0) {
                zero = true;
                z++;
            } else {
                zero = false;
                z = 0;
            }
            if (zero && z == 1) {
                money += "零";
            } else if (zero) {
            } else if (!zero) {
                money += num.substring(number, number + 1) + unit[i];
            }
        }
        // 删去多余的′万′和′亿′
        for (int i = 1; i <= 2; i++) {
            String ss = "";
            if (i == 1)
                ss = "万";
            else
                ss = "亿";
            int last = money.lastIndexOf(ss);
            if (last != -1) {
                String moneySub1 = money.substring(0, last);
                String moneySub2 = money.substring(last, money.length());
                int last2 = moneySub1.indexOf(ss);
                while (last2 != -1) {
                    moneySub1 = moneySub1.substring(0, last2)
                            + moneySub1
                            .substring(last2 + 1, moneySub1.length());
                    last2 = moneySub1.indexOf(ss);
                }
                money = moneySub1 + moneySub2;
            }
        }
        // money中是否包含′元′
        int yuan = money.indexOf("元");
        // 如果不包含′元′
        if (yuan == -1) {
            int zi = money.lastIndexOf("零");
            // 如果最后一位字符为′零′,则删除它
            if (zi == money.length() - 1) {
                money = money.substring(0, money.length() - 1) + "元"; // 在money最后加上′元′
            }
            // add by zy 20040805 没有元，则体现零元
            if (zi == 0) {
                money = "零" + money;
            }

        }
        // 如果小数点后面的字串不为空,则处理′角′,′分′
        if (!afterDot.equals("")) {
            int al = afterDot.length();
            if (al > 2) { // 如果字串长度大于2,则截断
                afterDot = afterDot.substring(0, 2);
                al = afterDot.length();
            }
            // 如果字符串不为′0′或′00′,则处理,否则不进行处理
            if (!afterDot.equals("0") && !afterDot.equals("00")) {
                // 逐位取得字符
                for (int i = 0; i < al; i++) {
                    int number = Integer.parseInt(String.valueOf(afterDot
                            .charAt(i)));
                    if (number != 0 && i == 0) {
                        money += num.substring(number, number + 1) + "角";
                    } else if (number != 0 && i == 1) {
                        money += num.substring(number, number + 1) + "分";
                    } else if (number == 0 && i == 0) {
                        money += "零";
                    }
                }
            }
        }
        // 如果不包含′角′,′分′则在最后加上′整′字
        // if (money.indexOf("角") == -1 && money.indexOf("分") == -1)
        // money += "整";
        // modify by ff：武电要求 当金额大写只到角时应该加"整"，如：叁拾伍元伍角整。需要加上，否则银行会退票的。
        if (money.indexOf("分") == -1)
            money += "整";
        // add by zlg 辽宁需求,大写金额前加"币"
        // money = "币" + money;
        return money;
    }


    /**
     * 在request中取得parameterName的变量。
     * @param request 请求变量
     * @param parameterName 变量名称
     * @param defaultValue 默认值
     * @return 变量值
     */
    public static String getParameter(HttpServletRequest request, String parameterName, String defaultValue ) {
        if( request == null || parameterName == null || parameterName.trim().length() == 0 ) return defaultValue;
        String value = request.getParameter( parameterName );
        if( value == null || value.trim().length() == 0 ) {
            return defaultValue;
        } else {
            return value.trim();
        }
    }

    /**
     * 获取URLDecoder解密后的参数
     * @param request
     * @param parameterName
     * @return
     */
    public static String getURLDecoderParameter(HttpServletRequest request, String parameterName)
    {
        String newParamter = "";
        try {
            newParamter = URLDecoder.decode(parameterName, Constants.DEFAULT_URL_ENCODING);
            return request.getParameter(newParamter);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 获取URLDecoder解密后的参数,取不到返回默认值
     * @param request
     * @param parameterName
     * @return
     */
    public static String getURLDecoderParameter(HttpServletRequest request, String parameterName, String defaultValue)
    {
        if( request == null || isNull(parameterName) )
        {
            return defaultValue;
        }
        String newParamter = "";
        try {
            //对参数名进行解码
            newParamter = URLDecoder.decode(parameterName, Constants.DEFAULT_URL_ENCODING);
            String value = request.getParameter(newParamter);
            if(!Util.isNull(value))
            {
                //对参数值进行解码
                return URLDecoder.decode(value, Constants.DEFAULT_URL_ENCODING);
            }else
            {
                return defaultValue;
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /** 将数字按指定格式进行格式化，如：#,##0.00% */
    public static String formatNumber(String format, Number number) {
        try {
            if (number == null) {
                return null;
            }
            if (format == null || format.length() <= 0) {
                return number.toString();
            }
            NumberFormat fmt = new DecimalFormat(format);
            return fmt.format(number);
        } catch (Exception e) {
            return number.toString();
        }
    }

    /**
     * @Title getAmoutFormat
     * @Description 金额格式化
     * @param data
     * @return
     */
    public static String getAmoutFormat(String data) {

        String result = "0.00";
        try {
            if ("0".equals(data)) {
                result = "0.00";
            } else {
                double temp = Double.parseDouble(data);
                if (temp < 0) {
                    temp = 0 - temp;
                    result = formatNumber("#0.00", new Double(temp));
                    result = "-" + result;
                } else {
                    result = formatNumber("#0.00", new Double(data));
                }
            }
        } catch (Exception e) {
            return data;
        }
        return result;

    }

    /**
     * @Title getAmoutFormat
     * @Description 金额格式化
     * @param data
     * @return String
     */
    public static String getAmoutFormat(double data) {
        return getAmoutFormat(String.valueOf(data));
    }

    /**
     * 判断系统是否为aix系统
     * @return
     */
    public static boolean isAix()
    {
        String os = System.getProperty("os.name");
        if(os.toLowerCase().startsWith("aix"))
        {
            return true;
        }else
        {
            return false;
        }
    }

    /**
     * 根据平台决定是否需要编码转换，解决SingleUpload上传文件名乱码问题
     * @param strValue
     * @return String
     */
    public static String strSystemConvert(String strValue){

        String str = "";

        //根据系统判断使用什么字符集转码
        String system = ApplicationPropertyUtil.getProperty("system");

        try {
            if ("windows".equals(system)) {
                str = strValue;
            } else {
                str = new String(strValue.getBytes("GBK"), "ISO-8859-1");
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage());
        }

        return str;
    }


    /**
     * 字符集转换,将指定字符串编码格式由fromCharset转换成toCharset
     * @param str
     * @param fromCharset
     * @param toCharset
     * @return
     */
    public static String changeCharset(String str,String fromCharset,String toCharset) {
        if(Util.isNull(str))
        {
            return str;
        }
        try
        {
            return new String(str.getBytes(fromCharset),toCharset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 去除前后空格
     *
     * @param aszExp
     *            要被去除空格的字符串
     * @return 按要求去除空格后的字符串
     */
    public static String trimLR(String aszExp) {
        aszExp = trim(aszExp, Constants.RIGHT_TRIM);
        aszExp = trim(aszExp, Constants.LEFT_TRIM);
        return aszExp;
    }





}
