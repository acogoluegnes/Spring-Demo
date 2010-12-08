/**
 * 
 */
package com.zenika.service.impl;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.zenika.dao.UserDao;
import com.zenika.domain.User;
import com.zenika.service.Authenticator;

/**
 * @author acogoluegnes
 *
 */
public class AuthenticatorImplTest {

	private UserDao userDao;
	private Authenticator authenticator;
	
	@Before public void setUp() {
		userDao = mock(UserDao.class);
		authenticator = new AuthenticatorImpl(userDao);
	}
	
	@Test public void noUser() {
		when(userDao.getUser(anyString()))
			.thenReturn(null);
		Assert.assertFalse(authenticator.authenticate("", ""));
	}
	
	@Test public void userButWrongPassword() {
		User user = new User();
		user.setPassword("pass");
		when(userDao.getUser(anyString()))
			.thenReturn(user);
		Assert.assertFalse(authenticator.authenticate("", "wrong"));
	}
	
	@Test public void userCorrectPassword() {
		User user = new User();
		user.setPassword("pass");
		when(userDao.getUser(anyString()))
			.thenReturn(user);
		Assert.assertTrue(authenticator.authenticate("", "pass"));
	}
	
}
