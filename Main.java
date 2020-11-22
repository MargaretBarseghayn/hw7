package com.company;

import model.Student;
import service.StudentService;

public class Main {

    public static void main(String[] args) {
        StudentService ss = new StudentService();
        Student[] students = ss.createStudent("C:\\Users\\Acer\\Desktop\\student.txt");

        System.out.println("Task 1: Print full names of students");
        ss.printFullName(students);

        System.out.println("Task 2: Print all male students");
        ss.printMales(students);

        System.out.println("Task 3: Print all female students who has mark greater then 50.4");
        ss.printFemalesWithSomeMark(students);

        System.out.println("Task 4: Print student information having the minimal mark");
        ss.printMinMarkStudent(students);

        System.out.println("Task 5: Print biggest male student information");
        ss.printBiggestMale(students);

        System.out.println("Task 6: Print students sorted by mark");
        ss.printByMark(students);

        System.out.println("Task 7: Print female students sorted by year");
        ss.printFemaleByYear(students);
    }
}
