
package chanhee;

import junwon.Payment;
import junwon.PaymentRepository;
import junwon.PaymentView;
import junwon.cancelReservation.ReservationManager;
import song.Ticketing;
import yohanNew.Movie;
import yohanNew.ReservationInfo;
import yohanNew.ReservationRepository;
import yohanNew.ReservationView;

import java.util.List;

import static junwon.PaymentRepository.getCardNum;
import static junwon.mainMenu.MainView.showMainView;
import static util.SimpleInput.*;

import static yohanNew.ReservationView.movieReservation;

public class MovieView {

    private UserView uv;
    private StoreView sv;
    private UserRepository ur;
    private Ticketing tt;
    private static ReservationRepository reservationRepository;
    private ReservationInfo reservationInfo;

    public MovieView() {
        this.uv = new UserView();
        this.sv = new StoreView();
        this.ur = new UserRepository();
        this.reservationInfo = new ReservationInfo();
    }

    // 회원가입
    public void makeNewUser() {

        System.out.println(" ");
        System.out.println("============================");
        System.out.println("### 회원 가입 ###");
        String id = input("# 사용할 아이디: ");
        String pw = input("# 사용할 비밀번호: ");

        String name;
        while (true) {
            name = input("# 회원의 이름: ");
            // 입력된 값이 숫자를 포함하지 않는지 확인
            if (!name.matches(".*\\d.*")) {
                break;
            } else {
                System.out.println("이름을 정확히 입력해주세요.");
            }
        }


        int age = 0;
        while (true) {
            try {
                age = Integer.parseInt(input("# 나이: "));
                break;
            } catch (NumberFormatException e) {
                System.out.println("나이를 숫자로 입력해주세요.");
            }
        }
        Gender gender = inputGender();
        // 카드 등록여부 확인
        String creditCard = "";
        System.out.println("# 결제할 카드를 먼저 등록하시겠습니까?");
  while (true) {

            String inputCard = input(">>(Y/N) ");
            if (inputCard.equalsIgnoreCase("Y") || inputCard.equalsIgnoreCase("y")) {
                PaymentView.registeredCard();
                creditCard = PaymentRepository.getCardNum();
                System.out.println("\n# 카드가 등록되었습니다.");
                break;
            } else if (inputCard.equalsIgnoreCase("N") || inputCard.equalsIgnoreCase("n")) {
                creditCard = null;
                break;
            } else {
                System.out.println("Y 또는 N을 입력해주세요");
            }
        }

        // 입력된 데이터 저장
        MovieUser newUser = new MovieUser(id, pw, name, age, gender, creditCard);
        ur.saveUser(newUser);
    }


    // 성별을 정확히 입력할때가지 무한히 입력받고
    // 정확히 입력하면 해당 성별 문자를 리턴
    private Gender inputGender() {
        while (true) {
            String gender = input("# 성별(M/F): ").toUpperCase();
            if (gender.startsWith("M")) return Gender.MALE;
            if (gender.startsWith("F")) return Gender.FEMALE;
            System.out.println("\n# 성별을 잘못 입력했습니다.");
        }
    }

    // 회원정보 메뉴를 출력하는 기능
    public static void showMainScreen() {
        System.out.println("============================");
        System.out.println("1. 영화 예매                 ");
        System.out.println("2. 영화 예매 확인 및 취소      ");
        System.out.println("3. 매점                      ");
        System.out.println("4. 회원 정보                  ");
        System.out.println("5. 예매 프로그램 종료          ");
        System.out.println("============================");
    }

