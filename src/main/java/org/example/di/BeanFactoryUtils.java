package org.example.di;

import java.lang.reflect.Constructor;
import java.util.Set;
import org.example.annotation.Inject;
import org.reflections.ReflectionUtils;

public class BeanFactoryUtils {

    public static Constructor getInjectedConstructor(Class<?> clazz) {
        Set<Constructor> injectConstructors = ReflectionUtils.getAllConstructors(clazz, ReflectionUtils.withAnnotation(
            Inject.class));
        if(injectConstructors.isEmpty()){
            return null;
        }
        return injectConstructors.iterator().next();
    }

}
