package edu.miu.cs.cs425.studentrecordsmgmtapp.model;

import java.time.LocalDate;

import static java.lang.StringTemplate.STR;

public class Student {
    private static int id = 110000;
    private int studentId;
    private String name;
    private LocalDate dateOfAdmission;

    {
        id++;
    }

    public Student() {
        this.studentId = id;
    }
    public Student( String name, LocalDate dateOfAdmission) {
        this.studentId = id;
        this.name = name;
        this.dateOfAdmission = dateOfAdmission;
    }

    public Student(int studentId, String name, LocalDate dateOfAdmission) {
        this.studentId = studentId;
        this.name = name;
        this.dateOfAdmission = dateOfAdmission;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(LocalDate dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    @Override
    public String toString() {
        return STR."""
                Id: \{studentId}
                Name: \{name}
                Date of Admission: \{dateOfAdmission}
                """;
    }
}
