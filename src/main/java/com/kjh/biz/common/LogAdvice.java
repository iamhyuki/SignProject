package com.kjh.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class LogAdvice {

	public LogAdvice() {
	}
	
	@Pointcut("execution(* com.kjh.biz..*Impl.get*(..))")
	public void getPointcut(){};
	
	@Around("getPointcut()")
	public Object Log(ProceedingJoinPoint pjp) throws Throwable{
		String method = pjp.getSignature().getName();
		
		StopWatch st = new StopWatch();
		st.start();
		
		Object obj = pjp.proceed();
		
		st.stop();
		
		System.out.println(method + "() 걸린 시간 : " + st.getTotalTimeMillis() + "(ms)초");
		
		return obj;
			
	}

}
