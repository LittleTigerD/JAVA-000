package com.geekjava0study.demo.week4;

/**
 * 功能描述:
 *
 * @Author: 窦虎
 * @Date: 2020/11/11 0:36
 */
public class HomeWorkWeek04Three {

    public static void main(String[] args) {

        Object lock = new Object();
        Thread t = new Thread(() -> {
            int num = 1000;
            String s = "";
            for (int i = 0; i < num; i++) {
                s += "Java";
            }
            System.out.println("t Over");
            synchronized (lock) {//获取对象锁
                lock.notify();//子线程唤醒
            }
        });
        //计时
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        //启动子线程
        t.start();
        try {
            synchronized (lock) {
                lock.wait();//主线程等待
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("end = " + end);
        System.out.println("end - start = " + (end - start));
    }
}
