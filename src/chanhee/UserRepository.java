package chanhee;

import static util.SimpleInput.input;

public class UserRepository {

    private MovieUser createUser;
    private MovieView mv;

    public UserRepository() {
        this.mv = new MovieView();
    }

    // 저장소에 가입한 회원 저장
    public void saveUser(MovieUser user) {
        createUser = user;
    }

    // 회원 정보 출력
    public void user() {
        System.out.println("# 회원 아이디: " + createUser.getId());
        System.out.println("# 회원 비밀번호: " + createUser.getPassword());
        System.out.println("# 회원의 이름: " + createUser.getName());
        System.out.println("# 회원의 나이: " + createUser.getAge());
        System.out.println("# 회원의 성별: " + createUser.getGender());
    }

    // 회원 아이디 수정
    public void changeId() {
        System.out.printf("# %s님의 아이디를 변경합니다.\n", createUser.getName());

        // 아이디 수정
        String newId = input("# 새 아이디: ");
        // 회원정보 실제로 수정
        createUser.setId(newId);

        System.out.println("# 아이디 변경이 완료되었습니다.");
    }

    // 회원 비밀번호 수정
    public void changePassword() {
        System.out.printf("# %s님의 비밀번호를 변경합니다.\n", createUser.getName());

        // 비밀번호 수정
        String newPassword = input("# 새 비밀번호: ");
        // 회원정보 실제로 수정
        createUser.setPassword(newPassword);

        System.out.println("# 비밀번호 변경이 완료되었습니다.");
    }

    // 회원 이름 수정
    public void changeName() {
        System.out.printf("# %s님의 이름을 변경합니다.\n", createUser.getName());

        // 이름 수정
        String newName = input("# 새 이름: ");
        // 회원정보 실제로 수정
        createUser.setName(newName);

        System.out.println("# 회원의 이름 변경이 완료되었습니다.");
    }

    // 회원 나이 수정
    public void changeAge() {
        System.out.printf("# %s님의 나이를 변경합니다.\n", createUser.getName());

        // 나이 수정
        String newAge = input("# 새 나이: ");
        // 회원정보 실제로 수정
        createUser.setAge(Integer.parseInt(newAge));

        System.out.println("# 회원의 나이 변경이 완료되었습니다.");
    }

    // 메인페이지 4번 메뉴: 회원정보 - 4. 회원 탈퇴
    public void deleteUser() {
        // 비밀번호 검증 받고 입력비번 일치하면 회원정보 삭제하기
        System.out.println("\n### 회원 탈퇴 페이지입니다. ###");
        System.out.println("탈퇴를 위해 기존의 비밀번호를 입력해주세요.");
        // 비밀번호 검증
        String pw = createUser.getPassword();

        while (true) {
            if (pw != null) {
                // 삭제 진행
                String inputPw = input("# 기존 비밀번호 입력: ");
                if (inputPw.equals(createUser.getPassword())) {
                    System.out.printf("# %s님의 회원정보가 삭제되었습니다. 회원가입 화면으로 돌아갑니다.", createUser.getName());
                    createUser = null;
                    break;
                } else {
                    System.out.println("\n# 비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
                }
            }
        }
        mv.makeNewUser();
    }

} // end class
