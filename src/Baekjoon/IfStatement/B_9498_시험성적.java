package Baekjoon.IfStatement;

import java.util.Scanner;

public class B_9498_시험성적 {

    public static boolean inspect(int score) {
        return score < 0 || score > 100;
    }

    public static String level(int score) {
        return score >= 90 && score <= 100 ? "A" :
                score >= 80 && score <= 89 ? "B" :
                score >= 70 && score <= 79 ? "C" :
                score >= 60 && score <= 69 ? "D" : "F";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("시험점수를 입력하세요 : ");
        int score = scanner.nextInt();

        while (inspect(score)) {
            System.out.println("점수의 범위가 이상합니다. : ");
            score = scanner.nextInt();
            inspect(score);
        }
        System.out.println(level(score));
    }
}
