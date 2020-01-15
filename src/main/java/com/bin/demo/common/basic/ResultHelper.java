package com.bin.demo.common.basic;


import com.bin.demo.common.utils.Util;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResultHelper {
    /**
     * 构建异常Map
     * @param code
     * @param message
     * @return
     */
    public static Map<String,Object> buildExceptionMap(int code,String message)
    {
        Map<String,Object> errMap = new LinkedHashMap<>();
        errMap.put(Constants.KEY_SUCCESS,false);
        errMap.put(Constants.KEY_CODE,code);
        errMap.put(Constants.KEY_MESSAGE,message);
        return errMap;
    }

    /**
     * 构建默认异常Map
     * @return
     */
    public static Map<String,Object> buildDefaultExceptionMap(Exception e)
    {
        Map<String,Object> errMap = new LinkedHashMap<>();
        errMap.put(Constants.KEY_SUCCESS,false);
        errMap.put(Constants.KEY_CODE,Constants.DEFAULT_FAIL_CODE);
        String message = e.getMessage();
        //服务实例不可用
        if(!Util.isNull(message) && message.indexOf(Constants.NO_INSTANCE_AVAILABLE)>=0)
        {
            errMap.put(Constants.KEY_MESSAGE,Constants.NO_INSTANCE_AVAILABLE_MESSAGE);
        }else{
            errMap.put(Constants.KEY_MESSAGE,Constants.DEFAULT_FAIL_MESSAGE);
        }
        return errMap;
    }

    /**
     * 构建成功Map
     * @return
     */
    public static Map<String,Object> buildSuccessMap()
    {
        Map<String,Object> successMap = new LinkedHashMap<>();
        successMap.put(Constants.KEY_SUCCESS,true);
        successMap.put(Constants.KEY_CODE,Constants.DEFAULT_SUCCESS_CODE);
        successMap.put(Constants.KEY_MESSAGE,"");
        return successMap;
    }
}
