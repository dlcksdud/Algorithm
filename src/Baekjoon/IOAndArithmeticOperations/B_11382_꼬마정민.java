package Baekjoon.IOAndArithmeticOperations;

import java.util.Optional;
import java.util.Scanner;

public class B_11382_꼬마정민 {

    static double[] doubArr;
    public static double[] split (String abc) {
        String[] strArr = abc.split(" ");
        doubArr = new double[strArr.length];
        for(int i = 0; i < strArr.length; i++) {
            doubArr[i] = Double.parseDouble(strArr[i]);
        }
        return doubArr;
    }
    public static boolean inspect (double[] doubArr) {
        double maxNum = Math.pow(10, 12);
//        System.out.println(maxNum);// 10의 12승
        boolean result = false;
        for(double a : doubArr) {
            if(a < 1 || a > maxNum) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("공백을 기준으로 세개의 수를 입력하세요 : ");
        String abc = scanner.nextLine();
        double[] abcArr = split(abc);

        while (inspect(abcArr)) {
            System.out.println("수의 범위가 잘못되었습니다 : ");
            abc = scanner.nextLine();
            inspect(split(abc));
        }

        System.out.println((int) Math.floor(doubArr[0] + doubArr[1] + doubArr[2]));
    }
}
