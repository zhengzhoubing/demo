package com.bin.demo;

import cn.hutool.core.date.Week;
import com.bin.demo.common.utils.Util;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * package: com.bin.demo
 * class: StringStrTest
 * description: TODO用一句话描述该文件做什么
 * date 2019/10/29 14:36
 *
 * @author ZhengZhouBin
 **/
public class StringStrTest {

    @Test
    public void stringStrTest() {
        String nodeId = "999999999999999999999990000000000000";
        String str1 = nodeId.substring(0, nodeId.length()- 16);
        String str2 = nodeId.substring(nodeId.length()- 16);
        System.out.println(nodeId.substring(nodeId.length()- 3));
        System.out.println(nodeId.equals(str1 + str2));
    }

    @Test
    public void weekTest() {
        System.out.println(Week.SUNDAY.toChinese());
    }

    @Test
    public void floatTest() {
        System.out.println(Integer.MAX_VALUE);
    }
}
