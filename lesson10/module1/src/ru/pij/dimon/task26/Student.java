package ru.pij.dimon.task26;

public class Student {
    private int mark;
    private  String name;
    private String surname;

    public Student(int mark, String name, String surname) {
        this.mark = mark;
        this.name = name;
        this.surname = surname;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return surname+" "+name +": "+ mark;
    }
}
