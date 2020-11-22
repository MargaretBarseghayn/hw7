package service;

import model.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentService {

    public Student[] createStudent(String filePath) {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] dataArray = myReader.nextLine().split(",");
                studentArrayList.add(new Student(dataArray[0], dataArray[1], Integer.parseInt(dataArray[2]), dataArray[3], Double.parseDouble(dataArray[4])));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return studentArrayList.toArray(Student[]::new);
    }

    //Task 1: Print full names of students
    public void printFullName(Student[] students) {
        for (var student : students
        ) {
            System.out.println(student.getFullName());
        }
        System.out.println("***********");
    }

    //Task 2: Print all male students
    public void printMales(Student[] students) {
        for (var student : students
        ) {
            if (student.getGender().equals("m")) {
                student.printInfo();
            }
        }
    }

    //Task 3: Print all female students who has mark greater then 50.4
    public void printFemalesWithSomeMark(Student[] students) {
        for (var student : students
        ) {
            if (student.getGender().equals("f") && student.getMark() > 50.4) {
                student.printInfo();
            }
        }
    }

    //Task 4: Print student information having the minimal mark
    public void printMinMarkStudent(Student[] students) {
        Student minStudent = students[0];
        for (int i = 1; i < students.length; i++) {
            if (students[i].getMark() < minStudent.getMark()) {
                minStudent = students[i];
            }
        }
        minStudent.printInfo();
    }

    //Task 5: Print biggest male student information
    public void printBiggestMale(Student[] students) {
        Student biggestMale = students[0];
        int index = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getGender().equals("m")) {
                biggestMale = students[i];
                index = i;
                break;
            }
        }
        if (index == 0) {
            System.out.println("No Male student was found");
            System.out.println("***************");
            return;
        }
        for (int i = index; i < students.length; i++) {
            if (students[i].getGender().equals("m") && students[i].getYear() < biggestMale.getYear()) {
                biggestMale = students[i];
            }
        }
        biggestMale.printInfo();
    }

    private void printArray(Student[] students) {
        for (var student : students
        ) {
            student.printInfo();
        }
    }

    //Task 6: Print students sorted by mark
    public void printByMark(Student[] students) {
        printArray(sortByMark(students));

    }

    private Student[] sortByMark(Student[] students) {
        Student[] students1 = students.clone();
        Student temp;
        int length = students1.length;
        boolean swapped;
        for (int i = 0; i < length - 1; i++) {
            swapped = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (students1[j].getMark() > students1[j + 1].getMark()) {
                    temp = students1[j];
                    students1[j] = students1[j + 1];
                    students1[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
        return students1;
    }

    //Task 7: Print female students sorted by year
    public void printFemaleByYear(Student[] students) {
        ArrayList<Student> femaleStudents = new ArrayList<>();
        for (var student : students
        ) {
            if (student.getGender().equals("f")) {
                femaleStudents.add(student);
            }
        }
        Student[] students1 = femaleStudents.toArray(Student[]::new);
        printArray(sortByYear(students1));
    }

    private Student[] sortByYear(Student[] students) {
        Student[] students1 = students.clone();
        Student temp;
        int length = students1.length;
        boolean swapped;
        for (int i = 0; i < length - 1; i++) {
            swapped = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (students1[j].getYear() > students1[j + 1].getYear()) {
                    temp = students1[j];
                    students1[j] = students1[j + 1];
                    students1[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
        return students1;
    }

}
