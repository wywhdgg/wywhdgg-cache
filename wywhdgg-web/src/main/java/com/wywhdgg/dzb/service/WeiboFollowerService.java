package com.wywhdgg.dzb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * WeiboFollowerService
 * 
 */
@Service
@Profile("single")
public class WeiboFollowerService {
	// 直接注入StringRedisTemplate，则代表每一个操作参数都是字符串
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    /**
     * 收获微博粉丝一枚，路转粉
     * @param userId
     * @return
     */
    public long addFollowers(String userId) {
    	// 数据库操作
    	jdbcTemplate.execute("update followers set followerNum = followerNum + 1 where userId = '"+userId+"'");
    	
    	String key = "weibo:followers:"+userId;
    	long num = stringRedisTemplate.opsForValue().increment(key);
    	return num;
    }
    
    /**
     * 微博粉转路
     * @return
     */
    public long subFollowers(String userId) {
    	// 数据库操作
    	jdbcTemplate.execute("update followers set followerNum = followerNum - 1 where userId = '"+userId+"'");
    	
    	String key = "weibo:followers:"+userId;
    	long num = stringRedisTemplate.opsForValue().decrement(key);
    	return num;
    }
    
    /**
     * 从缓存获取当前粉丝数
     * @param userId
     * @return
     */
    public long followersFromCache(String userId) {
    	String key = "weibo:followers:"+userId;
    	String numStr = stringRedisTemplate.opsForValue().get(key);
    	if(numStr == null) {
    		// 省略数据库操作
    		numStr = "0";
    	}
    	return Long.valueOf(numStr);
    }
    
    /**
     * 从数据库获取当前粉丝数
     * @param userId
     * @return
     */
    public long followersFromDB(String userId) {
    	long numb = jdbcTemplate.
    			queryForObject("select followerNum from followers where userId = '"+userId+"'",
    					Long.class);
    	return numb;
    }
}

