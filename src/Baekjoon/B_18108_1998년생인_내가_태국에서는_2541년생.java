package Baekjoon;

import java.util.Scanner;

public class B_18108_1998년생인_내가_태국에서는_2541년생 {
    /**
     * 문제 : 불기 연도가 주어질 때 이를 서기 연도로 바꿔 주는 프로그램을 작성하시오.
     * 입력 : 서기 연도를 알아보고 싶은 불기 연도 y가 주어진다. (1000 ≤ y ≤ 3000)
     * 출력 : 불기 연도를 서기 연도로 변환한 결과를 출력한다.
     */
    public static boolean inspect(int boolgi) {
        return boolgi < 1000 || boolgi > 3000;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("불기연도를 입력하세요.");
        int boolgi = scanner.nextInt();

        while(inspect(boolgi)) {
            System.out.println("연도가 잘못되었습니다. 다시 입력하세요 : ");
            boolgi = scanner.nextInt();
            inspect(boolgi);
        }

        System.out.println(boolgi - 543);
    }
}
