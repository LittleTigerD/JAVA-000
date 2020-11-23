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

    public void doStudent() {
        System.out.println("我叫" + name + ",今年" + age + "岁,跟随秦老师学习" + subject);
    }

    public static void main(String[] args) {
        try {
            zero();
            str();
        } catch (ArithmeticException e) {
            System.out.println("执行数字异常捕捉");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("执行空指针异常捕捉");
            e.printStackTrace();
        } finally {
            System.out.println("无论如何都来了");
        }
    }

    public static void zero() {
        int i = 1 / 0;
    }

    public static void str() {
        String str = null;
        str.equals("123");
    }
}
