package com.geekjava0study.demo.week4;

import java.util.Random;

/**
 * 功能描述:
 *
 * @Author: 窦虎
 * @Date: 2020/11/11 22:01
 */
public class HomeWorkCommonClass {

    private volatile Integer value;

    public void getRandom()
    {
        Random random = new Random();
        value = random.nextInt();
    }

    public Integer getValue()
    {
        return value;
    }
}
