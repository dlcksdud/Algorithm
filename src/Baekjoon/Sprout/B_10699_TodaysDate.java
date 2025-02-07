package Baekjoon.Sprout;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class B_10699_TodaysDate {

    /**
     * Q. 서울의 오늘날짜를 출력하는 프로그램을 작성하시오.
     * 입력 : 없음
     * 출력 : 서울의 오늘 날짜를 "YYYY-MM-DD" 형식
     * 출력 예제 : 2015-01-24
     */

    public static void main(String[] args) {
        // 서울의 시간대 설정
        ZoneId seoulZone = ZoneId.of("Asia/Seoul");

        // 오늘 날짜 가져오기
        LocalDate today = LocalDate.now(seoulZone);
        System.out.println(today);

        // 포맷지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String formattedData = today.format(formatter);

        // 출력
        System.out.println("서울의 오늘 날짜 : " + formattedData);
    }



}
