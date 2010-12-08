/**
 * 
 */
package com.zenika.dao;

import com.zenika.domain.User;

/**
 * @author acogoluegnes
 *
 */
public interface UserDao {

	User getUser(String username);
	
}
