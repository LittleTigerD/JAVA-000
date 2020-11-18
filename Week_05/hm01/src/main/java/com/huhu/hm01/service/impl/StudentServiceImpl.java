package com.huhu.hm01.service.impl;

import com.huhu.hm01.model.Student;
import com.huhu.hm01.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * 功能描述:
 *
 * @Author: 窦虎
 * @Date: 2020/11/17$ 23:26$
 */
@Service
public class StudentServiceImpl implements StudentService {


    @Override
    public void studentSelfIntro(Student student) {
        System.out.println("再次自我介绍");
        student.doStudent();
    }
}
