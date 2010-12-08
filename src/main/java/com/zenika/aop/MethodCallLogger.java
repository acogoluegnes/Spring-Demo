/**
 * 
 */
package com.zenika.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author acogoluegnes
 *
 */
@Aspect
public class MethodCallLogger {
	
	private static final Logger LOG = LoggerFactory.getLogger(MethodCallLogger.class);

	@Around("execution(* com.zenika.service.impl.*.*(..)) || execution(* com.zenika.dao.jdbc.*.*(..))")
	public Object log(ProceedingJoinPoint jp) throws Throwable {
		long start = System.currentTimeMillis();
		Object res = jp.proceed();
		long end = System.currentTimeMillis();
		LOG.debug("Method {} called, returned {} in {} ms",
			new Object[]{jp.getSignature().toLongString(),res,end-start}	
		);
		return res;
	}
	
}
