package com.bin.demo.common.basic;

/**
 * package: com.bin.demo.common.basic
 * class: Constants
 * description: TODO用一句话描述该文件做什么
 *
 * @author 85321 ZhengZhouBin
 * @date 2019/7/22 0022.
 **/
public class Constants {

    /** 去空格类型:去前导空格   */
    public static final int LEFT_TRIM = 1;
    /** 去空格类型:去后导空格   */
    public static final int RIGHT_TRIM = 2;
    /** 去空格类型:去前后空格   */
    public static final int ALL_TRIM = 3;
    /** 默认URL编码字符集*/
    public static final String DEFAULT_URL_ENCODING = "UTF-8";
    //默认失败编码
    public static final int DEFAULT_FAIL_CODE = -1;
    //默认错误提示语
    public static final String DEFAULT_FAIL_MESSAGE="系统出错了，请联系管理员";
    //发生异常信息可以错误
    public static final String SQL_EXCEPTION_MESSAGE_PREFIX = "java.sql";
    //数据库发生异常默认报错
    public static final String SQL_EXCEPTION_DEFAULT_MESSAGE = "数据库发生异常";
    //服务实例不可用
    public static final String NO_INSTANCE_AVAILABLE = "No instances available for";
    //服务实例不可用错误信息
    public static final String NO_INSTANCE_AVAILABLE_MESSAGE = "服务实例不可用";
    //默认成功编码
    public static final int DEFAULT_SUCCESS_CODE = 0;
    //成功标志
    public static final String KEY_SUCCESS = "success";
    //提示信息
    public static final String KEY_MESSAGE = "message";
    //错误码
    public static final String KEY_CODE = "code";

}
