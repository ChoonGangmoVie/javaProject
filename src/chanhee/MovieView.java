package chanhee;

import util.SimpleInput;

import static util.SimpleInput.*;

public class MovieView {

    private UserRepository ur;

    public MovieView() {
        this.ur = new UserRepository();
    }

    // 회원가입
    public void makeNewUser() {

        System.out.println("======================= 영화예매 =======================");
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
        System.out.println("\n# 1. 마이페이지");
        System.out.println("# 2. 정보 수정");
        System.out.println("# 3. 구매 내역 확인");
    }

    // 코드의 흐름을 캡슐화
    public void movie() {
        makeNewUser();

        while (true) {
            showMainScreen();
            String menuNum = input("- 메뉴 번호 : ");

            switch (menuNum) {
                case "1":
                    myPage();
                    break;
                case "2":
                    changeInfo();
                    break;
                case "3":
                    checkPurchase();
                    break;
                case "4":
                    System.out.println("# 프로그램을 종료?");
                    return;
                default:
                    System.out.println("# 옳바른 메뉴 번호를 입력하세요!");
            }
        }
    }


    // 1번 메뉴 : 마이페이지
    private void myPage() {
        System.out.println("\n# 나의 정보");
        ur.user();
    }

    // 회원정보수정 메뉴를 출력하는 기능
    public void showChangeInfoScreen() {
        System.out.println("\n# 1. 아이디 수정");
        System.out.println("# 2. 비밀번호 수정");
        System.out.println("# 3. 이름 수정");
        System.out.println("# 4. 나이 수정");
        System.out.println("# 5. 성별 수정");
        System.out.println("# 6. 수정 종료");
    }

    // 2번 메뉴 : 정보 수정
    private void changeInfo() {
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
                    break;
                case "6":
                    System.out.println("# 정보 수정을 종료합니다.");
                    return;
                default:
                    System.out.println("# 옳바른 메뉴 번호를 입력하세요!");
            }
        }
    }

    private void checkPurchase() {
    }

} // end class

