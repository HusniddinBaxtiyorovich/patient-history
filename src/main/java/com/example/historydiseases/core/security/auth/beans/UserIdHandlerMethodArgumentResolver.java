//package com.example.historydiseases.core.security.auth.beans;
//
//
//import com.example.historydiseases.core.security.auth.UserId;
//
//public class UserIdHandlerMethodArgumentResolver extends AbstractHandlerMethodArgumentResolver {
//
//    @Override
//    protected Class<?> getParameterType() {
//        return Long.class;
//    }
//
//    @Override
//    protected Class getAnnotationClass() {
//        return UserId.class;
//    }
//
//    @Override
//    protected Object convertValue(Object o) {
//        if (o == null) {
//            return null;
//        }
//        if (o instanceof Number) {
//            return ((Number) o).longValue();
//        }
//        throw new IllegalArgumentException("id must be a number");
//    }
//
//    @Override
//    protected String getTokenDetailsParameterName() {
//        return "user_id";
//    }
//}