package Codility;

import java.util.HashSet;
import java.util.Set;


public class C_Test_2 {
    public static void generateString(String P, String Q, int index, StringBuilder current, Set<String> results) {
        boolean nLength =
                P.length() <= 200000 &&
                        Q.length() <= 200000 &&
                        P.chars().allMatch(Character::isLowerCase) &&
                        Q.chars().allMatch(Character::isLowerCase);
        if(!nLength) {
            throw new IllegalArgumentException("P와 Q는 200,000 이하의 길이를 가지며, 소문자만 포함해야 합니다.");
        }

        int N = P.length();

        // 모든 자리를 다 채웠으면 결과 집합에 추가
        if (index == N) {
            results.add(current.toString());
            return;
        }

        // 현재 인덱스에서 P[i] 선택
        current.append(P.charAt(index));
        generateString(P, Q, index + 1, current, results);
        current.deleteCharAt(current.length() - 1); // 백트래킹

        // 현재 인덱스에서 Q[i] 선택 (P[i] == Q[i]일 경우 중복 제거)
        if (P.charAt(index) != Q.charAt(index)) {
            current.append(Q.charAt(index));
            generateString(P, Q, index + 1, current, results);
            current.deleteCharAt(current.length() - 1); // 백트래킹
        }
    }

    public static int solution(String P, String Q) {
        Set<String> results = new HashSet<>();
        generateString(P, Q, 0, new StringBuilder(), results);

        int minDistinct = Integer.MAX_VALUE;

        // 모든 가능한 S에 대해 최소한의 서로 다른 문자 개수 찾기
        for (String s : results) {
            Set<Character> uniqueChars = new HashSet<>();
            for (char c : s.toCharArray()) {
                uniqueChars.add(c);
            }
            minDistinct = Math.min(minDistinct, uniqueChars.size());
        }

        return minDistinct;

    }

    public static void main(String[] args) {
        System.out.println(solution("abc", "bcd")); // 출력: 2
    }
}
