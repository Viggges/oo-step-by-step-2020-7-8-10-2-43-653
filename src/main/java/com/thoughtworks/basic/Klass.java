package com.thoughtworks.basic;

import java.util.List;

public class Klass {
    private int classNumber;
    private List<Student> students;
    private Teacher teacher;

    public Klass(int classNumber) {
        this.classNumber = classNumber;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

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
