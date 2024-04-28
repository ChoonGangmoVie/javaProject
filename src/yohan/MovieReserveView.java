package yohan;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

import static util.SimpleInput.input;

// 프로그램의 입출력 처리 담당
public class MovieReserveView {

    private static MovieReserveRepository repository = new MovieReserveRepository();

    // 전역 변수
    private static boolean isFirstMenuPrinted = false; // 처음 메뉴 출력 여부를 관리하는 변수
    private static String preSelectedMovie = ""; // 이전에 선택한 영화

    // 프로그램 실행
    public static void reservationStart() {

        while (true) {
            if (!isFirstMenuPrinted) { // 처음 메뉴를 출력한 경우
                System.out.println("# 1. 영화예매");
            }
            isFirstMenuPrinted = true; // isFirstMenuPrinted를 true로 설정하여 다시 출력되지 않도록 함

            String menuNum = input(">> ");
            switch (menuNum) {
                case "1":
                    movieChoice();
                    break;
            }
        }
    }

    // 1. 영화 목록에서 영화를 선택
    private static void movieChoice() {

        movieList();
        String menuNum = input(">> ");
        switch (menuNum) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
                weatherChoice(menuNum);
                break;
            case "6":
                System.out.println("# 1. 영화예매");
                reservationStart();
                break;
            default:
                System.out.println("\n\n# 올바르지 않은 선택입니다.");
                reservationStart();
                break;
        }
    }

    private static void movieList() {
        System.out.println("\n\n****** 현재 상영중인 영화 목록 ******");
        System.out.println("# 1. 범죄도시4");
        System.out.println("# 2. 파묘");
        System.out.println("# 3. 귀멸의 칼날");
        System.out.println("# 4. 진격의 거인");
        System.out.println("# 5. 하이큐");
        System.out.println("=======================");
        System.out.println("# 6. 뒤로가기");
    }


    // 2. 영화 날짜 및 상영 시간 선택
    private static void weatherChoice(String menuNum) {
        int count = 1;

        // 날짜 배열
        LocalDateTime[] randomDates = new LocalDateTime[10];
        LocalDateTime[] preSelectedTimes = new LocalDateTime[10]; // 이전에 선택한 상영 시간 배열

        preSelectedMovie = menuNum;


        for (int i = 0; i < randomDates.length; i++) {
            randomDates[i] = randomDateGenerator();
            preSelectedTimes[i] = randomDates[i]; // 생성되는 시간을 미리 선택한 시간 배열에 저장
        }

        // 오름차 정렬
        Arrays.sort(randomDates);
        Arrays.sort(preSelectedTimes);
        System.out.println("preSelectedTimes = " + Arrays.toString(preSelectedTimes));

        System.out.println("\n\n****** 영화 상영 시간 ******");
        if (preSelectedMovie.equals(menuNum)) { // 이전에 선택한 영화와 동일한 영화 선택
            for (LocalDateTime selectedTime : preSelectedTimes) {
                    System.out.printf("%d. %s\n", count, formatLocalDateTime(selectedTime));
                    count++;
            }
        } else { // 새로운 영화를 선택
            for (LocalDateTime date : randomDates) {
                System.out.printf("%d. %s\n", count, formatLocalDateTime(date));
                count++;
            }
        }
        System.out.println("11. 뒤로가기");

        String selected = input(">> ");
        switch (selected) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "10":
                break;
            case "11":
                movieChoice();
                break;
            default:
                System.out.println("\n\n# 올바르지 않은 선택입니다.");
                break;
        }
    }


    // 랜덤으로 날짜 생성
    private static LocalDateTime randomDateGenerator() {
        LocalDateTime currentDate = LocalDateTime.now(); // 현재 날짜
        LocalDateTime maxDate = currentDate.plusMonths(2); // 현재 날짜 이후 2달까지의 날짜

        Random random = new Random();
        // 현재 날짜부터 maxDate까지의 초 수 중 랜덤하게 선택
        long randomSeconds = random.nextInt((int) ChronoUnit.SECONDS.between(currentDate, maxDate) + 1);

        // 시, 분 랜덤 생성 및 limit
        int randomHour = random.nextInt(24); // 0 ~ 23시까지 랜덤 시
        int randomMinute = random.nextInt(60); // 0 ~ 59까지 랜덤 분

        // 현재 날짜에 일 수를 더해서 랜덤한 날짜 생성
        LocalDateTime randomDateTime = currentDate.plusSeconds(randomSeconds);

        // LocalDateTime 시 분 리턴
        return randomDateTime.withHour(randomHour).withMinute(randomMinute);

    }

    // 날짜 포맷 메서드
    private static String formatLocalDateTime(LocalDateTime dateTime) {
        // 원하는 날짜 및 시간 포맷을 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM월 dd일 a hh시 mm분");

        // 날짜를 포맷하여 문자열로 반환
        return dateTime.format(formatter);
    }

}
