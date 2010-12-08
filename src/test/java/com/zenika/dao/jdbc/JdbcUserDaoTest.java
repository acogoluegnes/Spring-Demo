package com.zenika.dao.jdbc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zenika.dao.UserDao;
import com.zenika.domain.User;

/**
 * 
 * @author acogoluegnes
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class JdbcUserDaoTest {
	
	@Autowired
	private UserDao dao;

	@Test public void getUserUserOk() {
		String username = "acogoluegnes";
		User user = dao.getUser(username);
		Assert.assertNotNull(user);
		Assert.assertEquals(username,user.getUsername());
		Assert.assertEquals("arnaud",user.getPassword());
	}
	
	@Test public void getUserNoUser() {
		Assert.assertNull(dao.getUser("dummy"));
	}
	
}
