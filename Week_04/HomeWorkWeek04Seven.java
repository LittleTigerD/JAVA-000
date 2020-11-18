package com.geekjava0study.demo.week4;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 功能描述: CyclicBarrier
 *
 * @Author: 窦虎
 * @Date: 2020/11/11 0:47
 */
public class HomeWorkWeek04Seven {

    public static void main(String[] args) {
        HomeWorkCommonClass common = new HomeWorkCommonClass();
        CyclicBarrier barrier = new CyclicBarrier(2);//参数为线程数
        Thread t = new Thread(() -> {
            common.getRandom();
            try {
                barrier.await();//阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        t.start();
        try {
            barrier.await();//也阻塞,并且当阻塞数量达到指定数目时同时释放
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        Integer value = common.getValue();
        System.out.println("得到的Value:::" + value);
    }
}
