package com.cl.redisprotocol.encode;

public interface Encoder {
    byte[] encode(Object object);
}
