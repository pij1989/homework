package ru.pij.dimon;

import java.util.Scanner;

public class ConvertDate {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter date in seconds:");
        String second = scan.nextLine();
        int s = 0;
        try {
            s = Integer.parseInt(second);
        } catch (NumberFormatException e) {
            System.out.println("Error format");
            return;
        }
        int sec, m, min, h;
        sec = s % 60;
        m = (s - sec) / 60;
        min = m % 60;
        h = (m - min) / 60;
        int hour, week, day, d;
        hour = h % 24;
        d = (h - hour) / 24;
        day = d % 7;
        week = (d - day) / 7;
        System.out.println(week + " week " + day + " day " + hour + " hour " + min + " minute " + sec + " second");
    }
}

