/**
 * 
 */
package com.zenika;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zenika.service.Authenticator;

/**
 * @author acogoluegnes
 *
 */
public class RmiClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
			"rmi-client.xml"
		);
		
		Authenticator authenticator = ctx.getBean(Authenticator.class);
		
		String username = "acogoluegnes";
		String password = "test";
		System.out.println(username+" / "+password +" OK? "+
				authenticator.authenticate(username, password)
		);
	}

}
