package com.huhu.hm01;

import com.huhu.hm01.model.Student;
import com.huhu.hm01.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 功能描述: xml扫包,加了注解
 *
 * @Author: 窦虎
 * @Date: 2020/11/17$ 23:33$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Test02 {

    @Autowired
    private StudentService studentService;

    @Test
    public void test() {
        Student student = new Student();
        student.setAge(18);
        student.setName("虎宝");
        student.setSubject("Java0期");
        studentService.studentSelfIntro(student);

    }
}
