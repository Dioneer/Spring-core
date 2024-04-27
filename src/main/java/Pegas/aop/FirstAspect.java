package Pegas.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Aspect
@Component
@Order(1)
public class FirstAspect {
    @Pointcut("@within(org.springframework.stereotype.Controller)")
    public void isControllerLayer(){

    }
    @Pointcut("within(Pegas.service.*Service)")
    public void isServiceLayer(){

    }

    @Pointcut("this(org.springframework.stereotype.Repository)")
    public void isRepositoryLayer(){

    }
    @Pointcut("isControllerLayer() && @annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void hasGetMapping(){

    }
    @Pointcut("isControllerLayer() && args(org.springframework.ui.Model,..)")
    public void hasModelArg(){

    }
    @Pointcut("isControllerLayer() && @args(Pegas.validation.UserInfo,..)")
    public void hasUserInfoParamAnnotation(){

    }
    @Pointcut("bean(*Service)")
    public void isServiceLayerBean(){

    }
    @Pointcut("execution(public * Pegas.service.*Service.findById(*))")
    public void anyServiceFindByIdMethod(){

    }
    @Pointcut("execution(public * findById(*))")
    public void anyFindByIdMethod(){

    }

    @AfterReturning(value="anyServiceFindByIdMethod()" + "&& target(service)", returning="result")
    public void addLoggingAfterReturning(Object result, Object service){
        log.info("AfterReturning Invoke findById method in class {}, result {}", service, result);
    }
    @AfterThrowing(value="anyServiceFindByIdMethod() && target(service)", throwing="ex")
    public void addLoggingAfterThrowing(Throwable ex, Object service){
        log.info("AfterThrowing Invoke findById method in class {}, throwing {}", service, ex);
    }
    @After("anyServiceFindByIdMethod() && target(service)")
    public void addLoggingAfter(Object service){
        log.info("After Invoke findById method");
    }
    @Before("anyServiceFindByIdMethod()" + "&& args(id)"+"&& target(service)"+"&& this(serviceProxy)")
    public void addLogging(JoinPoint joinPoint, Object id, Object service, Object serviceProxy){
        log.info("Before Invoke findById method in class {}, with id {}, proxy {}", service, id, serviceProxy);
    }
}
