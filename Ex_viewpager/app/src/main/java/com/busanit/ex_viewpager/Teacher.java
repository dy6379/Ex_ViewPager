package com.busanit.ex_viewpager;

public class Teacher {
    private String division;
    private String name;
    private String subject;
    private String classroom;

    public Teacher(String division, String name, String subject, String classroom) {
        this.division = division;
        this.name = name;
        this.subject = subject;
        this.classroom = classroom;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
