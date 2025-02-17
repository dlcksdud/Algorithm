package Baekjoon.IfStatement;

import java.util.Scanner;

public class B_2884_알람시계 {

    static int h;
    static int m;

    public static boolean isRightTime(String[] timeArr) {
        h = Integer.parseInt(timeArr[0]);
        m = Integer.parseInt(timeArr[1]);
        return h < 0 || h > 23 || m < 0 || m > 59;
    }

    public static String before45min(int h, int m) {
        // h시 m분의 45분 전
        /**
         * 예를들어 10시 10분이면
         * 10-45 = -35
         * 10시 55분이면
         * 55-45 = 10
         * 12시 10분이면
         * 10 - 45 = -35
         * 12 - 1 = 11
         */
        String beforeH = "";
        String beforeM = "";

        if(m - 45 < 0 && h - 1 < 0) {
            beforeH = String.valueOf(24 - 1);
            beforeM = String.valueOf(60 + (m - 45));
        } else if(m - 45 < 0) {
            beforeH = String.valueOf(h - 1);
            beforeM = String.valueOf(60 + (m - 45));
        } else if(m - 45 > 0) {
            beforeH = String.valueOf(h);
            beforeM = String.valueOf(60 - (m - 45));
        }
        return beforeH + " " + beforeM;
    }

    // psvm
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("상근이가 설정한 알람시간은?");
        String sanggeenTime = scanner.nextLine();
        String[] timeArr = sanggeenTime.split(" ");

        while(isRightTime(timeArr)) {
            System.out.println("상근아 알람 다시 설정해~!");
            sanggeenTime = scanner.nextLine();
            timeArr = sanggeenTime.split(" ");
            isRightTime(timeArr);
        }

        System.out.println(before45min(h, m));

    }
}
