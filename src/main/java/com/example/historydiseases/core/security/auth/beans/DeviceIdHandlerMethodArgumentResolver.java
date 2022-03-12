//package com.example.historydiseases.core.security.auth.beans;
//
//import com.example.historydiseases.core.security.auth.DeviceId;
//
//import java.util.Optional;
//
//
//public class DeviceIdHandlerMethodArgumentResolver extends AbstractHandlerMethodArgumentResolver {
//
//    @Override
//    protected Class<?> getParameterType() {
//        return String.class;
//    }
//
//    @Override
//    protected Class getAnnotationClass() {
//        return DeviceId.class;
//    }
//
//    @Override
//    protected Object convertValue(Object o) {
//        return Optional.ofNullable(o).map(Object::toString).orElse(null);
//    }
//
//    @Override
//    protected String getTokenDetailsParameterName() {
//        return "device_id";
//    }
//
//}
