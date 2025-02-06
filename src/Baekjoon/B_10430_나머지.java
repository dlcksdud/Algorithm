package Baekjoon;

import java.util.Scanner;

public class B_10430_나머지 {

    static int[] arrNum;
    public static boolean inspect(String[] num) {
        boolean isWrongNum = false;
        arrNum = new int[num.length];

        for(String str : num) {
            // 숫자로만 이뤄졌는지 검사
            if(!str.matches("\\d+")) {isWrongNum = true; break;}
            else{
                for(int a = 0; a < num.length; a++) {
                    arrNum[a] = Integer.parseInt(num[a]);
                    // 값의 범위 검사
                    if(arrNum[a] <= 1 || arrNum[a] > 10000) {isWrongNum = true;}
                }
            }
        }
        return isWrongNum;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("세 수를 공백 기준으로 입력하세요. : ");
        String[] num = scanner.nextLine().split(" ");

        while (inspect(num)) {
            System.out.println("숫자가 잘못되었습니다. 다시 입력하세요. : ");
            num = scanner.nextLine().split(" ");
            inspect(num);
        }

        int A = arrNum[0];
        int B = arrNum[1];
        int C = arrNum[2];

        System.out.println((A+B)%C);
        System.out.println(((A%C) + (B%C))%C);
        System.out.println((A*B)%C);
        System.out.println(((A%C) * (B%C))%C);
    }
}
