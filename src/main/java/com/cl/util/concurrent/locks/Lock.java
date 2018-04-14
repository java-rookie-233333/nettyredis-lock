package com.cl.util.concurrent.locks;

import java.util.concurrent.TimeUnit;

/**
 * description 同步锁总接口
 * @author chenzhilong
 * @author liuhongbin
 */
public interface Lock extends java.util.concurrent.locks.Lock {
    /**
     * @param leaseTime
     * @param timeUnit
     * @throws InterruptedException
     */
    void lockInterruptibly(long  leaseTime , TimeUnit timeUnit) throws InterruptedException;
}
