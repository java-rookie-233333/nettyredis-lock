package com.cl.redisprotocol;

/**
 * description:给redis发送命令和接收redis响应的协议接口
 * @author chenzhilong
 */
public interface Cmd {
    boolean tryFaild(Throwable cause);
}
