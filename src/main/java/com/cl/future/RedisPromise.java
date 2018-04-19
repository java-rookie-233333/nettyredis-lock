package com.cl.future;

import io.netty.util.concurrent.FutureListener;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 该类是future和promise扩展的实现类
 * 在这里我们继承CompletableFuture是为了使用CompletableFuture提供的功能
 *
 * @param <T>
 * @author chenzhilong
 */
public class RedisPromise<T> extends CompletableFuture<T> implements Promise<T> {
    /** 是否可以被取消 */
    private volatile boolean uncancellable;
    /** 成功状态 */
    private final int SUCCESS = 1;
    /** 失败 */
    private final int FAILED = 2;
    /** 取消 */
    private final int CANCELED = 3;

    /** 任务状态 */
    private final AtomicInteger status = new AtomicInteger();

    public  boolean trySuccess(T result) {
        /** 如果操作成功，代表设置成功状态没有失败 */
        if(status.compareAndSet(0 , SUCCESS)){
            complete(result);
            return true;
        }
        /** 如果失败，代表以经被其他线程操作过 */
        return false;
    }

    public boolean tryFaild(Throwable exception) {
        if(status.compareAndSet(0 , FAILED)) {
            completeExceptionally(exception);
            return true;
        }
        return false;
    }

    /**
     * Method  isSuccess
     * Description  本可以用isDone来判断是否成功，但是由于扩展原因
     * 会存在isDone方法是成功的，但是却出现了异常，这种情况下我们是需要
     * 返回false的
     * CreateDate 2018/4/18  下午6:22
     * @author  chenzhilong
     * @param
     * @return boolean
     */
    public boolean isSuccess() {
        return isDone() && !isCompletedExceptionally();
    }

    @Override
    public T getResult(T t) {
        /** 如果出现异常 */
        if (isCompletedExceptionally())
            return null;
        return getNow(null);
    }

    /**
     * 这里非常巧妙，由于tryFaild方法调用，底层getNow方法一定会抛出我们tryFaild的异常
     * @return
     */
    public Throwable exception() {
        try {
            getNow(null);
        } catch (CompletionException e) {
            return e.getCause();
        }
        return null;
    }

    public Promise<T> addListener(FutureListener<? super T> listener) {
        return null;
    }

    public Promise<T> removeListener(FutureListener<? super T> futureListener) {
        return null;
    }
}
