package yohanNew;

import chanhee.MovieUser;
import chanhee.UserRepository;
import junwon.PaymentRepository;

import java.util.*;

// 영화 예매의 정보 여러개를 관리 (조회, 수정, 삭제, 생성, 탐색, 정렬)
public class ReservationRepository {

    private static UserRepository userRepository;

    // 영화 예매정보들을 담을 리스트
    private List<ReservationInfo> reservationInfoList;

    // Movie, MovieUser 보낼때 사용하는 변수
    private static Movie sendMovieInfo;
    private static MovieUser sendMovieUserInfo;

    public static Movie getSendMovieInfo() {
        return sendMovieInfo;
    }

    public static MovieUser getSendMovieUserInfo() {
        return sendMovieUserInfo;
    }

    public ReservationRepository() {
        this.reservationInfoList = new ArrayList<>();
    }

    public List<ReservationInfo> getReservationInfoList() {
        return reservationInfoList;
    }

    // 예매 정보를 추가
    public void addReservationInfo(MovieUser movieUser, String selectedMovieTitle, String selectedTime, List<String> seats) {
        // 새로운 예매 정보 객체 생성
        Movie movie = new Movie(selectedMovieTitle, 15000, Collections.singletonList(selectedTime), seats);
        ReservationInfo reservationInfo = new ReservationInfo(movieUser, movie);
        reservationInfoList.add(reservationInfo);

        Movie movie1 = reservationInfo.getMovie();
        sendMovieInfo = movie1;
        MovieUser movieUser1 = reservationInfo.getMovieUser();
        sendMovieUserInfo = movieUser1;

        System.out.println("예약 정보가 추가되었습니다: " + movie1 + movieUser1);

    }

    public boolean isNotAdult(MovieUser user) {
        return user.getAge() < 19;
    }


}
