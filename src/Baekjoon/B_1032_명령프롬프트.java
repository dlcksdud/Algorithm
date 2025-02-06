package Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B_1032_명령프롬프트 {

    /**
     * Q. 문제
     * 시작 -> 실행 -> cmd를 쳐보자. 검정 화면이 눈에 보인다. 
     * 여기서 dir이라고 치면 그 디렉토리에 있는 서브디렉토리와 파일이 모두 나온다. 
     * 이때 원하는 파일을 찾으려면 다음과 같이 하면 된다.
     *
     * dir *.exe라고 치면 확장자가 exe인 파일이 다 나온다. 
     * "dir 패턴"과 같이 치면 그 패턴에 맞는 파일만 검색 결과로 나온다. 
     * 예를 들어, dir a?b.exe라고 검색하면 파일명의 첫 번째 글자가 a이고, 세 번째 글자가 b이고, 
     * 확장자가 exe인 것이 모두 나온다. 이때 두 번째 문자는 아무거나 나와도 된다. 예를 들어, acb.exe, aab.exe, apb.exe가 나온다.
     *
     * 이 문제는 검색 결과가 먼저 주어졌을 때, 
     * 패턴으로 뭘 쳐야 그 결과가 나오는지를 출력하는 문제이다. 
     * 패턴에는 알파벳과 "." 그리고 "?"만 넣을 수 있다. 
     * 가능하면 ?을 적게 써야 한다. 그 디렉토리에는 검색 결과에 나온 파일만 있다고 가정하고, 파일 이름의 길이는 모두 같다.
     *
     * 입력 :
     * 첫째 줄에 파일 이름의 개수 N이 주어진다.
     * 둘째 줄부터 N개의 줄에는 파일 이름이 주어진다.
     * N은 50보다 작거나 같은 자연수이고 파일 이름의 길이는 모두 같고 길이는 최대 50이다.
     * 파일이름은 알파벳 소문자와 '.' 로만 이루어져 있다.
     *
     * 출력 :
     * 첫째 줄에 패턴을 출력하면 된다.
     */

    public static void main(String[] args) {

        // 1. 파일 갯수와 이름을 받아옴
        Scanner scanner = new Scanner(System.in);
        int N = -1;

        String fileName = "";
        ArrayList<String> fileNames = new ArrayList<>();

        while (N <= 0 || N > 50) {
            System.out.println("파일 갯수를 입력하세요 (1~50 사이의 자연수) : ");
            N = scanner.nextInt();
            // 개행 문자를 소비하는 추가 코드
            scanner.nextLine();
            if (N <= 0 || N > 50) {
                System.out.println("파일 갯수는 1 이상 50 이하의 자연수여야 합니다. 다시 입력해 주세요.");
            }
        }

        int previousFileNameLength = -1;

        for (int i =0; i < N; i++) {
            System.out.println((i + 1) + "번째 파일 이름을 적어주세요 : ");
            fileName = scanner.nextLine();

            // 파일이름이 공백 || 파일이름 길이가 51이상 || 파일이름이 알파벳 소문자, .으로만 이루어지지 않음
            while (fileName.isBlank() ||
                    fileName.length() >= 51 ||
                    !fileName.matches("[a-z.]+") ||
                    (previousFileNameLength != -1 && fileName.length() != previousFileNameLength)
            ) {

                if(previousFileNameLength != -1 && fileName.length() != previousFileNameLength) {
                    System.out.println("파일 이름의 길이는 모두 같아야 합니다. : ");
                } else {
                    System.out.println("파일이름이 잘못되었습니다. 다시 입력하세요 :");
                }
                fileName = scanner.nextLine();

            }

            // 첫 번째 파일 이름 길이를 저장
            if (previousFileNameLength == -1) {
                previousFileNameLength = fileName.length();
            }
            fileNames.add(fileName);
        }

        // 결과를 담을 StringBuilder
        StringBuilder result = new StringBuilder();

        // 2. 파일이름의 공통된 부분 빼고 나머지는 ? 표시
        // 파일 이름 비교
        for(int i = 0; i < previousFileNameLength; i++) {
            boolean isSame= true;
            char currentChar = fileNames.get(0).charAt(i);

            for(String name : fileNames) {
                if(name.charAt(i) != currentChar) {
                    isSame= false;
                    break;
                }
            }

            if (isSame) {
                result.append(currentChar);
            } else {
                result.append("?");
            }
        }

        // 결과 출력
        System.out.println(result.toString());
    }
}
