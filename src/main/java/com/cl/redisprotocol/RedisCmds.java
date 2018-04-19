package com.cl.redisprotocol;

import com.cl.util.concurrent.RdsStrictCmd;

public interface RedisCmds {
    RdsStrictCmd<Long> EVAL_LONG = new RdsStrictCmd<Long>("EVAL" , null);
}
