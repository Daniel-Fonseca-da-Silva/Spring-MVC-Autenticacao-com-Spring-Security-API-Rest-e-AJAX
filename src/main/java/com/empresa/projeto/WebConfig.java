package com.empresa.projeto;

import com.empresa.projeto.interceptor.InterpectadorDeAcessos;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InterpectadorDeAcessos()).addPathPatterns("/**");
    }
}
