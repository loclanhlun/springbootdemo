package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectConfig {

    private Logger logger = LoggerFactory.getLogger(AspectConfig.class);

    @Before(value = "execution(* com.example.demo.controller.*.*(..))")
    public void logStatementBefore(JoinPoint joinPoint) {
        logger.info("Execution {}", joinPoint.toString());
    }

    @After(value = "execution(* com.example.demo.controller.*.*(..))")
    public void logStatementAfter(JoinPoint joinPoint) {
        logger.info("Complete Execution {}", joinPoint.toString());
    }

//    @Around(value = "execution(* com.example.demo.service.*.*(..))")
//    public Object handler(ProceedingJoinPoint joinPoint) {
//        try {
//            Object o = joinPoint.proceed();
//            return o;
//        }catch (StudentException e) {
////            logger.info("StudentExcetion Status Code {}", e.getHttpStatus().value());
//            logger.info("StudentExcetion Message {}", e.getMessage());
////            throw new ResponseStatusException(e.getHttpStatus(),e.getMessage());
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        return null;
//    }
}
