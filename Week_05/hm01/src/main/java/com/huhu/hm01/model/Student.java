package com.huhu.hm01.model;

import lombok.Data;

/**
 * 功能描述:
 *
 * @Author: 窦虎
 * @Date: 2020/11/17$ 23:06$
 */
@Data
public class Student {

    private String name;

    private Integer age;

    private String subject;

    public void doStudent()
    {
        System.out.println("我叫" + name + ",今年" + age + "岁,跟随秦老师学习" + subject);
    }
}
