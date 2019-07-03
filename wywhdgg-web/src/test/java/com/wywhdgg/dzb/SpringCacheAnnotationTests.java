package com.wywhdgg.dzb;

import com.wywhdgg.dzb.pojo.User;
import com.wywhdgg.dzb.service.SpringCacheAnnotationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("single") // 设置profile
public class SpringCacheAnnotationTests {

    @Autowired
    SpringCacheAnnotationService springCacheAnnotationService;

    // ---------------spring cache注解演示
    // get
    @Test
    public void springCacheTest() throws Exception {
        User user = springCacheAnnotationService.findUserById("hash");
        System.out.println(user);
    }

    // update
    //@Test
    public void springCacheTest2() throws Exception {
        springCacheAnnotationService.updateUser(new User("hhhhhhh-2", "hash"));
        User user = springCacheAnnotationService.findUserById("hash");
        System.out.println(user);
    }

    // delete
    //@Test
    public void springCacheTest3() throws Exception {
        springCacheAnnotationService.deleteUserById("hash");
    }
}
