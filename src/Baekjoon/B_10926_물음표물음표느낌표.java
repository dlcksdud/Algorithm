package Baekjoon;

import java.util.Scanner;

public class B_10926_물음표물음표느낌표 {

//    public static boolean inspect(String input) {
//        boolean hasUppercaseAndWrongLength = false;
//        boolean hasUppercase = false;
//        boolean wrongLength = false;
//        for(char c : input.toCharArray()) {
//            if(Character.isUpperCase(c)) {
//                hasUppercase = true;
//                break;
//            }
//        }
//        if(input.length() > 50) {
//            wrongLength = true;
//        }
//        if(hasUppercase || wrongLength) {
//            hasUppercaseAndWrongLength = true;
//        }
//        return hasUppercaseAndWrongLength;
//    }

    public static boolean inspect(String input) {
        boolean hasUppercase = input.chars().anyMatch(Character::isUpperCase);
        boolean wrongLength = input.length() > 50;

        return hasUppercase || wrongLength;
    }

    public static void main(String[] args) {
        /**
         * 문제 :  joonas라는 아이디가 이미 존재, 준하가 가입하려고 하는 사이트에 이미 존재하는 아이디가 주어졌을 때, 놀람을 표현하는 프로그램을 작성하시오.
         * 입력 : 첫째 줄에 준하가 가입하려고 하는 사이트에 이미 존재하는 아이디가 주어진다. 아이디는 알파벳 소문자로만 이루어져 있으며, 길이는 50자를 넘지 않는다.
         * 출력 : 첫째 줄에 준하의 놀람을 출력한다. 놀람은 아이디 뒤에 ??!를 붙여서 나타낸다.
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("가입하려는 아이디를 적어주세요.");
        String inputId = scanner.nextLine();

        boolean result = inspect(inputId);

        while(result) {
            System.out.println("아이디가 잘못되었습니다. 다시 입력하세요. : ");
            inputId = scanner.nextLine();
            result = inspect(inputId);
        }

        System.out.println(inputId + "??!");
    }
}
