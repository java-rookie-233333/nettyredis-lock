package com.cl.redisprotocol;

import com.cl.future.Promise;
import com.cl.redisprotocol.decoder.MultiDecoder;
import com.cl.redisprotocol.encode.Encoder;

/**
 * description:用来给redis发送单条命令的协议的数据的封装
 * @author chenzhilong
 */
public class CmdData<T , P , M> implements Cmd{
    /** 用来传递任务执行 */
    private final Promise<P> promise;
    /** redis命令 */
    private final RedisCmd<T> redisCmd;
    /** lua脚本时，代表参数 */
    private final Object params[];
    /** 编码 */
    private final Encoder encoder;
    /** 解码 */
    private final MultiDecoder<M> multiDecoder;

    public CmdData(Promise<P> promise, RedisCmd redisCmd, Object[] params, Encoder encoder, MultiDecoder<M> multiDecoder) {
        this.promise = promise;
        this.redisCmd = redisCmd;
        this.params = params;
        this.encoder = encoder;
        this.multiDecoder = multiDecoder;
    }

    public Promise<P> getPromise() {
        return promise;
    }

    public RedisCmd getRedisCmd() {
        return redisCmd;
    }

    public Object[] getParams() {
        return params;
    }

    public Encoder getEncoder() {
        return encoder;
    }

    public MultiDecoder<M> getMultiDecoder() {
        return multiDecoder;
    }

    @Override
    public boolean tryFaild(Throwable cause) {
        return promise.tryFaild(cause);
    }
}
