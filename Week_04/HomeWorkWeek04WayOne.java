package com.geekjava0study.demo.week4;

/**
 * 功能描述: 正常结束
 *
 * @Author: 窦虎
 * @Date: 2020/11/11 0:25
 */
public class HomeWorkWeek04WayOne {

    public static void main(String[] args) {
        HomeWorkCommonClass common = new HomeWorkCommonClass();
        Thread t = new Thread(() -> {
            common.getRandom();
        });
        t.start();
        Integer value = common.getValue();
        System.out.println("得到的Value:::" + value);
    }
}
