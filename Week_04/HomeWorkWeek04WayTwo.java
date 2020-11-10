package com.geekjava0study.demo.week4;

/**
 * 功能描述:
 *
 * @Author: 窦虎
 * @Date: 2020/11/11 0:28
 */
public class HomeWorkWeek04WayTwo {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        t1.start();
        try {
            t.join();//注意这里
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("end = " + end);
        System.out.println("end - Start:" + (end - start));
    }
}
