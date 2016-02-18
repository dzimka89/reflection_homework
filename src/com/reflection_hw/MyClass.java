package com.reflection_hw;

/**
 * Created by Dmitriy on 18.02.2016.
 */
public class MyClass {
    private String name;
    private String Surname;
    private int age;

    public MyClass() {
    }

    public MyClass(String name, String surname) {
        this.name = name;
        Surname = surname;
    }

    public MyClass(String name, String surname, int age) {
        this.name = name;
        Surname = surname;
        this.age = age;
    }

    private void privateMethod(){
        System.out.println("I am private method");
    }

    protected void protectedMethod(){
        System.out.println("I am protected method");
    }

    public static int doubleAge(int age){
        return age*2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "name='" + name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", age=" + age +
                '}';
    }
}
