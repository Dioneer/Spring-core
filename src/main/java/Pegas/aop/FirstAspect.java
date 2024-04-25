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
    @Pointcut("isControllerLayer() && args(org.springframwork.ui.Model,..))")
    public void hasModelArg(){

    }
    @Pointcut("isControllerLayer() && @args(Pegas.validation.UserInfo,..))")
    public void hasUserInfoParamAnnotation(){

    }
    @Pointcut("bean(*Service)")
    public void isServiceLayerBean(){

    }
    @Pointcut("execution(public Long Pegas.service.*Service.findById(Integer, *))")
    public void anyServiceFindByIdMethod(){

    }
    @Pointcut("execution(public * findById(*)")
    public void anyFindByIdMethod(){

    }

    @Before("anyServiceFindByIdMethod()" + "&& args(id)"+"&& target(service)"+"&& this(serviceProxy)")
    public void addLogging(JoinPoint joinPoint, Object id){
        log.info("Invoke findById method");
    }
    @AfterReturning(value="anyServiceFindByIdMethod()" + "&& target(service)", returning="result")
    public void addLoggingAfterReturning(JoinPoint joinPoint, Object id, Object service){
        log.info("Invoke findById method");
    }
    @AfterThrowing(value="anyServiceFindByIdMethod() && target(service)", throwing="ex")
    public void addLoggingAfterThrowing(JoinPoint joinPoint, Object service){
        log.info("Invoke findById method");
    }
    @After("anyServiceFindByIdMethod() && target(service)")
    public void addLoggingAfter(Object service){
        log.info("Invoke findById method");
    }

}
