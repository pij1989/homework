package ru.pij.dimon;

import java.util.Scanner;

public class ConvertDate {
    public static void main(String[] args) {

        int s = 3700;

        int sec;

        int m;

        int min, h;

        sec = s % 60;

        m = (s -sec) / 60;

        min = m % 60;

        h = (m -min) / 60;

        System.out.println(h+" часов" + min + " минут" + sec + " секунд");

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter number of hours:");

        int hr = scan.nextInt();

        int hour, week, day;

        int d;

        hour = hr%24;

        d = (hr-hour)/24;

        day = d%7;

        week = (d-day)/7;

        System.out.println(week+" week " + day + " day");

    }
}

