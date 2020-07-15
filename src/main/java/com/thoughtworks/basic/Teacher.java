package com.thoughtworks.basic;

public class Teacher extends Person{
    private String name;
    private int age;
    private String job;

    public Teacher(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    @Override
    public String introduce(){
        return "My name is "+name+". I am "+age+" years old. I am a "+job+".";
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
