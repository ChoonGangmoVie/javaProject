package junwon.movieList;


import java.util.HashMap;
import java.util.Map;

public class MovieList {
    // 영화 일정을 저장할 Map 생성
    public static Map<String, String[]> getMovieSchedule(String movieName) {
        Map<String, String[]> movieSchedule = new HashMap<>();

        // 영화 일정 추가
        movieSchedule.put("범죄도시", new String[]{
                "# 1 .05월 07일 오전 09시 00분",
                "# 2 .05월 10일 오후 03시 40분",
                "# 3 .05월 13일 오후 06시 30분",
                "# 4 .05월 16일 오후 05시 00분",
                "# 5 .05월 25일 오후 08시 10분"
        });

        movieSchedule.put("파묘", new String[]{
                "# 1 .05월 07일 오전 09시 00분",
                "# 2 .05월 10일 오후 03시 40분",
                "# 3 .05월 13일 오후 06시 30분",
                "# 4 .05월 16일 오후 05시 00분",
                "# 5 .05월 25일 오후 08시 10분"
        });

        movieSchedule.put("귀멸의 칼날", new String[]{
                "# 1 .05월 07일 오전 09시 00분",
                "# 2 .05월 10일 오후 03시 40분",
                "# 3 .05월 13일 오후 06시 30분",
                "# 4 .05월 16일 오후 05시 00분",
                "# 5 .05월 25일 오후 08시 10분"
        });

        movieSchedule.put("진격의 거인", new String[]{
                "# 1 .05월 07일 오전 09시 00분",
                "# 2 .05월 10일 오후 03시 40분",
                "# 3 .05월 13일 오후 06시 30분",
                "# 4 .05월 16일 오후 05시 00분",
                "# 5 .05월 25일 오후 08시 10분"
        });

        movieSchedule.put("하이큐", new String[]{
                "# 1 .05월 07일 오전 09시 00분",
                "# 2 .05월 10일 오후 03시 40분",
                "# 3 .05월 13일 오후 06시 30분",
                "# 4 .05월 16일 오후 05시 00분",
                "# 5 .05월 25일 오후 08시 10분"
        });

        return movieSchedule;
    }
}