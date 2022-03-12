//package com.example.historydiseases.core.security.auth.beans;
//
//
//import com.example.historydiseases.core.security.auth.UserPhone;
//
//import java.util.Optional;
//
//
//public class UserPhoneHandlerMethodArgumentResolver extends AbstractHandlerMethodArgumentResolver {
//
//    @Override
//    protected Class<?> getParameterType() {
//        return String.class;
//    }
//
//    @Override
//    protected Class getAnnotationClass() {
//        return UserPhone.class;
//    }
//
//    @Override
//    protected String getTokenDetailsParameterName() {
//        return "user_name";
//    }
//
//    @Override
//    protected Object convertValue(Object o) {
//        return Optional.ofNullable(o).map(Object::toString).orElse(null);
//    }
//}
