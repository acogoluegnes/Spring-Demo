/**
 * 
 */
package com.zenika;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author acogoluegnes
 *
 */
public class RmiServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		new ClassPathXmlApplicationContext(
			"application-config.xml",
			"infrastructure-config.xml",
			"rmi-exporter.xml",
			"aop-config.xml"
		);
			
	}

}
