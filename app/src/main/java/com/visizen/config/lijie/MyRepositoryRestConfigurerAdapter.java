package com.visizen.config.lijie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.visizen.customer.lijie.po.CusGatPo;
import com.visizen.customer.lijie.po.CusOrgPo;
import com.visizen.sys.lijie.po.SysUserPo;
import com.visizen.sys.lijie.po.UserRoleViewPo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import java.util.List;

@Configuration
public class MyRepositoryRestConfigurerAdapter extends RepositoryRestConfigurerAdapter {

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.getCorsRegistry().addMapping("/api/**").allowedOrigins("*").allowedMethods("PUT", "POST", "GET", "OPTIONS", "DELETE");
        config.exposeIdsFor(SysUserPo.class, UserRoleViewPo.class, CusOrgPo.class, CusGatPo.class);
        super.configureRepositoryRestConfiguration(config);
    }

    @Override
    public void configureConversionService(ConfigurableConversionService conversionService) {
        super.configureConversionService(conversionService);
    }


    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        validatingListener.addValidator("afterCreate", validator());
        validatingListener.addValidator("beforeCreate", validator());
        validatingListener.addValidator("afterSave", validator());
        validatingListener.addValidator("beforeSave", validator());
        super.configureValidatingRepositoryEventListener(validatingListener);
    }

    @Override
    public void configureExceptionHandlerExceptionResolver(ExceptionHandlerExceptionResolver exceptionResolver) {
        super.configureExceptionHandlerExceptionResolver(exceptionResolver);
    }

    @Override
    public void configureHttpMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
        super.configureHttpMessageConverters(messageConverters);

    }

    @Override
    public void configureJacksonObjectMapper(ObjectMapper objectMapper) {
        super.configureJacksonObjectMapper(objectMapper);
    }

}
