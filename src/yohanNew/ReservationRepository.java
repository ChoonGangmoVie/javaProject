package yohanNew;

import chanhee.MovieUser;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 영화 예매의 정보 여러개를 관리 (조회, 수정, 삭제, 생성, 탐색, 정렬)
public class ReservationRepository {

    // 영화 예매정보들을 담을 자료구조
    // key: 예매한 유저의 이름, value: 영화 정보
    private Map<String, Movie> reservationMap = new HashMap<>();

    public Map<String, Movie> getReservationMap() {
        return reservationMap;
    }

    // 예매 정보를 추가하는 메서드
    public void addReservationInfo(MovieUser movieUser, String selectedMovieTitle, String selectedTime, List<String> seats) {
        // 새로운 예매 정보 객체 생성
        Movie movie = new Movie(selectedMovieTitle, 15000, Collections.singletonList(selectedTime), seats);

        // 예매 정보를 맵에 추가
        reservationMap.put(movieUser.getName(), movie);
    }


    public boolean isNotAdult(MovieUser user) {
        return user.getAge() < 19;
    }
}
