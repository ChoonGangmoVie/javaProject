package junwon.cancelReservation;

import chanhee.MovieUser;
import chanhee.MovieView;
import util.SimpleInput;
import yohanNew.Movie;
import yohanNew.ReservationInfo;
import yohanNew.ReservationRepository;

import java.util.List;

public class ReservationManager {



    // 예매 정보를 확인하는 메서드
    public static void checkReservation() {
        Movie sendMovieInfo = ReservationRepository.getSendMovieInfo();
        MovieUser sendMovieUserInfo = ReservationRepository.getSendMovieUserInfo();


        if (sendMovieInfo != null && sendMovieUserInfo != null) {
            System.out.println("### 현재 예약 정보 ###");
            List<ReservationInfo> reservationList = ReservationRepository.getReservationInfoList();
            for (ReservationInfo reservationInfo : reservationList) {
                System.out.printf("# 예약자명: %s\n", reservationInfo.getMovieUser().getName());
                System.out.printf("# 영화제목: %s\n", reservationInfo.getMovie().getMovieName());
                System.out.printf("# 영화금액: %s원\n", (reservationInfo.getMovie().getSeats().size()) * 15000);
                System.out.printf("# 영화시간: %s\n", reservationInfo.getMovie().getTime());
                System.out.printf("# 좌석: %s\n", reservationInfo.getMovie().getSeats());
                System.out.println("===========================");
            }

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

        List<ReservationInfo> reservationList = ReservationRepository.getReservationInfoList();
        if (!reservationList.isEmpty()) {
            System.out.println("### 예약 정보 취소 ###");
            System.out.println("취소할 예약 정보를 선택해주세요:");
            for (int i = 0; i < reservationList.size(); i++) {
                ReservationInfo reservation = reservationList.get(i);
                System.out.printf("%d. %s - %s\n", i + 1, reservation.getMovie().getMovieName(), reservation.getMovie().getTime());
            }

            System.out.print("취소할 예약 번호를 입력하세요: ");
            int cancelNum = Integer.parseInt(SimpleInput.input(">>"));

            if (cancelNum >= 1 && cancelNum <= reservationList.size()) {
                ReservationInfo canceledReservation = reservationList.remove(cancelNum - 1);
                System.out.println("예약이 취소되었습니다:");
                System.out.printf("영화: %s, 시간: %s\n", canceledReservation.getMovie().getMovieName(), canceledReservation.getMovie().getTime());
            } else {
                System.out.println("올바르지 않은 선택입니다.");
            }


        } else {
            System.out.println("예매된 정보가 없어 취소할 수 없습니다.");
        }
    }
}