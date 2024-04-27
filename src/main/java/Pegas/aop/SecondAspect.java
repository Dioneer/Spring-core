package Pegas.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@Order(2)
public class SecondAspect {
    @Around("Pegas.aop.FirstAspect.anyServiceFindByIdMethod() && target(service) && args(id)")
    public Object addLoggingAround(ProceedingJoinPoint joinPoint, Object service, Object id) throws Throwable {
        log.info("Before Invoke findById method in class {}, with id {}", service, id);
        try{
            Object result = joinPoint.proceed();
            log.info("AfterReturning Invoke findById method in class {}, result {}", service, result);
            return result;
        }catch(Throwable ex){
            log.info("AfterThrowing Invoke findById method in class {}, throwing {}", service, ex);
            throw ex;
        } finally{
            log.info("After Invoke findById method");
        }
    }
}
