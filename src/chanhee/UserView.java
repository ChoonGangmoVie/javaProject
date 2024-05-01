package chanhee;

import static util.SimpleInput.input;

public class UserView {

    private UserRepository userRepository = new UserRepository();
    MovieUser user = userRepository.getCurrentMovieUser();

    // 회원 정보 출력
    public void user() {
        userRepository.getUser();
    }

    // 회원 아이디 수정
    public void changeId() {
        userRepository.changeID();
    }

    // 회원 비밀번호 수정
    public void changePassword() {
        userRepository.changePW();
    }

    // 회원 이름 수정
    public void changeName() {
       userRepository.changeNAME();
    }

    // 회원 나이 수정
    public void changeAge() {
       userRepository.changeAGE();
    }

    // 메인페이지 4번 메뉴: 회원정보 - 4. 회원 탈퇴
    public void deleteUser() {
       userRepository.deleteUSER();
    }

} // end class
