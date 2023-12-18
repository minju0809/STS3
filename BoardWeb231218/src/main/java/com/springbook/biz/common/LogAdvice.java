package com.springbook.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAdvice {
	
	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
	public void allPointcut() {}
	
	@Pointcut("execution(* com.springbook.biz..*Impl.get*(..))")
	public void getPointcut() {}
	
	public void printLog() {
		System.out.println("[공통 로그]");
	}
	
	@Before("allPointcut()")
	public void beforeLog() {
		System.out.println("[Before] 비즈니스 로직 수행 전 beforeLog 동작");
	}
	
	@After("allPointcut()")
	public void afterLog() {
		System.out.println("[After] 비즈니스 로직 수행 후 afterLog 동작");
	}
	
	public void afterReturningLog() {
		System.out.println("[공통로그] 비즈니스 로직 수행 후 afterReturningLog 동작");
	}
}
