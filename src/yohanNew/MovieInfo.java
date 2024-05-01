package yohanNew;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 영화 정보
public class MovieInfo {

    // 영화 목록 (제목, 가격, 시간)
    static List<Movie> movie;

    static {
        movie = new ArrayList<>(
                List.of(
                        new Movie("범죄도시4", 15000, createMovieTimes(), new ArrayList<>()),
                        new Movie("파묘", 15000, createMovieTimes(), new ArrayList<>()),
                        new Movie("귀멸의 칼날", 15000, createMovieTimes(), new ArrayList<>()),
                        new Movie("진격의 거인", 15000, createMovieTimes(), new ArrayList<>()),
                        new Movie("하이큐", 15000, createMovieTimes(), new ArrayList<>())
                )
        );
    }


    // 생성자
    public MovieInfo(String movieName, int fee, List<String> time, List<String> seats) {
    }

    public static List<Movie> getMovie() {
        return movie;
    }

    // 상영 시간 생성
    // 포맷팅 때문에 LocalDateTime -> String으로 변경 (문제없나?)
    private static List<String> createMovieTimes() {
        List<String> times = new ArrayList<>();
        Random random = new Random();

        // 포맷팅
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM월 dd일 a hh시 mm분");

        // 현재 시간을 기준으로 1달 후의 시간을 구합니다.
        LocalDateTime startTime = LocalDateTime.now().plusDays(30);

        // 각 영화당 5개의 랜덤한 상영 시간을 추가
        for (int i = 0; i < 5; i++) {
            // 현재 시간 ~ 30일 뒤까지의 랜덤한 시간을 생성합니다.
            LocalDateTime randomTime = startTime
                    .plusDays(random.nextInt(30))
                    .plusHours(random.nextInt(24))
                    .plusMinutes(random.nextInt(60));
            // 포맷팅하여 문자열로 변환하여 리스트에 추가합니다.
            String formattedTime = randomTime.format(formatter);
            times.add(formattedTime);
        }

        // 생성된 시간을 오름차순으로 정렬합니다.
        times.sort(String::compareTo);

        return times;
    }
}
