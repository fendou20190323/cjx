package com.fendou.io.bio.four;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: cjx
 * @Date: 2021-02-25 14:10
 * @Description;
 */
public class HandlerServerSocketPool {
    private ExecutorService executorService;

    public HandlerServerSocketPool(int maxThreadNum , int queueSize) {
        executorService=new ThreadPoolExecutor(3,maxThreadNum,120, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(queueSize));
    }

    public void execute(Runnable target){
        executorService.execute(target);
    }
}
