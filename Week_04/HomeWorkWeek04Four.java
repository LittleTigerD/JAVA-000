package com.geekjava0study.demo.week4;

import java.util.concurrent.CountDownLatch;

/**
 * 功能描述: CountDownLatch
 *
 * @Author: 窦虎
 * @Date: 2020/11/11 0:44
 */
public class HomeWorkWeek04Four {

    public static void main(String[] args) {
        HomeWorkCommonClass common = new HomeWorkCommonClass();
        int threadNumber = 1;
        final CountDownLatch cdl = new CountDownLatch(threadNumber);//参数为线程个数

        Thread t = new Thread(() -> {
            common.getRandom();
            cdl.countDown();//此方法是CountDownLatch的线程数-1
        });

        t.start();
        //线程启动后调用countDownLatch方法
        try {
            cdl.await();//需要捕获异常，当其中线程数为0时这里才会继续运行
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Integer value = common.getValue();
        System.out.println("得到的Value:::" + value);
    }
}
