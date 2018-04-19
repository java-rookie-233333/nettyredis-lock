package com.cl.connection;

import java.util.UUID;

/**
 * 与redis连接的管理器
 * @author chenzhilong
 * @author liuhongbin
 */
public interface ConnectionManager {
    /** 获取客户端唯一标识 */
    UUID getId();
}
