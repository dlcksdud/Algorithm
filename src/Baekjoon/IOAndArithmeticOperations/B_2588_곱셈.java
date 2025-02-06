package Baekjoon.IOAndArithmeticOperations;

import java.util.Scanner;

public class B_2588_곱셈 {

    // 하나씩 쪼갬
    public static int[] inspect(String two) {
        System.out.println(two);
        // String으로 넘어온 세자리수를 한자리씩 쪼갠다.
        char[] charArray = two.toCharArray();
        int[] intArray = new int[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            intArray[i] = Character.getNumericValue(charArray[i]);  // char 값을 int로 변환
        }

        return intArray;
    }

    // 세자리의 자연수인지 검사
    public static boolean isNumber(int num) {
        return num > 999 || num < 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("(1) 세자리 자연수 입력 : ");
        int one = scanner.nextInt();
        scanner.nextLine();
        System.out.println("(2) 세자리 자연수 입력 : ");
        String two = scanner.nextLine();
        int twoForInt = Integer.parseInt(two);

        while (isNumber(one) || isNumber(twoForInt)) {
            System.out.println("세자리 자연수가 아닙니다. 다시 입력 : ");
            one = scanner.nextInt();
            scanner.nextLine();
            twoForInt = Integer.parseInt(scanner.nextLine());
            isNumber(one);
            isNumber(twoForInt);
        }

        int[] newArr = inspect(two).clone();
        int first = newArr[0];
        int middle = newArr[1];
        int end = newArr[2];
//        System.out.println("first : " + first);
//        System.out.println("middle : " + middle);
//        System.out.println("end : " + end);

        System.out.println(one * end + "\n" + one * middle + "\n" + one * first + "\n" + one * twoForInt);
    }
}
