package com.bin.demo.common.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.*;

public class PropertiesHelper {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesHelper.class);
    private List<String> paths;
    private Map<String,String> params = new HashMap<>();
    public PropertiesHelper(List<String> paths)
    {
        this.paths = paths;
        loadProperties();
    }

    public void loadProperties()
    {
        List<Properties> props = new ArrayList<>();
        Properties properties = null;
        try
        {
            for (String path : paths) {
                InputStream inputStream = null;
                //系统路径适配
                path = Util.adaptSystemPath(path);
                if (path.startsWith("classpath:")) {
                    path = path.replace("classpath:", "");
                    //如果classpath形式以斜杠打头,则把斜杠去掉
                    if(path.startsWith(File.separator))
                    {
                        path = path.substring(1);
                    }
                    inputStream = getClass().getClassLoader().getResourceAsStream(path);
                }  else {
                    if(path.startsWith("file:"))
                    {
                        path = path.replace("file:","");
                    }
                    File file = new File(path);
                    try
                    {
                        inputStream = new FileInputStream(file);
                    }catch (FileNotFoundException e)
                    {
                        //模仿Spring的实现，配置的时候支持classpath和file都配置同一个文件,一般classpath的applications肯定会有，所以后面即使找不到也没关系，后面绝对路径
                        //仅用于制作docker镜像包的时候映射到外面
                        logger.warn(e.getMessage());
                        continue;
                    }
                }
                if(null != inputStream)
                {
                    properties = new Properties();
                    properties.load(inputStream);
                    props.add(properties);
                }else
                {
                    logger.error(MessageFormat.format("加载文件{0}失败.......",path));
                }
            }
        }catch (Exception e)
        {
            logger.error(e.getMessage(),e);
        }
        Enumeration enums = null;
        String pKey = "";
        String pValue = "";
        for(Properties prop:props)
        {
            enums = prop.keys();
            while(enums.hasMoreElements())
            {
                pKey = enums.nextElement().toString();
                pValue = prop.getProperty(pKey);
                params.put(pKey,pValue);
            }
        }
        logger.info(MessageFormat.format("加载properties文件参数至缓存:{0}",params));
    }

    /**
     * 根据key获取value
     * @param key
     * @return
     */
    public  String getProperty(String key){
        return params.get(key);
    }

    /**
     * 取不到返回默认值
     * @param key
     * @param defaultValue
     * @return
     */
    public  String getProperty(String key, String defaultValue) {
        String value = params.get(key);
        if(!Util.isNull(value))
        {
            return value;
        }else
        {
            return defaultValue;
        }
    }
}
