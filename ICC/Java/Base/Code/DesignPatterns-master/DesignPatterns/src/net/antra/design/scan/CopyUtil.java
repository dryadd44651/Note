package net.antra.design.scan;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CopyUtil {

    public static void copy(Object from, Object to) throws NoSuchMethodException {
        Class fromClass = from.getClass();
        Class toClass = to.getClass();

        for (Field field : fromClass.getDeclaredFields()) {
            String fieldName = field.getName();
//            field.setAccessible(true);
            Method m = fromClass.getDeclaredMethod("get"+Character.toUpperCase(fieldName.charAt(0))+fieldName.substring(1));
            try {
                Field fieldOfTo = toClass.getDeclaredField(fieldName);
                fieldOfTo.setAccessible(true);
                fieldOfTo.set(to, m.invoke(from));
            } catch (NoSuchFieldException | IllegalAccessException | InvocationTargetException e) {
                continue;
            }
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        A a = new A(20, "david");
        B b = new B();

        CopyUtil.copy(a, b);

        System.out.println(b);
    }

}


class A {
    private int age;

    String name;

    public A(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "A{" +
                "age=" + age +
                '}';
    }
}

class B {
    private int age;
    String name;

    @Override
    public String toString() {
        return "B{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}