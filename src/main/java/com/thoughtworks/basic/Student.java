package com.thoughtworks.basic;

public class Student extends Person {
    private String name;
    private int age;
    private Klass classNumber;

    public Student(String name, int age, Klass classNumber) {
        this.name = name;
        this.age = age;
        this.classNumber = classNumber;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String introduce() {
        return "My name is " + name + ". I am " + age + " years old. I am a Student of Class " + classNumber.toString() + ".";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    public Klass getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Klass classNumber) {
        this.classNumber = classNumber;
    }
}
