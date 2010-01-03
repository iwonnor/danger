package com.goodworkalan.danger;

import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentMap;

@SuppressWarnings("serial")
public class ContextDanger extends Danger {
    public ContextDanger(ConcurrentMap<String, ResourceBundle> bundles, Class<?> contextClass, String code, Throwable cause) {
        super(bundles, getMessageKey(contextClass, code), null);
    }
    
    private static String getMessageKey(Class<?> contextClass, String code) {
        String className = contextClass.getCanonicalName();
        int dot = className.lastIndexOf('.');
        if (dot != -1) {
            className = className.substring(dot + 1);
        }
        return className + "/" + code;
    }
}
