package com.wywhdgg.dzb;

import com.wywhdgg.dzb.service.WeiboFollowerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * WeiboFollowers
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("single") // 设置profile
public class WeiboFollowersTests {
	
	@Autowired
	WeiboFollowerService followerService;
	
	@Test
	public void followers() {
		long followerNum = followerService.addFollowers("hash");
		System.out.println("路转粉，收获妹子一枚："+followerNum);
		
		followerNum = followerService.subFollowers("hash");
		System.out.println("粉转路，妹子离我而去："+followerNum);
		
		followerService.followersFromCache("hash");
		System.out.println("粉转路，妹子离我而去："+followerNum);
		
	}
	
}

