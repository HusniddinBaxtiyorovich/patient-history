//package com.example.historydiseases.core.security.config;
//
//import com.example.historydiseases.core.security.auth.beans.DeviceIdHandlerMethodArgumentResolver;
//import com.example.historydiseases.core.security.auth.beans.UserIdHandlerMethodArgumentResolver;
//import com.example.historydiseases.core.security.auth.beans.UserPhoneHandlerMethodArgumentResolver;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.List;
//
//@Configuration
//public class WebMvcConfiguration implements WebMvcConfigurer {
//
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
//        resolvers.add(new UserIdHandlerMethodArgumentResolver());
//        resolvers.add(new UserPhoneHandlerMethodArgumentResolver());
//        resolvers.add(new DeviceIdHandlerMethodArgumentResolver());
//    }
//
//}
