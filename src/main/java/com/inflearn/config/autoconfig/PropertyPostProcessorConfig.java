package com.inflearn.config.autoconfig;

import com.inflearn.config.MyAutoConfiguration;
import com.inflearn.config.MyConfigurationProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;

import java.util.Map;

@MyAutoConfiguration
public class PropertyPostProcessorConfig {

    @Bean
    BeanPostProcessor propertyProcessor(Environment env){
        return new BeanPostProcessor() {
            @Override // 모든 빈을 만들때 이 작업이 실행될것이다., 특정 어노테이션이 붙은 빈을 처리한다.
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                MyConfigurationProperties annotation = AnnotationUtils.findAnnotation(bean.getClass(), MyConfigurationProperties.class);
                if(annotation== null) return bean;

                Map<String, Object> attrs = AnnotationUtils.getAnnotationAttributes(annotation);
                String prefix = (String) attrs.get("prefix");
                return Binder.get(env).bindOrCreate(prefix,bean.getClass());// 없을경우 만들어 놓는다.
            }
        };
    }
}
