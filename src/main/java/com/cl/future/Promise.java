package com.cl.future;

import io.netty.util.concurrent.FutureListener;

/**
 * promise借鉴于netty对future的扩展，future只能判断结果是否完成，获取结果等
 * promise在此基础上增加了设置结果成功和失败的接口
 * @author chenzhilong
 */
public interface Promise<T> extends Future<T>{
    /**
     * Method  trySuccess
     * Description  该方法用来设置future的结果为成功
     * CreateDate 2018/4/18  下午5:49
     * @author  chenzhilong
     * @param
     * @return boolean
     */
    boolean trySuccess(T result);

    /**
     * Method  tryFaild
     * Description  该方法和trySuccess方法对应
     * CreateDate 2018/4/18  下午5:50
     * @author  chenzhilong
     * @param
     * @return boolean
     */
    boolean tryFaild(Throwable exception);

    Promise<T> addListener(FutureListener<? super T> listener);

    Promise<T> removeListener(FutureListener<? super T> futureListener);
}
