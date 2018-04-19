package com.cl.config;

import io.netty.handler.ssl.SslProvider;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;

@Slf4j
@Getter
@Setter
public class RdsBaseConfig {

    /** 连接最大空闲时间 */
    private int idleConnectionTimeout = 10000;
    /** 维持心跳超时时间 */
    private int pingTimeout = 1000;
    /** 连接超时时间 */
    private int connectTimeout = 10000;
    /** 维持心跳超时时间 */
    private int timeout = 3000;
    /** 重试次数 */
    private int retryAttempts = 3;
    /** 重试间隔时间 */
    private int retryInterval = 1500;
    /** 密码 */
    private String password;
    /** 每个redis连接能够订阅的数量 */
    private int subscriptionsPerConnection = 5;
    /** 连接名称 */
    private String clientName;
    /** ssl启用端点 */
    private boolean sslEnableEndpointIdentification = true;
    private SslProvider sslProvider = SslProvider.JDK;
    /** ssl证书 */
    private URI sslTruststore;
    /** ssl证书密码 */
    private String sslTruststorePassword;
    /** ssl密钥 */
    private URI sslKeystore;
    /** ssl密钥密码 */
    private String sslKeystorePassword;
    /** 发送心跳间隔 */
    private int pingConnectionInterval;
    private boolean keepAlive;
    /** tcp是否延迟 */
    private boolean tcpNoDelay;

    public RdsBaseConfig(){}

    public RdsBaseConfig(RdsBaseConfig config){
        setPassword(config.getPassword());
        setSubscriptionsPerConnection(config.getSubscriptionsPerConnection());
        setRetryAttempts(config.getRetryAttempts());
        setRetryInterval(config.getRetryInterval());
        setTimeout(config.getTimeout());
        setClientName(config.getClientName());
        setPingTimeout(config.getPingTimeout());
        setConnectTimeout(config.getConnectTimeout());
        setIdleConnectionTimeout(config.getIdleConnectionTimeout());
        setSslEnableEndpointIdentification(config.isSslEnableEndpointIdentification());
        setSslProvider(config.getSslProvider());
        setSslTruststore(config.getSslTruststore());
        setSslTruststorePassword(config.getSslTruststorePassword());
        setSslKeystore(config.getSslKeystore());
        setSslKeystorePassword(config.getSslKeystorePassword());
        setPingConnectionInterval(config.getPingConnectionInterval());
        setKeepAlive(config.isKeepAlive());
        setTcpNoDelay(config.isTcpNoDelay());
    }
}
