package com.thoughtworks.basic;

public class Klass {
    private int classNumber;

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    @Override
    public String toString(){
        return String.valueOf(classNumber);
    }
}
