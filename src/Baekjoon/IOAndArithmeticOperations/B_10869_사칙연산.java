package Baekjoon.IOAndArithmeticOperations;
import java.util.Scanner;

public class B_10869_사칙연산 {


    public static void main(String[] args) {
        /**
         * 문제 : 두 자연수 A와 B가 주어진다. 이때, A+B, A-B, A*B, A/B(몫), A%B(나머지)를 출력하는 프로그램을 작성하시오.
         * 입력 : 두 자연수 A와 B가 주어진다. (1 ≤ A, B ≤ 10,000)
         * 출력 : 첫째 줄에 A+B, 둘째 줄에 A-B, 셋째 줄에 A*B, 넷째 줄에 A/B, 다섯째 줄에 A%B를 출력한다.
         */

        Scanner scanner = new Scanner(System.in);

        System.out.println("두개의 자연수를 공백을 기준으로 입력해주세요.");
        String input = scanner.nextLine();


        String[] arrNum = input.split(" ");
        int a = Integer.parseInt(arrNum[0]);
        int b = Integer.parseInt(arrNum[1]);

        while(a < 1 || a > 10000 || b < 1 || b > 10000) {
            System.out.println("숫자가 자연수가 아닙니다.");
            input = scanner.nextLine();


            arrNum = input.split(" ");
            a = Integer.parseInt(arrNum[0]);
            b = Integer.parseInt(arrNum[1]);
            break;
        }

        int plus = a + b;
        int minus = a - b;
        int multi = a * b;
        int result = a / b;
        int remain = a % b;

        System.out.println(plus);
        System.out.println(minus);
        System.out.println(multi);
        System.out.println(result);
        System.out.println(remain);
    }
}
