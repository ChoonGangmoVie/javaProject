package songjihoon;

import chanhee.MovieUser;

import static util.SimpleInput.input;


public class ticketingCheck {
    public boolean checkPassword(MovieUser user) {
        while (true) {
            System.out.printf("\n# 비밀번호를 입력해주세요.");
            String passWord = input("--> ");
            if (user.getPassword().equals(passWord)) {
                return true;
            } else {
                System.out.println("비밀번호가 틀렷습니다.");
                return false;
            }
        }


    }
}
