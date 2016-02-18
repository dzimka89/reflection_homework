package com.reflection_hw;

import java.lang.reflect.*;

/**
 * Created by Dmitriy on 18.02.2016.
 */
public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class myClass = Class.forName(MyClass.class.getName());
        Object newObject = myClass.newInstance();
        //System.out.println("----->" + newObject);

        System.out.println("----------------------->Constructors:<-----------------------------\n");
        Constructor constructors[] = myClass.getDeclaredConstructors();
        int count = 1;
        for (Constructor constructor : constructors) {
            System.out.println("Constructor number " + count++);
            System.out.println("Name -->" + constructor.getName());
            Parameter parameters[] = constructor.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Parameter name is " + parameter.getName());
                System.out.println("Parameter type is " + parameter.getType());
            }
            int modifiere = constructor.getModifiers();
            System.out.println("Modifier is " + getAllModifiers(modifiere) + "\n");

        }

        System.out.println("----------------->Class methods:<------------------- \n");

        Method methods[] = myClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println();
            System.out.println("Method name: " + method.getName());
            Class params[] = method.getParameterTypes();
            for (Class param : params) {
                System.out.println("Parameter " + (param.isArray()
                        ? param.getComponentType().getSimpleName()
                        : param.getSimpleName()));
            }

            int modifier = method.getModifiers();
            System.out.println("Modifier is " + getAllModifiers(modifier) + "\n");
        }

        System.out.println("---------------------->Fields<--------------------------\n");
        Field fields[] = myClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field name: " + field.getName());
            Class param = field.getType();
            System.out.println("Parameter " + param.getSimpleName());

            //System.out.println("Field type: " + field.getType());
            int modifier = field.getModifiers();
            System.out.println("Modifier: " + getAllModifiers(modifier) + "\n");
        }


    }

    private static String getAllModifiers(int modifier) {
        StringBuilder answer = new StringBuilder();
        if (Modifier.isAbstract(modifier)) {
            answer.append(" abstract ");
        }
        if (Modifier.isPublic(modifier)) {
            answer.append(" public ");
        }
        if (Modifier.isFinal(modifier)) {
            answer.append(" final ");
        }
        if (Modifier.isStatic(modifier)) {
            answer.append(" static ");
        }
        if (Modifier.isPrivate(modifier)) {
            answer.append(" private ");
        }
        if (Modifier.isProtected(modifier)) {
            answer.append(" protected ");
        }
        return answer.toString();
    }
}
