package chanhee;

public class UserView {

    private UserRepository userRepository = new UserRepository();
    MovieUser user = userRepository.getCurrentMovieUser();

    // 회원 정보 출력
    public void user() {
        userRepository.getUser();
    }

    // 회원 아이디 수정
    public void changeId() {
        userRepository.changeUserId();
    }

    // 회원 비밀번호 수정
    public void changePassword() {
        userRepository.changeUserPw();
    }

    // 회원 이름 수정
    public void changeName() {
       userRepository.changeUserName();
    }

    // 회원 나이 수정
    public void changeAge() {
       userRepository.changeUserAge();
    }

    // 메인페이지 4번 메뉴: 회원정보 - 4. 회원 탈퇴
    public void deleteUser() {
       userRepository.deleteUserInfo();
    }

    // 메인페이지 4번 메뉴: 회원정보 - 3. 나의 구매 내역
    public void showMyBoughtInfo() {
        System.out.println("\n# 1. 나의 영화 예매 내역");
        System.out.println("# 2. 나의 매점 구매 내역");
        System.out.println("# 3. 돌아가기");
    }


} // end class
