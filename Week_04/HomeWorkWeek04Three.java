package com.geekjava0study.demo.week4;

/**
 * 功能描述: syn关键字
 *
 * @Author: 窦虎
 * @Date: 2020/11/11 0:36
 */
public class HomeWorkWeek04Three {

    public static void main(String[] args) {

        Object lock = new Object();
        HomeWorkCommonClass common = new HomeWorkCommonClass();
        Thread t = new Thread(() -> {
            common.getRandom();
            synchronized (lock) {//获取对象锁
                lock.notify();//子线程唤醒
            }
        });
        //启动子线程
        t.start();
        try {
            synchronized (lock) {
                lock.wait();//主线程等待
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Integer value = common.getValue();
        System.out.println("得到的Value:::" + value);
    }
}
