//package com.example.historydiseases.core.security.auth.beans;
//
//
//import java.lang.annotation.Annotation;
//import java.security.Principal;
//import java.util.Map;
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.core.MethodParameter;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
//import org.springframework.web.bind.support.WebDataBinderFactory;
//import org.springframework.web.context.request.NativeWebRequest;
//import org.springframework.web.method.support.HandlerMethodArgumentResolver;
//import org.springframework.web.method.support.ModelAndViewContainer;
//
//public abstract class AbstractHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
//    @Override
//    public boolean supportsParameter(MethodParameter methodParameter) {
//        return methodParameter.getParameterAnnotation(getAnnotationClass()) != null
//                && methodParameter.getParameterType().equals(getParameterType());
//    }
//
//    protected abstract Class<?> getParameterType();
//
//    protected abstract Class<Annotation> getAnnotationClass();
//
//    @Override
//    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory)
//            throws Exception {
//        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
//        if (request == null) {
//            throw new IllegalStateException("Current request is not of type HttpServletRequest: " + webRequest);
//        }
//
//        Principal principal = request.getUserPrincipal();
//        if (!(principal instanceof Authentication)) {
//            return null;
//        }
//
//        Authentication authentication = (Authentication) principal;
//        if (!(authentication.getDetails() instanceof OAuth2AuthenticationDetails)) {
//            return null;
//        }
//        OAuth2AuthenticationDetails authenticationDetails = (OAuth2AuthenticationDetails) authentication.getDetails();
//        if (!(authenticationDetails.getDecodedDetails() instanceof Map)) {
//            return null;
//        }
//        Map details = (Map) authenticationDetails.getDecodedDetails();
//        Object o = details.get(getTokenDetailsParameterName());
//        return convertValue(o);
//    }
//
//    protected abstract Object convertValue(Object o);
//
//    protected abstract String getTokenDetailsParameterName();
//}
