package com.bin.demo.common.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * application.properties配置读取
 */
public class ApplicationPropertyUtil {
    private static Properties props;
    static{
        loadProps();
    }
    synchronized static private void loadProps(){
        props = new Properties();
        InputStream in = null;
        try
        {
            in = ApplicationPropertyUtil.class.getClassLoader().getResourceAsStream("application.yml");
            props.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != in) {
                    in.close();
                }
            } catch (IOException e) {
               e.printStackTrace();
            }
        }
    }

    public static String getProperty(String key){
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        if(null == props) {
            loadProps();
        }
        return props.getProperty(key, defaultValue);
    }
}
