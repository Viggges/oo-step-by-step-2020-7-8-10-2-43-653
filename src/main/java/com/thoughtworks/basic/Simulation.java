package com.thoughtworks.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * 模拟过程
 */
public class Simulation {
    private static final Logger log = LoggerFactory.getLogger(Simulation.class);
    static Klass classOne = new Klass(1);
    static Klass classTwo = new Klass(2);
    static List<Student> students = new ArrayList<>();
    static List<Teacher> teachers = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        // 开班
        openClass();
        // 互相自我介绍
        introduceEach();
        // 某学生改名换姓
        changeName(students.get(0), "LouHuiHui");
        // 某学生转班
        changeClass(students.get(0), classTwo);
    }

    private static void changeClass(Student student, Klass newClass) throws Exception {
        int classNumber = student.getClassNumber().getClassNumber();
        student.setClassNumber(newClass);
        Notify.notify(student);
        // 班级发生变化的时候，原有的和新的班里的学生和老师都能接收到消息；
        String message = Read.read();
        for (Student otherStudent : students) {
            if (otherStudent.getClassNumber().getClassNumber() == classNumber || otherStudent.getClassNumber() == student.getClassNumber()) {
                System.out.println(" [" + otherStudent.getName() + "] received : " + message);
            }
        }
        for (Teacher teacher : teachers) {
            System.out.println(" [" + teacher.getName() + "] received : " + message);
        }
    }

    private static void changeName(Student student, String newName) throws Exception {
        student.setName(newName);
        Notify.notify(student);
        String message = Read.read();
        // 姓名发生变化的时候，班里的其他学生和老师都能接收到消息；
        for (Student otherStudent : students) {
            if (otherStudent.getClassNumber() == student.getClassNumber()) {
                System.out.println(" [" + otherStudent.getName() + "] received : " + message);
            }
        }
        for (Teacher teacher : teachers) {
            System.out.println(" [" + teacher.getName() + "] received : " + message);
        }
    }

    private static void introduceEach() {
        for (Student student : students) {
            log.info(student.introduce());
        }
        for (Teacher teacher : teachers) {
            log.info(teacher.introduce());
        }
    }

    private static void openClass() {
        Student liLei = new Student("Lilei", 12, classOne);
        students.add(liLei);
        Student hanMeiMei = new Student("HanMeiMei", 12, classOne);
        students.add(hanMeiMei);
        Student kangKang = new Student("KangKang", 12, classTwo);
        students.add(kangKang);
        Student maria = new Student("Maria", 12, classTwo);
        students.add(maria);
        classOne.setStudents(students);
        Teacher louWei = new Teacher("LouWei", 24, "Teacher");
        teachers.add(louWei);
        classOne.setTeacher(louWei);
        Teacher lina = new Teacher("Lina", 24, "Teacher");
        teachers.add(lina);
        classTwo.setTeacher(lina);
    }
}
