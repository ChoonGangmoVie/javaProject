package yohan;

import chanhee.MovieUser;

import java.util.HashMap;
import java.util.Map;

// 영화예매 여러개를 관리 (조회, 수정, 삭제, 생성, 탐색, 정렬 ... )
public class MovieReserveRepository {

    private MovieUser movieUser;

    // 영화 목록을 담을 자료구조 선언
    // key: 영화를 예매한 손님 객체, value: 예매 객체(MovieUser, 영화목록)
    private Map<MovieUser, MovieReserve> MovieReserveMap = new HashMap<>();

    public MovieReserveRepository() {

    }

    // 나이 검증 (성인이 아니지?)
    public boolean isNotAdult() {
        return movieUser.getAge() < 19; // 아니요? 성인인데요, 성인이면 false, 성인이 아니면 true
    }


}
