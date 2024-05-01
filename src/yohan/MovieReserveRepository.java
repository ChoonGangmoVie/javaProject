package yohan;

import chanhee.MovieUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 영화예매 여러개를 관리 (조회, 수정, 삭제, 생성, 탐색, 정렬 ... )
public class MovieReserveRepository {

    /*
        [
            {
                movieUser: {
                    id: 1,
                    name: 'paul'
                },
                movieInfo: {
                    movieName: 'movie',
                    reserveDate: '2023-03-03'
                    seats: [A1,A2]
                }
            },
            {
                movieUser: {
                    id: 2,
                    name: 'paul'
                },
                movieInfo: {
                    movieName: 'movie',
                    reserveDate: '2023-03-03'
                }
            },

        ]
     */
    private static List<MovieReserve> movieReserve;
    private static MovieInfo movieInfo;

    // 생성자
    public MovieReserveRepository() {
        movieReserve = new ArrayList<>();
        movieInfo = new MovieInfo();
    }

    public static List<MovieReserve> getMovieReserve() {
        return movieReserve;
    }

    public static void setMovieReserve(List<MovieReserve> movieReserve) {
        MovieReserveRepository.movieReserve = movieReserve;
    }

    public void addNewSeat(String seatNumber) {

    }


// 영화 목록을 담을 자료구조 선언
    // key: 영화를 예매한 손님 객체, value: 예매 객체(MovieUser, 영화목록)
//    private Map<MovieUser, MovieReserve> MovieReserveMap = new HashMap<>();


    // 나이 검증 (성인이 아니지?)
//    public boolean isNotAdult() {
//        return movieReserve.getMovieUser().getAge() < 19; // 아니요? 성인인데요, 성인이면 false, 성인이 아니면 true
//    }
//
//    // 사용자가 선택한 영화를 movieName에 저장
//    public void addMovie(String menuNum) {
////        movieReserve.getMovieReservationList().getMovieName(menuNum);
//    }
}
