package junwon.cancelReservation;

import chanhee.MovieUser;
import chanhee.MovieView;
import util.SimpleInput;
import yohanNew.Movie;
import yohanNew.ReservationRepository;

import java.util.ArrayList;
import java.util.List;

public class ReservationManager {


    // 예매 정보를 확인하는 메서드
    public static void checkReservation() {
        Movie sendMovieInfo = ReservationRepository.getSendMovieInfo();
        MovieUser sendMovieUserInfo = ReservationRepository.getSendMovieUserInfo();

        if (sendMovieInfo != null && sendMovieUserInfo != null) {
            System.out.println("\n### 예매 정보 확인 ###");
            System.out.printf("# 예약자명: %s\n", sendMovieUserInfo.getName());
            System.out.printf("# 영화제목: %s\n", sendMovieInfo.getMovieName());
            System.out.printf("# 영화가격: %d\n", sendMovieInfo.getFee());
            System.out.printf("# 영화시간: %s\n", sendMovieInfo.getTime());
            System.out.printf("# 좌석: %s\n", sendMovieInfo.getSeats());

            System.out.println("============================");
            System.out.println("1. 예약취소");
            System.out.println("0. 돌아가기");
            System.out.println("메뉴 번호를 입력하세요");
            String menuNum = SimpleInput.input(">> ");

            switch (menuNum){
                case "1":
                    cancelReservation();
                    break;
                case"2":
                    MovieView mv = new MovieView();
                    mv.showMainScreen();
                    break;
                default:
                    System.out.println("");
            }



        } else {
            System.out.println("예매된 정보가 없습니다.");
        }
    }

    // 예매 정보를 취소하는 메서드
    public static void cancelReservation() {
        Movie sendMovieInfo = ReservationRepository.getSendMovieInfo();
        MovieUser sendMovieUserInfo = ReservationRepository.getSendMovieUserInfo();

        if (sendMovieInfo != null && sendMovieUserInfo != null) {


            System.out.println("\n### 예매가 취소되었습니다 ###");
            System.out.printf("# 예약자명: %s\n", sendMovieUserInfo.getName());
            System.out.printf("# 영화제목: %s\n", sendMovieInfo.getMovieName());
            System.out.printf("# 영화시간: %s\n", sendMovieInfo.getTime());
            System.out.printf("# 좌석: %s\n", sendMovieInfo.getSeats());

            // 취소 후에는 해당 정보 초기화
            ReservationRepository.setSendMovieInfo(null);
            ReservationRepository.setSendMovieUserInfo(null);


        } else {
            System.out.println("예매된 정보가 없어 취소할 수 없습니다.");
        }
    }
}