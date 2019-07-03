package com.wywhdgg.dzb.cluster;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@Profile("a7_cluster")
public class ClusterServiceTests {
    @Autowired
    private ClusterService service;
    
    @Test
    public void test() {
    	service.set("cluster", "clusterRedis");
    }
}
