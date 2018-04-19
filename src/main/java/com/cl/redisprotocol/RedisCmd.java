package com.cl.redisprotocol;

/**
 * description:redisCmd的命令，既可以单纯的命令，也可以是Lua脚本
 * @author chenzhilong
 */
public class RedisCmd<T> {
    /** value的值的类型，默认为object类型（key value） */
    private ValueType outParamType = ValueType.OBJECT;
    private final String name;
    private final String subName;

    public RedisCmd(ValueType outParamType, String name, String subName) {
        this.outParamType = outParamType;
        this.name = name;
        this.subName = subName;
    }

    public RedisCmd(String name, String subName) {
        this.name = name;
        this.subName = subName;
    }

    /** redis value的值的类型枚举 */
    public enum ValueType {OBJECT, MAP_VALUE, MAP_KEY, MAP}

    public ValueType getOutParamType() {
        return outParamType;
    }

    public void setOutParamType(ValueType outParamType) {
        this.outParamType = outParamType;
    }

    public String getName() {
        return name;
    }

    public String getSubName() {
        return subName;
    }
}
