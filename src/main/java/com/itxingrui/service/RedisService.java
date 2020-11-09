package com.itxingrui.service;

import jdk.nashorn.internal.ir.CallNode;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class RedisService {

    Jedis jedis = new Jedis("localhost", 6379);

    /**
     * 添加String类型
     */
    public String setString(String key, String value) {
        String set = jedis.set(key, value);
        return set;
    }

    /**
     * 添加String类型，可配置超期时长
     * @param key
     * @param value
     * @param timeout 超期时长（秒）
     * @return
     */
    public String setString(String key, String value, Integer timeout) {
        String set = jedis.set(key, value);
        jedis.expire(key, timeout);
        return set;
    }

    /**
     * 获取StringValue
     * @param key
     * @return
     */
    public String getStringValue(String key) {
        return jedis.get(key);
    }

    /**
     * 通过Key删除指定Value
     * @param key
     */
    public void delByKey(String key) {
        jedis.del(key);
    }
}
