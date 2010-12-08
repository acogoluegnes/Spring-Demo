/**
 * 
 */
package com.zenika.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zenika.service.Authenticator;

/**
 * @author acogoluegnes
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/system-test-config.xml")
public class AuthenticatorIntegrationTest {

	@Autowired
	private Authenticator authenticator;
	
	@Test public void authenticate() {
		assertTrue(authenticator.authenticate("acogoluegnes", "arnaud"));
		assertFalse(authenticator.authenticate("acogoluegnes", "bad password"));
		assertFalse(authenticator.authenticate("unknown", "dummy"));
	}
	
}
