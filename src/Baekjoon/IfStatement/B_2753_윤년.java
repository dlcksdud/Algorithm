package Baekjoon.IfStatement;

import java.util.Scanner;

public class B_2753_윤년 {

    public static int isLeapYear(int year) {
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return 1;
        } else {
            return 0;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("연도를 쓰시오");
        int year = scanner.nextInt();

        while(year < 1 || year > 4000) {
            System.out.println("연도는 1보다 크거나 같고 4000보다 작거나 같은 자연수입니다.");
            year = scanner.nextInt();
        }

        System.out.println(isLeapYear(year));
    }
}
