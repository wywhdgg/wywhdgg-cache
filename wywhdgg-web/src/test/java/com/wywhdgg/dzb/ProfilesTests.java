package com.wywhdgg.dzb;

import com.wywhdgg.dzb.pojo.User;
import com.wywhdgg.dzb.service.SpringCacheTemplateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("single") // 设置profile
public class ProfilesTests {
    @Autowired
    SpringCacheTemplateService exampleService;

    // ------- spring redistemplate功能演示
    @Test
    public void setTest() {
        exampleService.setByCache("hash", "hahhhhh");
        exampleService.setByCache("a", "1");
        exampleService.setByCache("foo", "bar");
    }

    @Test
    public void getTest() throws Exception {
        User user = exampleService.findUser("hash");
        System.out.println(user);
    }


}
