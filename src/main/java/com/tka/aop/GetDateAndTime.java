package com.tka.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GetDateAndTime {

	public GetDateAndTime() {

	}

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	

	@Around("execution ( * com.tka.controller.*.*(..))")
	public Object printTimeAndDate(ProceedingJoinPoint joinPoint) throws Throwable {
		Date date = new Date();
		System.err.println("Before execution --" + dateFormat.format(date));

		Object result = joinPoint.proceed(); // Proceed with the method execution
		System.err.println("After Execution>>> " + dateFormat.format(date));
		return result;

	}

}
