package com.geekjava0study.demo.week4;

/**
 * 功能描述: 使用join
 *
 * @Author: 窦虎
 * @Date: 2020/11/11 0:28
 */
public class HomeWorkWeek04WayTwo {

    public static void main(String[] args) throws InterruptedException {
        HomeWorkCommonClass common = new HomeWorkCommonClass();
        Thread t = new Thread(() -> {
            common.getRandom();
        });
        t.start();
        t.join();
        Integer value = common.getValue();
        System.out.println("得到的Value:::" + value);
    }
}
