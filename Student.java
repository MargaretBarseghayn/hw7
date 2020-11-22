package model;

public class Student {
    private final String firstName;
    private final String lastName;
    private final int year;
    private final String gender;
    private final double mark;

    public Student(String firstName, String lastName, int year, String gender, double mark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.gender = gender;
        this.mark = mark;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYear() {
        return year;
    }

    public String getGender() {
        return gender;
    }

    public double getMark() {
        return mark;
    }

    public void printInfo() {
        System.out.printf("Student.firstName = %s%nStudent.lastName = %s%nStudent.year = %d%nStudent.gender = %s%nStudent.mark = %.2f%n",
                firstName, lastName, year, gender, mark);
        System.out.println("*************");
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
