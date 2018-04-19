package com.cl.misc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 用来再关闭应用程序时，保证redis的命令操作完成
 * @author chenzhilong
 */
public class UnlimitedSemaphoreLatch  extends AbstractQueuedSynchronizer{
    private static final long serialVersionUID = -3781075226624638756L;
    /** 是否关闭 */
    private volatile boolean closed;
    /** state==open_state时，代表Redis命令操作完成 */
    private static final int OPEN_STATE = 0;
    /** 用来记录目前没有操作成功的数量 */
    private AtomicInteger sharedSource = new AtomicInteger();

    public UnlimitedSemaphoreLatch(){
        setState(OPEN_STATE);
    }

    public void close(){
        closed = true;
    }

    public boolean isClosed(){
        return closed;
    }

    public boolean acquire(){
        // 如果程序关闭，不再发送命令
        if(closed){
            return false;
        }
        releaseShared(sharedSource.incrementAndGet());
        return true;
    }

    //关闭应用程序时需要调用此方法
    public boolean awaitComplete(){
        try{
            return await(15 , TimeUnit.SECONDS);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return false;
        }
    }

    private boolean await(long time, TimeUnit unit) throws InterruptedException {
        //超时获取锁
        return tryAcquireSharedNanos(1, unit.toNanos(time));
    }

    public void release(){
        releaseShared(sharedSource.decrementAndGet());
    }

    protected int tryAcquireShared(int arg) {
        return getState() == OPEN_STATE ? 1 : -1;
    }

    protected boolean tryReleaseShared(int arg) {
        setState(arg);
        return true;
    }
}
