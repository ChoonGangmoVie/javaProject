package chanhee;

import java.util.*;
import java.util.stream.Collectors;

import static util.SimpleInput.input;

public class UserRepository {


    private static List<MovieUser> users = new ArrayList<>();

    // 현재 로그인한 사람 저장
    private static MovieUser currentMovieUser;





    public MovieUser getUser(String id) {
        return findById(id);
    }

    private MovieUser findById(String id) {

        return users.stream()
                .filter(u -> u.getId().equals(id))
                .collect(Collectors.toList())
                .get(0);
    }




    public void saveUser(MovieUser newUser) {
        users.add(newUser);
        currentMovieUser = newUser;
    }

    public MovieUser getCurrentMovieUser() {
        return currentMovieUser;
    }

    public void getUser() {
        System.out.println("# 회원 아이디: " + currentMovieUser.getId());
        System.out.println("# 회원 비밀번호: " + currentMovieUser.getPassword());
        System.out.println("# 회원의 이름: " + currentMovieUser.getName());
        System.out.println("# 회원의 나이: " + currentMovieUser.getAge());
        System.out.println("# 회원의 성별: " + currentMovieUser.getGender());
    }

    public void changeUserId() {
        System.out.printf("# %s님의 아이디를 변경합니다.\n", currentMovieUser.getName());

        // 아이디 수정
        String newId = input("# 새 아이디: ");
        // 회원정보 실제로 수정
        currentMovieUser.setId(newId);

        System.out.println("# 아이디 변경이 완료되었습니다.");
    }

    public void changeUserPw() {
        System.out.printf("# %s님의 비밀번호를 변경합니다.\n", currentMovieUser.getName());

        // 비밀번호 수정
        String newPassword = input("# 새 비밀번호: ");
        // 회원정보 실제로 수정
        currentMovieUser.setPassword(newPassword);

        System.out.println("# 비밀번호 변경이 완료되었습니다.");
    }

    public void changeUserName() {
        System.out.printf("# %s님의 이름을 변경합니다.\n", currentMovieUser.getName());

        // 이름 수정
        String newName = input("# 새 이름: ");
        // 회원정보 실제로 수정
        currentMovieUser.setName(newName);

        System.out.println("# 이름 변경이 완료되었습니다.");
    }

    public void changeUserAge() {
        System.out.printf("# %s님의 나이를 변경합니다.\n", currentMovieUser.getName());

        // 나이 수정
        String newAge = input("# 새 나이: ");
        // 회원정보 실제로 수정
        currentMovieUser.setAge(Integer.parseInt(newAge));

        System.out.println("# 나이 변경이 완료되었습니다.");
    }

    public void deleteUserInfo() {
        // 비밀번호 검증 받고 입력비번 일치하면 회원정보 삭제하기
        System.out.println("\n### 회원 탈퇴 페이지입니다. ###");
        System.out.println("탈퇴를 위해 기존의 비밀번호를 입력해주세요.");
        // 비밀번호 검증
        String pw = "";

        while (true) {
            if (pw != null) {
                // 삭제 진행
                String inputPw = input("# 기존 비밀번호 입력: ");
                if (inputPw.equals(currentMovieUser.getPassword())) {
                    System.out.printf("# %s님의 회원정보가 삭제되었습니다. 회원가입 화면으로 돌아갑니다.", currentMovieUser.getName());
                    currentMovieUser = null;
                    break;
                } else {
                    System.out.println("\n# 비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
                }
            }
        }
    }

    public void myStoreList() {
        System.out.printf("\n=========================================\n### %s님의 매점 구매 내역 ###\n"
                , currentMovieUser.getName());
    }

}
