package net.antra.design.scan;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class ScanDemo {

    public static void scanThisClass(String className) {
        try {
            Class clazz = Class.forName(className);
                        
            //Annotation on top of class
            Annotation[] ann = clazz.getDeclaredAnnotations();
            for (Annotation a : ann) {
                if(a instanceof Antra) {
                    System.out.println(((Antra) a).companyValue());
                }
            }
            //Annotations on Fields
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                Annotation[] fAnn = f.getDeclaredAnnotations();
                for (Annotation a : fAnn) {
                    if(a instanceof Antra) {
                        System.out.println(((Antra) a).companyValue());
                    }
                }
            }
            //Annotation on Methods
            Method[] methods = clazz.getDeclaredMethods();
            for (Method m : methods) {
                Annotation[] mAnn = m.getDeclaredAnnotations();           
                for (Annotation a : mAnn) {
                    if(a instanceof Antra) {
                        System.out.println(((Antra) a).companyValue());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
