package Baekjoon.IfStatement;

import java.util.Scanner;

public class B_14681_사분면고르기 {

    public static int quadrant(int x, int y) {
        if(x > 0 && y > 0) {
            return 1;
        } else if(x < 0 && y > 0) {
            return 2;
        } else if (x < 0 && y < 0) {
            return 3;
        } else {
            return 4;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("정수 xy는?");
        int x = scanner.nextInt();
        scanner.nextLine();
        int y = scanner.nextInt();

        while(x < -1000 || x > 1000 || x == 0) {
            System.out.println("x를 다시 입력하세요.");
            x = scanner.nextInt();
        }
        while(y < -1000 || y > 1000 || y == 0) {
            System.out.println("y를 다시 입력하세요.");
            y = scanner.nextInt();
        }

        System.out.println(quadrant(x, y));
    }
}
