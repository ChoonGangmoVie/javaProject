package chanhee;

import util.SimpleInput;

public class UserRepository {

    private static MovieUser createUser;

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
        String newId = SimpleInput.input("# 새 아이디: ");
        // 회원정보 실제로 수정
        createUser.setId(newId);

        System.out.println("# 아이디 변경이 완료되었습니다.");
    }

    // 회원 비밀번호 수정
    public void changePassword() {
        System.out.printf("# %s님의 비밀번호를 변경합니다.\n", createUser.getName());

        // 비밀번호 수정
        String newPassword = SimpleInput.input("# 새 비밀번호: ");
        // 회원정보 실제로 수정
        createUser.setPassword(newPassword);

        System.out.println("# 비밀번호 변경이 완료되었습니다.");
    }

    // 회원 이름 수정
    public void changeName() {
        System.out.printf("# %s님의 이름을 변경합니다.\n", createUser.getName());

        // 이름 수정
        String newName = SimpleInput.input("# 새 이름: ");
        // 회원정보 실제로 수정
        createUser.setName(newName);

        System.out.println("# 회원의 이름 변경이 완료되었습니다.");
    }

    // 회원 나이 수정
    public void changeAge() {
        System.out.printf("# %s님의 나이를 변경합니다.\n", createUser.getName());

        // 나이 수정
        String newAge = SimpleInput.input("# 새 나이: ");
        // 회원정보 실제로 수정
        createUser.setAge(Integer.parseInt(newAge));

        System.out.println("# 회원의 나이 변경이 완료되었습니다.");
    }

} // end class
