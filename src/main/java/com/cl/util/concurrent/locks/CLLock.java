package com.cl.util.concurrent.locks;

import io.netty.util.Timeout;
import io.netty.util.internal.PlatformDependent;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

import java.util.UUID;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/**
 * description 分布式锁
 * @author chenzhilong
 * @author liuhongbin
 */
@Slf4j
public class CLLock implements Lock {
    /** 锁的默认到期时间 */
    public static final long LOCK_EXPIRATION_INTERVAL_SECONDS = 30;
    /** 到期更新map(定时任务执行) */
    private static final ConcurrentMap<String, Timeout> expirationRenewalMap = PlatformDependent.newConcurrentHashMap();
    /** 锁的到期时间（单位毫秒）此类可以扩展，因此作用范围为Protected */
    protected long lockLeaseTime = TimeUnit.SECONDS.toMillis(LOCK_EXPIRATION_INTERVAL_SECONDS);
//    /** 锁的唯一标识 */
//    final UUID id;

    public void lock() {
        try {
            lockInterruptibly();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }

    public void lockInterruptibly() throws InterruptedException {
        lockInterruptibly(-1 , TimeUnit.MILLISECONDS);
    }

    public void lockInterruptibly(long leaseTime, TimeUnit timeUnit) throws InterruptedException {

    }

    /**
     * 尝试获取锁
     * @return
     */
    public boolean tryLock() {
        return false;
    }

    /**
     * 尝试获取锁
     * 需要指定超时时间
     * @param time
     * @param unit
     * @return
     * @throws InterruptedException
     */
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    /**
     * 释放锁
     */
    public void unlock() {

    }

    public Condition newCondition() {
        return null;
    }
}
