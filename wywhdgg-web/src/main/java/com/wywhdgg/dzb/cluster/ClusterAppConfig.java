package com.wywhdgg.dzb.cluster;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
// 在cluster环境下生效
@Profile("a7_cluster")
@EnableCaching
class ClusterAppConfig {
	@Value("${redis_cluster}")
	private String clusterAddress;
	
    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        System.out.println("加载cluster环境下的redis client配置");
        String[] address = clusterAddress.split(",");
        List<String> redisClusterAddress = Arrays.asList(address);
        RedisClusterConfiguration redisClusterConfiguration = 
        		new RedisClusterConfiguration(redisClusterAddress);
        // 自适应集群变化
        return new JedisConnectionFactory(redisClusterConfiguration);
    }
}