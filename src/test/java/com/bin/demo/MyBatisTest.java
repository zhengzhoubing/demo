package com.bin.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * package: com.bin.demo
 * class: MyBatisTest
 * description: TODO用一句话描述该文件做什么
 *
 * @author 85321 ZhengZhouBin
 * @date 2019/4/29 0029.
 **/
public class MyBatisTest {


    @Test
    public void test() throws IOException {
        /*String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //不会自动提交数据
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MyMapper myMapper = session.getMapper(MyMapper.class);

//            TemplateType templateType = session.selectOne("com.bin.demo.dao.MyMapper.qryTemplateType", 1);
            TemplateType templateType = myMapper.qryTemplateType(1);
//            System.out.println(templateType);
            Logger logger = LoggerFactory.getLogger(MyBatisTest.class);
            logger.info(templateType.toString());
        } finally {
            session.close();
        }*/
    }

    @Test
    public void TestProxy() {
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculatorImpl();
        ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(arithmeticCalculator).getLoggingProxy();
        int result = proxy.add(1, 2);
        System.out.println("------------->" + result);

        result = proxy.sub(8, 5);
        System.out.println("-------------->" + result);
    }
}