    // 메인 페이지
    public void movie() {
        makeNewUser();

        while (true) {
            showMainScreen();
            String menuNum = input("- 메뉴 번호 : ");

            switch (menuNum) {
                case "1":
                    movieReservation();
                    break;
                case "2":
                    ticketingCheck();
                    break;
                case "3":
                    storeMenu();
                    break;
                case "4":
                    userInfo();
                    break;
                case "5":
                    System.out.println("# 프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("# 옳바른 메뉴 번호를 입력하세요!");
            }
        }
    }


    // 메인페이지 1번 메뉴: 영화 예매
    private void ticketingMovie() {
    }

    // 메인페이지 2번 메뉴: 영화 예매 확인 및 취소
    private void ticketingCheck() {
        ReservationManager.checkReservation();
    }

    // 메인페이지 3번 메뉴: 매점
    public void storeMenu() {
        System.out.println("============================");
        System.out.println("\n### 매점 페이지입니다. ###");
        sv.showStoreScreen();
        String menuNum = input("- 메뉴 번호 : ");

        switch (menuNum) {
            case "1":
                sv.store();
                break;
            case "2":
                System.out.println("# 매점 이용을 종료합니다.");
                return;
            default:
                System.out.println("# 옳바른 메뉴 번호를 입력하세요!");
        }

    }


    // 메인페이지 4번 메뉴: 회원정보 출력화면
    public void userInfoScreen() {
        System.out.println("\n# 1. 나의 정보");
        System.out.println("# 2. 정보 수정");
        System.out.println("# 3. 나의 구매 내역");
        System.out.println("# 4. 회원 탈퇴");
        System.out.println("# 5. 돌아가기");
    }

    // 메인페이지 4번 메뉴 : 회원 정보
    private void userInfo() {
        System.out.println("### 회원 정보 페이지입니다. ###");

        while (true) {
            userInfoScreen();
            String menuNum = input("- 메뉴 번호 : ");

            switch (menuNum) {
                case "1":
                    myPage();
                    break;
                case "2":
                    userInfoChange();
                    break;
                case "3":
                    purchaseInfo();
                    break;
                case "4":
                    uv.deleteUser();
                    showMainView();
                case "5":
                    return;
                default:
                    System.out.println("# 옳바른 메뉴 번호를 입력하세요!");
            }
        }
    }

    // 메인페이지 4번 메뉴 :회원정보 - 1. 나의 정보
    private void myPage() {
        System.out.println("\n### 나의 정보 ###");
        uv.user();
    }

    // 메인페이지 4번 메뉴: 회원정보 - 2. 정보 수정 출력 화면
    public void showChangeInfoScreen() {
        System.out.println("# 1. 아이디 수정");
        System.out.println("# 2. 비밀번호 수정");
        System.out.println("# 3. 이름 수정");
        System.out.println("# 4. 나이 수정");
        System.out.println("# 5. 수정 종료");
    }
    // 메인페이지 4번 메뉴 : 회원 정보 - 2. 정보수정
    private void userInfoChange() {
        System.out.println("### 정보 수정 ###");

        while (true) {
            showChangeInfoScreen();
            String menuNum = input("- 메뉴 번호 : ");

            switch (menuNum) {
                case "1":
                    uv.changeId();
                    break;
                case "2":
                    uv.changePassword();
                    break;
                case "3":
                    uv.changeName();
                    break;
                case "4":
                    uv.changeAge();
                    break;
                case "5":
                    System.out.println("# 정보 수정을 종료합니다.");
                    return;
                default:
                    System.out.println("# 옳바른 메뉴 번호를 입력하세요!");
            }
        }
    }

    // 메인페이지 4번 메뉴: 회원정보 - 3. 구매 내역
    private void purchaseInfo() {
        uv.showMyBoughtInfo();
        String menuNum = input("- 메뉴 번호 : ");
        switch (menuNum) {

            case "1":
                myMovieInfo();
                break;
            case "2":
                myStoreInfo();
                break;
            case "3":
                return;
            default:
                System.out.println("# 옳바른 메뉴 번호를 입력하세요!");
        }
    }

    // 나의 영화 예매 내역에서 어떤 영화를 예매했는지 출력
    private void myMovieInfo() {

        Movie sendMovieInfo = ReservationRepository.getSendMovieInfo();
        MovieUser sendMovieUserInfo = ReservationRepository.getSendMovieUserInfo();

        if (sendMovieInfo != null && sendMovieUserInfo != null) {
            System.out.printf("### %s님의 영화 예매 내역 ###\n", sendMovieUserInfo.getName());
            List<ReservationInfo> reservationList = ReservationRepository.getReservationInfoList();
            for (ReservationInfo reservationInfo : reservationList) {
                System.out.printf("# 예약자명: %s\n", reservationInfo.getMovieUser().getName());
                System.out.printf("# 영화제목: %s\n", reservationInfo.getMovie().getMovieName());
                System.out.printf("# 영화금액: %s원\n", (reservationInfo.getMovie().getSeats().size()) * 15000);
                System.out.printf("# 영화시간: %s\n", reservationInfo.getMovie().getTime());
                System.out.printf("# 좌석: %s\n", reservationInfo.getMovie().getSeats());
                System.out.println("===========================");
            }
        } else {
            System.out.println("예매된 정보가 없습니다.");
        }
    }
    // 나의 매점 구매내역에서 무엇을 샀는지 출력
    private void myStoreInfo() {
        ur.myStoreList();
        StoreRepository.getUserStore().forEach(store -> {
            System.out.print("구매한 상품명: " + store.getName() + " /");
            System.out.println(" 상품의 가격: " + store.getPrice());
        });
        System.out.println("============================");
    }


} // end class