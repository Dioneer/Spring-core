package Pegas.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Slf4j
//@Aspect
//@Component
//@Order(2)
//public class SecondAspect {
//    @Around("anyServiceFindByIdMethod() && target(service) && args(id)")
//    public Object addLoggingAround(ProceedingJoinPoint joinPoint, Object service, Object id) throws Throwable {
//        log.info("Invoke findById method");
//        try{
//            Object result = joinPoint.proceed();
//            log.info("Invoke findById method");
//            return result;
//        }catch(Throwable ex){
//            log.info("Invoke findById method");
//            throw ex;
//        } finally{
//            log.info("Invoke findById method");
//        }
//    }
//}
