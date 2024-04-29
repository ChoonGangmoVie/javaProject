package chanhee;

import static util.SimpleInput.*;

public class MovieView {

    private UserView ur;
    private StoreView sr;

    public MovieView() {
        this.ur = new UserView();
        this.sr = new StoreView();
    }

    // 회원가입
    public void makeNewUser() {

        System.out.println("\n======================= 영화예매 =======================");
        System.out.println("### 회원 가입 ###");
        String id = input("# 사용할 아이디: ");
        String pw = input("# 사용할 비밀번호: ");
        String name = input("# 회원의 이름: ");
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

        // 입력된 데이터 저장
        ur.saveUser(new MovieUser(id, pw, name, age, gender));
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
    public void showMainScreen() {
        System.out.println("\n# 1. 영화 예매");
        System.out.println("# 2. 영화 예매 확인 및 취소");
        System.out.println("# 3. 매점");
        System.out.println("# 4. 회원 정보");
        System.out.println("# 5. 예매 프로그램 종료");
    }

    // 메인 페이지
    public void movie() {
        makeNewUser();

        while (true) {
            showMainScreen();
            String menuNum = input("- 메뉴 번호 : ");

            switch (menuNum) {
                case "1":
                    ticketingMovie();
                    break;
                case "2":
                    ticketingCheck();
                    break;
                case "3":
                    store();
                    break;
                case "4":
                    userInfo();
                    break;
                case "5":
                    System.out.println("# 프로그램을 종료합니다.");
                    return;
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
    }

    // 메인페이지 3번 메뉴: 매점
    private void store() {
        System.out.println("\n### 매점 페이지입니다. ###");
        sr.showStoreScreen();
        String menuNum = input("- 메뉴 번호 : ");

        switch (menuNum) {
            case "1":
                sr.popcorn();
                break;
            case "2":
                sr.drinks();
                break;
            case "3":
                sr.snack();
                break;
            case "4":
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
                    ur.deleteUser();
                    makeNewUser();
                default:
                    System.out.println("# 옳바른 메뉴 번호를 입력하세요!");
            }
        }
    }

    // 메인페이지 4번 메뉴 :회원정보 - 1. 나의 정보
    private void myPage() {
        System.out.println("\n### 나의 정보 ###");
        ur.user();
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
                    ur.changeId();
                    break;
                case "2":
                    ur.changePassword();
                    break;
                case "3":
                    ur.changeName();
                    break;
                case "4":
                    ur.changeAge();
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
    }


} // end class