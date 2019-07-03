package com.wywhdgg.dzb.service;

import com.wywhdgg.dzb.pojo.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("single")
public class SpringCacheAnnotationService {

    /**
     * springcache注解版本（官方大部分资料开始往springboot方向引导，实际上不用springboot，也是差不多的方式）
     * 
     */
    // value~单独的缓存前缀
    // key缓存key 可以用springEL表达式 cache-1:123
    @Cacheable(cacheManager = "cacheManager", value = "cache-1", key = "#userId")
    public User findUserById(String userId) throws Exception {
        // 读取数据库
        User user = new User(userId, "张三");
        System.out.println("从数据库中读取到数据：" + user);
        return user;
    }

    @CacheEvict(cacheManager = "cacheManager", value = "cache-1", key = "#userId")
    public void deleteUserById(String userId) throws Exception {
    	// 先数据库删除，成功后，删除Cache
    	// 先判断Cache里面是不是有？有则删除
    	System.out.println("用户从数据库删除成功，请检查缓存是否清除~~" + userId);
    }

    // 如果数据库更新成功，更新redis缓存
    @CachePut(cacheManager = "cacheManager", value = "cache-1", key = "#user.userId", condition = "#result ne null")
    public User updateUser(User user) throws Exception {
    	// 先更新数据库，更成功
    	// 更新缓存
        // 读取数据库
        System.out.println("数据库进行了更新，检查缓存是否一致");
        return user; // 返回最新内容，代表更新成功
    }
    
    
    public boolean incr(String userId) {
    	
    	return true;
    }
}
