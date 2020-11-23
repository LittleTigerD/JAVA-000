package com.huhu.hm01;

import com.huhu.hm01.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 功能描述: 纯xml注入
 *
 * @Author: 窦虎
 * @Date: 2020/11/17$ 23:35$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Test01 {


    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student huBaoStudent = (Student) applicationContext.getBean("huBaoStudent");

        huBaoStudent.doStudent();
    }
}
