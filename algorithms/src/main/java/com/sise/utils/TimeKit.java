package com.sise.utils;

import java.util.Date;

/**
 * Created by rola on 2017/5/13.
 */
public class TimeKit {

    public static void spend(Date start) {
        Date currentTime = new Date();
        long time = currentTime.getTime() - start.getTime();
        System.out.println("消耗时间： " + time );
    }
}
