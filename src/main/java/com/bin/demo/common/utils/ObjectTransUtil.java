package com.bin.demo.common.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * package: com.bin.demo.common.utils
 * class: ObjectTransUtil
 * description: TODO用一句话描述该文件做什么
 *
 * @author 85321 ZhengZhouBin
 * @date 2019/7/22 0022.
 **/
public class ObjectTransUtil
{
    public static Map<String, Object> objToMap(Object obj)
    {
        String str = JsonUtil.toJson(obj);
        return JsonUtil.fromJson(str, Map.class);
    }

    public static List<Map<String, Object>> objToList(Object obj)
    {
        String str = JsonUtil.toJson(obj);
        return JsonUtil.fromJson(str, List.class);
    }

    public static <T> T mapToObj(Map<String, Object> map, Class<T> clazz) throws Exception {
        T obj = clazz.newInstance();
        BeanUtils.populate(obj, map);
        return obj;
    }

    /**
     * 把List<Object>转换成List<Map<String,Object>
     * @param list
     * @return
     */
    public static List<Map<String,Object>> listObjectToListMap(List list)
    {
        List<Map<String,Object>> result = new ArrayList<>();
        for(Object o : list)
        {
            result.add(objToMap(o));
        }
        return result;
    }

    /**
     * 把List<Map<String,Object>转换成List<Object>
     * @param list
     * @return
     */
    public static <T> List<T> listMapToListObject(List<Map<String,Object>> list, Class<T> clazz)
    {
        List<T> result = new ArrayList<>();
        for(Map<String,Object> m : list)
        {
            try
            {
                result.add(mapToObj(m,clazz));
            } catch (Exception e)
            {
                throw new RuntimeException(e.getMessage());
            }
        }
        return result;
    }

    /**
     * 把List<Object>转换成Map<String,Object>[]
     * @param list
     * @return
     */
    public static Map<String,Object>[] listObjectToMapArray(List list)
    {
        if(null == list)
        {
            return null;
        }
        Map<String, Object>[] result = new Map[list.size()];
        for(int i = 0; i < list.size(); i++)
        {
            result[i] = objToMap(list.get(i));
        }
        return result;
    }

    /**
     * 把List里面可能有map和object(这个object就是要转换的clazz类型),转换成List<Object>
     * @param list
     * @return
     */
    public static <T> List<T> listToListObject(List list,Class<T> clazz)
    {
        List<T> result = new ArrayList<>();
        for(Object o : list)
        {
            try
            {
                if(o instanceof Map)
                {
                    result.add(mapToObj((Map<String,Object>)o,clazz));
                }else
                {
                    result.add((T)o);
                }
            } catch (Exception e)
            {
                throw new RuntimeException(e.getMessage());
            }
        }
        return result;
    }
}