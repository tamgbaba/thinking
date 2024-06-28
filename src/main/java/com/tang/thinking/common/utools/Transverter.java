package com.tang.thinking.common.utools;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Transverter {

    private static Transverter config = null;

    private Transverter() {
    }

    public static Transverter builder() {
        if (config == null) {
            synchronized (Transverter.class) {
                if (config == null)
                    config = new Transverter();
            }
        }
        return config;
    }

    public <T> T mapToPojo(Map map, Class<T> target) {
        if (map == null) return null;
        try {
            Constructor<T> constructor = target.getConstructor();
            T pojo = constructor.newInstance();
            for (Field field : target.getDeclaredFields()) {
                if (map.containsKey(field.getName().toLowerCase())) {
                    field.setAccessible(true);
                    Class<?> fieldType = field.getType();
                    field.set(pojo, map.get(field.getName().toLowerCase()));
                }
            }
            return pojo;

        } catch (NoSuchMethodException | InstantiationException | InvocationTargetException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
