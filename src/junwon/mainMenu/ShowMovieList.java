package junwon.mainMenu;

import chanhee.MovieView;
import util.SimpleInput;
import yohanNew.ReservationRepository;
import yohanNew.ReservationView;

public class ShowMovieList {
    public static void MoveList(){
            System.out.println("\n\n🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈 현재 상영중인 영화 목록 🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈");
            System.out.println("# 범죄도시4");
            System.out.println("# 파묘");
            System.out.println("# 귀멸의 칼날");
            System.out.println("# 진격의 거인");
            System.out.println("# 하이큐");
            System.out.println("️‍🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈️‍️🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈🏳️‍🌈");
            System.out.println("# 1. 영화예매하기");
            System.out.println("# 0. 뒤로가기");

        String menuNum = SimpleInput.input(">> ");
        switch (menuNum){
            case "1":
                if(ReservationRepository.getSendMovieUserInfo()==null){
                    System.out.println("");
                    System.out.println("회원가입이 되어있지 않습니다.");
                    System.out.println("회원가입 메뉴로 이동합니다.");
                    MovieView mv = new MovieView();
                    mv.movie();
                }else{
                    ReservationView.movieReservation();
                }
                break;
            case  "0":
                MainView.showMainView();
                break;
            default:
                System.out.println("잘못된 메뉴 번호 입니다.");
        }
    }
}

