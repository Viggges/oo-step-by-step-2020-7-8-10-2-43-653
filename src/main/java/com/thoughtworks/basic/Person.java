package com.thoughtworks.basic;

public class Person {
    private String name;
    private int age;

    public String introduce(){
        return "My name is "+name+". I am +"+age+" years old.";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
