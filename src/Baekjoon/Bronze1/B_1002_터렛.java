package Baekjoon.Bronze1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B_1002_터렛 {

    public static void main(String[] args) {
        /**
         * Q. 조규현, 백승환 터렛 직원
         * 이석원 : 상대편 마린(류재명)의 위치를 계산하라
         * 조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.
         * 조규현의 좌표 (x_1, y_1)와 백승환의 좌표 (x_2, y_2)가 주어지고,
         *  조규현이 계산한 류재명과의 거리 r_1과
         *  백승환이 계산한 류재명과의 거리 r_2가 주어졌을 때,
         *  류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.
         */

        Scanner scanner = new Scanner(System.in);
        // 1. 테스트 케이스의 개수 T를 입력받음
        System.out.println("테스트 케이스의 개수 : ");
        int countTestCase = scanner.nextInt();
        scanner.nextLine();


        // 2. 한줄에 공백으로 구분된 여섯 정수 가 주어짐
        // 정수 : 자연수, 자연수에 음의 부호를 붙인 수, 0도 포함
        String targetSix = "";

        int i = 0;
        int[] targetArray;

        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        int r1 = 0;
        int r2 = 0;

        // 결과를 담을 StringBuilder
        StringBuilder result = new StringBuilder();

        // 입력한 테스트 케이스의 개수만큼 입력받기
        while (i < countTestCase) {
            targetSix = scanner.nextLine();

            // 한글자씩 담고 공백이 있으면 버린다.
            // 공백으로 나눠서 담는다 : split 사용
            String[] strArray = targetSix.split(" ");

            // 정수 배열 생성
            targetArray = new int[strArray.length];

            // 문자열 배열 -> 정수 배열 변환
            for (int a = 0; a < strArray.length; a++) {
                targetArray[a] = Integer.parseInt(strArray[a]);
                System.out.println(targetArray[a]);
            }

            if(targetArray[0] < -10000 || targetArray[0] > 10000 ||
                    targetArray[1] < -10000 || targetArray[1] > 10000 ||
                    targetArray[3] < -10000 || targetArray[3] > 10000 ||
                    targetArray[4] < -10000 || targetArray[4] > 10000
            ) {
                System.out.println("x,y좌표는 -10000 <= x,y <= 10000 여야 합니다.");
                targetSix = scanner.nextLine();
            } else if(targetArray[2] < 1 || targetArray[2] > 10000 ||
                    targetArray[5] < 1 || targetArray[5] > 10000
            ) {
                System.out.println("r 좌표는 1<= r <= 10000 여야 합니다.");
                targetSix = scanner.nextLine();
            }

            x1 = targetArray[0];
            y1 = targetArray[1];
            r1 = targetArray[2];
            x2 = targetArray[3];
            y2 = targetArray[4];
            r2 = targetArray[5];

            i++;

            // 두 원의 중심 사이의 거리 계산
            double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

            // 교점의 수 계산
            if (x1 == x2 && y1 == y2 && r1 == r2) {
                // 두 원이 완전히 일치
//                System.out.println("-1");
                result.append("-1 \n");
            } else if (distance > r1 + r2 || distance < Math.abs(r1 - r2)) {
                // 두 원이 전혀 교차하지 않음
//                System.out.println("0");
                result.append("0 \n");
            } else if (distance == r1 + r2 || distance == Math.abs(r1 - r2)) {
                // 두 원이 한 점에서 교차
//                System.out.println("1");
                result.append("1 \n");
            } else {
                // 두 원이 두 점에서 교차
//                System.out.println("2");
                result.append("2 \n");
            }
        }
        System.out.println("출력 : \n" + result.toString());

        // 조규현 - 류재명 거리 : [0][1] => [2] 1 (어떤 연산) 1 => 1
        // 백승현 - 류재명 거리 : [3][4] => [5] 1 (어떤 연산) 1 => 5
        // 조규현 0 (어떤 연산) 0 => 3 / 0 (어떤 연산) 0 => 13
        // 백승현 0 (어떤 연산) 7 => 4 / 40 (어떤 연산) 0 => 37
    }
}
