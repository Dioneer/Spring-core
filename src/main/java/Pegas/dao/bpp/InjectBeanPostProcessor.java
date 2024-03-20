package Pegas.dao.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
public class InjectBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Arrays.stream(bean.getClass().getDeclaredFields()).filter(field -> field.isAnnotationPresent(InjectBean.class))
                .forEach(field -> {
                    var objectToInject = applicationContext.getBean(field.getType());
                    field.setAccessible(true);
                    try {
                        field.set(bean, objectToInject);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
