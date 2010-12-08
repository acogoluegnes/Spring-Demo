/**
 * 
 */
package com.zenika.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.zenika.dao.UserDao;
import com.zenika.domain.User;
import com.zenika.service.Authenticator;

/**
 * @author acogoluegnes
 *
 */
@Named
@Transactional
public class AuthenticatorImpl implements Authenticator {
	
	private UserDao userDao;
	
	@Inject
	public AuthenticatorImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	public boolean authenticate(String username, String password) {
		User user = userDao.getUser(username);
		if(user == null || !user.getPassword().equals(password)) {
			return false;
		} else {
			return true;
		}
	}
	
}
