package chanhee;

import util.SimpleInput;

import static util.SimpleInput.*;

public class MovieView {

    private MovieRepository mr;

    // 회원가입
    public void makeNewUser() {

        System.out.println("영화예매 하세요ㅋ");
        input("# 회원가입 하시겠습니까? [Y/N] : ");
        input("# 아이디: ");
        input("# 비밀번호: ");
    }
}
