package com.cl.redisprotocol.decoder;

public interface MultiDecoder<T> {
    Decoder<T> getDecoder();
}
