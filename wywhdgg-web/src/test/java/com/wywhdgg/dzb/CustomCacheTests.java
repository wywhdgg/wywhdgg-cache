package com.wywhdgg.dzb;

import com.wywhdgg.dzb.pojo.User;
import com.wywhdgg.dzb.service.CustomAnnoDemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("custom") // 设置profile
public class CustomCacheTests {

    @Autowired
    CustomAnnoDemoService customDemoService;

    // get
    @Test
    public void springCacheTest() throws Exception {
        User user = customDemoService.findUserById("wahaha");
        System.out.println(user);
    }
}
