package com.geekjava0study.demo.week4;

/**
 * 功能描述:
 *
 * @Author: 窦虎
 * @Date: 2020/11/11 0:25
 */
public class HomeWorkWeek04WayOne {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            //子线程进行字符串连接操作
            int num = 1000;
            String s = "";
            for (int i = 0; i < num; i++) {
                s += "Java";
            }
            System.out.println("t Over");
        });
        //开始计时
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        t.start();
        long end = 0;
        while(t.isAlive() == true){//t.getState() != State.TERMINATED这两种判断方式都可以
            end = System.currentTimeMillis();
        }
        System.out.println("end = " + end);
        System.out.println("end - start = " + (end - start));
    }
}
