package com.cl.future;

import io.netty.util.concurrent.FutureListener;

import java.util.concurrent.CompletionStage;

/**
 *
 * description:java.util.concurrent.Future该类作为一个操作的结果，是不可预知的，代表未来的结果，
 *              可以判断操作是否完成，是否成功
 *              为了实现业务，我们需要自己去扩展java.util.concurrent.Future，并且实现CompletionStage
 *              使其功能更为强大，CompletionStage可有阶段性的对Future的结果做一些操作
 *              例如调用其thenApply方法转换Future返回的类型。非常强大
 * @author chenzhilong
 */
public interface Future<T> extends java.util.concurrent.Future<T> , CompletionStage<T>{
    /**
     * Method  isSuccess
     * Description  由于需要扩展future和promise的工能，我们的子类必须自定义判断任务是否成功的方法
     * CreateDate 2018/4/18  下午5:30
     * @author  chenzhilong
     * @param
     * @return boolean
     */
     boolean isSuccess();

    /**
     * Method  getResult
     * Description  获取future的结果
     * CreateDate 2018/4/18  下午6:01
     * @author  chenzhilong
     * @param
     * @return T
     */
     T getResult(T t);


    /**
     * Method  exception
     * Description  用来处理任务执行的堆栈异常信息
     * CreateDate 2018/4/18  下午5:32
     * @author  chenzhilong
     * @param
     * @return java.lang.Throwable
     */
     Throwable  exception();

    /**
     * Method  addListener
     * Description  netty的promise非常重要的功能就是添加了监听器机制，异步处理结果
     * CreateDate 2018/4/18  下午5:34
     * @author  chenzhilong
     * @param
     * @return com.cl.future.Future
     */
     Future<T> addListener(FutureListener<? super T> listener);

    /**
     * Method  removeListener
     * Description  移除监听器
     * CreateDate 2018/4/18  下午5:34
     * @author  chenzhilong
     * @param
     * @return com.cl.future.Future
     */
     Future<T> removeListener(FutureListener<? super T> futureListener);
}
