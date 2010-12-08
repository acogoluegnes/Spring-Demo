/**
 * 
 */
package com.zenika.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.zenika.dao.UserDao;
import com.zenika.domain.User;
import com.zenika.service.Authenticator;

/**
 * @author acogoluegnes
 *
 */
@Transactional
public class AuthenticatorImpl implements Authenticator {
	
	private UserDao userDao;
	
	@Autowired
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
