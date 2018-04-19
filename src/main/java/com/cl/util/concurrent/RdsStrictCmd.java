package com.cl.util.concurrent;

import com.cl.redisprotocol.RedisCmd;

public class RdsStrictCmd<T> extends RedisCmd<T>{

    public RdsStrictCmd(ValueType outParamType, String name, String subName) {
        super(outParamType, name, subName);
    }

    public RdsStrictCmd(String name, String subName) {
        super(name, subName);
    }
}
