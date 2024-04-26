package songjihoon;

import static songjihoon.ReservationInfo.*;
import static util.SimpleInput.input;

public class Riview {

    //예매확인 및 취소를 위해
    //비밀번호를 받아 검증하는 기능
    public void checkPassword(){
        System.out.printf("\n# 비밀번호를 입력해주세요.");
        String passWord = input("--> ");

    }

    //예매정보를 출력하는 기능
    public void userMovieInfo(){
        System.out.printf("-----%s 님의 예매정보-----",getUserName());
        System.out.printf("1.");

    }

}



