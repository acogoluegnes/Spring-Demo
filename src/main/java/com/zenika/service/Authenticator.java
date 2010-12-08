/**
 * 
 */
package com.zenika.service;

/**
 * @author acogoluegnes
 *
 */
public interface Authenticator {

	boolean authenticate(String username,String password);
	
}
