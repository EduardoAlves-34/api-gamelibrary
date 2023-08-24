package com.gamelibrary.utils;

import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.hibernate.annotations.Comment;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;

@Component
public class CustomBeanUtils  {

    BeanUtilsBeanCustom beanUtil = new BeanUtilsBeanCustom();

    @SneakyThrows
    public static void copyProperties(Object dest, Object name) {
        BeanUtilsBeanCustom.getInstance().copyProperties(dest, name);
    }

    public static class BeanUtilsBeanCustom extends BeanUtilsBean {

        @Override
        public void copyProperty(Object dest, String name, Object value)
            throws IllegalAccessException, InvocationTargetException {
            if(value==null) return;
            super.copyProperty(dest, name, value);
        }
    }

}
