package com.geekjava0study.demo.week4;

import java.util.concurrent.CountDownLatch;

/**
 * 功能描述:
 *
 * @Author: 窦虎
 * @Date: 2020/11/11 0:44
 */
public class HomeWorkWeek04Four {

    public static void main(String[] args) {
        int threadNumber = 1;
        final CountDownLatch cdl = new CountDownLatch(threadNumber);//参数为线程个数

        Thread t = new Thread(() -> {
            int num = 1000;
            String s = "";
            for (int i = 0; i < num; i++) {
                s += "Java";
            }
            System.out.println("t Over");
            cdl.countDown();//此方法是CountDownLatch的线程数-1
        });

        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        t.start();
        //线程启动后调用countDownLatch方法
        try {
            cdl.await();//需要捕获异常，当其中线程数为0时这里才会继续运行
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("end = " + end);
        System.out.println("end - start = " + (end - start));
    }
}
