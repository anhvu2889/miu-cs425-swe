package edu.miu.cs.cs425.studentrecordsmgmtapp;

import edu.miu.cs.cs425.studentrecordsmgmtapp.model.Student;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStudentRecordsMgmtApp {
    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0] = new Student("Dave", LocalDate.of(1951, 11, 18));
        students[1] = new Student("Anna", LocalDate.of(1990, 12, 7));
        students[2] = new Student("Erica", LocalDate.of(1974, 1, 31));
        students[3] = new Student("Carlos", LocalDate.of(2009, 8, 22));
        students[4] = new Student("Bob", LocalDate.of(1994, 8, 5));
        System.out.println("List Of Students:");
        printListOfStudents(students);
        System.out.println("List Of Platinum Alumni Students:");
        System.out.println(getListOfPlatinumAlumniStudents(students));
    }

    private static void printListOfStudents(Student[] students) {
        Stream.of(students)
                .sorted(Comparator.comparing(Student::getName))
                .forEach(System.out::println);
    }

    private static List<Student> getListOfPlatinumAlumniStudents(Student[] students) {
        return Stream.of(students)
                .filter(student -> Period.between(student.getDateOfAdmission(), LocalDate.now()).getYears() >= 30)
                .sorted(Comparator.comparing(Student::getDateOfAdmission).reversed())
                .collect(Collectors.toList());
    }
}
