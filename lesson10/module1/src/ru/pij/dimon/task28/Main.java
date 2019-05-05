package ru.pij.dimon.task28;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import ru.pij.dimon.task26.*;

public class Main {

    private static final String[] SURNAME = {"Петров", "Иванов", "Сидоров", "Климов", "Кипелов", "Кинчев", "Летов", "Васильев", "Бегунов", "Кривоухов", "Сазонов", "Тетерин", "Косыгин", "Преоброженский", "Жириновский"};
    private static final String[] FEMALE_NAME = {"Александра", "Евгения", "Марина", "Людмила", "Ольга", "Наталья", "Татьяна", "Юлия", "Алиса", "Алина"};
    private static final String[] MALE_NAME = {"Дмитрий", "Александр", "Алексей", "Сергей", "Василий", "Егор", "Владимир", "Игорь", "Павел", "Николай"};

    public static void main(String[] args) {
        Random random = new Random();
        List<Student> listStudent = new ArrayList<>();
        boolean isMale;
        for (int i = 0; i < random.nextInt(30); i++) {
            isMale = random.nextBoolean();
            listStudent.add(new Student(random.nextInt(11), generateName(random, isMale), generateSurname(random, isMale)));
        }
        System.out.println("Список учеников с оценками: " + listStudent);

        Iterator<Student> studentIterator = listStudent.iterator();
        Student student;
        int maxMark = 0;
        while (studentIterator.hasNext()){
            student = studentIterator.next();
            if(student != null) {
                int mark = student.getMark();
                if (mark > maxMark) {
                    maxMark = mark;
                }
            }
        }
        System.out.println("Cамая высокая оценка: " + maxMark);
        if (listStudent.size() != 0) {
            for (Student student1:listStudent) {
                if (student1 != null){
                    if(student1.getMark() == maxMark){
                        System.out.println("Ученики с самой высокой оценкой: " + student1);
                    }
                }
            }
        }
    }

    private static String generateName(Random random, boolean isMale) {
        if (isMale) {
            return MALE_NAME[random.nextInt(MALE_NAME.length)];
        } else {
            return FEMALE_NAME[random.nextInt(FEMALE_NAME.length)];
        }
    }

    private static String generateSurname(Random random, boolean isMale) {
        String surname;
        if (isMale) {
            surname = SURNAME[random.nextInt(SURNAME.length)];
        } else {
            surname = SURNAME[random.nextInt(SURNAME.length)];
            if (surname.charAt(surname.length() - 1) == 'в' || surname.charAt(surname.length() - 1) == 'н') {
                surname += "а";
            } else {
                surname = surname.substring(0, surname.length() - 2) + "ая";
            }
        }
        return surname;
    }
}