package Codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 후기 :
 * codility 두번째인데 영어로 되있어서 일단. 어렵고.
 * java 알고리즘 공부 더 필요..
 * Iterator
 * Collections
 */
public class C_BinaryGap {
    /**
     * 문제
     * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
     * For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.
     * Write a function:
     * class Solution { public int solution(int N); }
     * that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
     * For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
     * Write an efficient algorithm for the following assumptions:
     * N is an integer within the range [1..2,147,483,647].
     */
    public static int solution(int N) {
        int solutionResult;
        // 9 == 1001 간격 2
        String str = Integer.toBinaryString(N);

        // char 배열 선언 후 문자열을 문자 배열로 변환
        char[] charArr = str.toCharArray();
        int[] intArr = new int[charArr.length];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < charArr.length; i++) {
            intArr[i] = Character.getNumericValue(charArr[i]);
            if(intArr[i] == 1) {
                list.add(i);
            }
        }
        Iterator<Integer> iterator = list.iterator();
        int[] arr = new int[list.size()];
        int index = 0;


        while(iterator.hasNext()) {
            // 0 3 9 11
            // for(int y = 0; y < arr.length; y++) {
            //     arr[y] = iterator.next();
            // }
            arr[index++] = iterator.next();
        }

        ArrayList<Integer> compareList = new ArrayList<>();
        if(arr.length == 1) {
            solutionResult = 0;
        } else {
            for(int x = 0; x < arr.length - 1; x++) {
                compareList.add(arr[x + 1] - (arr[x] + 1));
            }
        }

        solutionResult = compareList.isEmpty() ? 0 : Collections.max(compareList);

        // 예를들어 1001
        // 문자를 하나씩 돌다가 1이면 자릿수 반환
        // 0, 3 반환 -> 3 - (0 + 1) 이면 이진 갭 2
        // 예를 들어 100
        // 0 반환 -> 이진 갭 0
        // 예를 들어 100100
        // 0, 3
        // 예를 들어 1000010001
        // 0, 5, 9 반환 -> 5-(0+1) , 9-(5+1) 이진 갭 4랑 3 비교해서 4 반환
        // 0-5 =

        return solutionResult;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력하시오 : ");
        int n = scanner.nextInt();

        System.out.println(solution(n));
    }
}
