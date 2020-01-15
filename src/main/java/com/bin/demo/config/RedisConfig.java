package com.bin.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
    @Value("${spring.redis.host}")
    public String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.database}")
    private int database;
    @Value("${spring.redis.timeout}")
    private int timeout;
    @Value("${spring.redis.jedis.pool.max-active}")
    private int maxActive;
    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;
    @Value("${spring.redis.jedis.pool.min-idle}")
    private int minIdle;
    @Value("${spring.redis.jedis.pool.max-wait}")
    private long maxWait;
    @Value("${spring.redis.jedis.pool.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${spring.redis.jedis.pool.testOnReturn}")
    private boolean testOnReturn;
    @Value("${spring.redis.jedis.pool.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${spring.redis.jedis.pool.numTestsPerEvictionRun}")
    private int numTestsPerEvictionRun;
    @Value("${spring.redis.jedis.pool.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;
    @Bean(name = "jedisPool")
    public JedisPool jedisPool(@Qualifier("jedisPoolConfig")JedisPoolConfig jedisPoolConfig)
    {
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,host,port,timeout,null,database);
        return jedisPool;
    }
    @Bean(name="jedisPoolConfig")
    public JedisPoolConfig jedisPoolConfig()
    {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxActive);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWait);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        jedisPoolConfig.setTestOnReturn(testOnReturn);
        jedisPoolConfig.setTestWhileIdle(testWhileIdle);
        jedisPoolConfig.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        return jedisPoolConfig;
    }
}
