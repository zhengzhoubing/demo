package com.bin.demo.common.utils;

import org.springframework.context.ApplicationContext;

import java.util.Map;


/**
 * 获取SpringBean的工具类
 */
public class SpringBeanUtil {

    private static ApplicationContext applicationContext = null;


    public  static void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }


    /**
     * 根据名称获取对象
     * @param beanName
     * @param <T>
     * @return
     */
    public static <T> T getBeanByName(String beanName) {
        if (applicationContext == null){
            return null;
        }
        return (T) applicationContext.getBean(beanName);
    }

    /**
     * 根据类型获取对象
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T getBeanByClass(Class clz) {
        if (applicationContext == null){
            return null;
        }
        return (T) applicationContext.getBean(clz);
    }

    /**
     * 获取某个接口下的所有实例
     * @param type
     * @param <T>
     * @return
     */
    public static <T> Map<String, T> getBeansOfType(Class<T> type) {
        if (applicationContext == null){
            return null;
        }
        return applicationContext.getBeansOfType(type);
    }
}
