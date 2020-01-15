package com.bin.demo.common.redis;


import com.bin.demo.common.basic.Constants;
import com.bin.demo.common.exception.ApplicationException;
import com.bin.demo.common.utils.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@ConditionalOnBean(name = "jedisPool")
public class RedisHelper {
    private static final Logger logger = LoggerFactory.getLogger(RedisHelper.class);
    @Autowired
    private JedisPool jedisPool;
    public void hmset(String key, Map<String, String> map){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.del(key);
            jedis.hmset(key, map);
        } catch (Exception e) {
            jedisPool.returnBrokenResource(jedis);
            logger.error(e.getMessage(),e);
            throw new ApplicationException(Constants.DEFAULT_FAIL_CODE,e.getMessage());
        } finally {
            close(jedis);
        }
    }

    public void hmsetOne(String key, Map<String, String> map){
        if(null == map || map.size() != 1)
        {
            throw new ApplicationException(Constants.DEFAULT_FAIL_CODE,"hmsetOne only allow map contains one key!");
        }
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String field = "";
            for (String s : map.keySet()) {
                field = s;
            }
            jedis.hdel(key,field);
            jedis.hmset(key, map);
        } catch (Exception e) {
            jedisPool.returnBrokenResource(jedis);
            logger.error(e.getMessage(),e);
            throw new ApplicationException(Constants.DEFAULT_FAIL_CODE,e.getMessage());
        } finally {
            close(jedis);
        }
    }

    public String hmget(String key, String field) {

        List<String> value = null;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            value = jedis.hmget(key, field);

            if(!Util.isEmptyList(value)){
                return value.get(0);
            }
        } catch (Exception e) {
            jedisPool.returnBrokenResource(jedis);
            logger.error(e.getMessage(),e);
            throw new ApplicationException(Constants.DEFAULT_FAIL_CODE,e.getMessage());
        } finally {
            close(jedis);
        }
        return "";
    }

    public Map<String,String> hgetAll(String key) {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Map<String,String> value = jedis.hgetAll(key);
            if(null != value)
            {
                return value;
            }else{
                return new HashMap<>();
            }
        } catch (Exception e) {
            jedisPool.returnBrokenResource(jedis);
            logger.error(e.getMessage(),e);
            throw new ApplicationException(Constants.DEFAULT_FAIL_CODE,e.getMessage());
        } finally {
            close(jedis);
        }
    }

    public void set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        } catch (Exception e) {
            jedisPool.returnBrokenResource(jedis);
            logger.error(e.getMessage(),e);
            throw new ApplicationException(Constants.DEFAULT_FAIL_CODE,e.getMessage());
        } finally {
            close(jedis);
        }
    }

    public void setx(String key, int seconds,String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.setex(key,seconds,value);
        } catch (Exception e) {
            jedisPool.returnBrokenResource(jedis);
            logger.error(e.getMessage(),e);
            throw new ApplicationException(Constants.DEFAULT_FAIL_CODE,e.getMessage());
        } finally {
            close(jedis);
        }
    }

    public void del(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.del(key);
        } catch (Exception e) {
            jedisPool.returnBrokenResource(jedis);
            logger.error(e.getMessage(),e);
            throw new ApplicationException(Constants.DEFAULT_FAIL_CODE,e.getMessage());
        } finally {
            close(jedis);
        }
    }


    public String get(String key) {
        String value = null;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            value = jedis.get(key);
        } catch (Exception e) {
            jedisPool.returnBrokenResource(jedis);
            logger.error(e.getMessage(),e);
            throw new ApplicationException(Constants.DEFAULT_FAIL_CODE,e.getMessage());
        } finally {
            close(jedis);
        }
        return value;
    }


    public void close(Jedis jedis) {
        try {
            jedisPool.returnResource(jedis);
        } catch (Exception e) {
            if (jedis.isConnected()) {
                jedis.quit();
                jedis.disconnect();
            }
            logger.error(e.getMessage(),e);
            throw new ApplicationException(Constants.DEFAULT_FAIL_CODE,e.getMessage());
        }
    }

    public void subscribe(JedisPubSub listener, String... channels) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.subscribe(listener, channels);
        } catch (Exception e) {
            jedisPool.returnBrokenResource(jedis);
            logger.error(e.getMessage(),e);
            throw new ApplicationException(Constants.DEFAULT_FAIL_CODE,e.getMessage());
        } finally {
            close(jedis);
        }
    }

    public long publish(String channel, String message)
    {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            long integerReply = jedis.publish(channel, message);
            logger.info(MessageFormat.format("publish [channel={0}] [message={1}] [integerReply={2}]"
                    ,channel,message,integerReply));
            return integerReply;
        } catch (Exception e) {
            jedisPool.returnBrokenResource(jedis);
            logger.error(e.getMessage(),e);
            throw new ApplicationException(Constants.DEFAULT_FAIL_CODE,e.getMessage());
        } finally {
            close(jedis);
        }
    }

}
