package Baekjoon.IfStatement;

import java.util.Scanner;

public class B_2884_알람시계_refactoring {

    public static boolean isInvalidTime(int h, int m) {
        return h < 0 || h > 23 || m < 0 || m > 59;
    }

    public static int[] before45min(int h, int m) {
        if (m < 45) {
            h = (h == 0) ? 23 : h - 1;
            m = 60 + (m - 45);
        } else {
            m -= 45;
        }
        return new int[]{h, m};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int h, m;
        while (true) {
            System.out.println("상근이가 설정한 알람시간은? (예: 10 30)");
            h = scanner.nextInt();
            m = scanner.nextInt();

            if (!isInvalidTime(h, m)) break;
            System.out.println("상근아 알람 다시 설정해~!");
        }

        int[] result = before45min(h, m);
        System.out.println(result[0] + " " + result[1]);
    }
}
