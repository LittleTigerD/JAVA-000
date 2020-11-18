package com.geekjava0study.demo.week4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 功能描述: BlockingQueue
 *
 * @Author: 窦虎
 * @Date: 2020/11/11 0:46
 */
public class HomeWorkWeek04Six {

    public static void main(String[] args) {
        HomeWorkCommonClass common = new HomeWorkCommonClass();
        BlockingQueue queue = new ArrayBlockingQueue(1);//数组型队列，长度为1
        Thread t = new Thread(() -> {
            try {
                common.getRandom();
                queue.put("OK");//在队列中加入数据
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.start();
        try {
            queue.take();//主线程在队列中获取数据，take()方法会阻塞队列，ps还有不会阻塞的方法
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Integer value = common.getValue();
        System.out.println("得到的Value:::" + value);
    }
}
