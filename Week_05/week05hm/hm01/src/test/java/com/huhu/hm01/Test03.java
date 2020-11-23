package com.huhu.hm01;

import com.huhu.hm01.model.Student;
import com.huhu.hm01.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 功能描述:
 *
 * @Author: 窦虎
 * @Date: 2020/11/18$ 00:29$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class Test03 {

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
