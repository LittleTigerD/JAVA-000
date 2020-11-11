package com.geekjava0study.demo.week4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 功能描述: shutdown
 *
 * @Author: 窦虎
 * @Date: 2020/11/11 0:45
 */
public class HomeWorkWeek04Five {

    public static void main(String[] args) {
        HomeWorkCommonClass common = new HomeWorkCommonClass();
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Thread t = new Thread(() -> {
            common.getRandom();
        });
        Future future = executorService.submit(t);//子线程启动
        try {
            future.get();//需要捕获两种异常
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }
        Integer value = common.getValue();
        System.out.println("得到的Value:::" + value);
        executorService.shutdown();
    }
}
