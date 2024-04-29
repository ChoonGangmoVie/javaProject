package songjihoon;

import chanhee.MovieUser;

import static util.SimpleInput.input;


public class ticketingCheckView {


    //예매확인 및 취소를 위해
    //비밀번호를 받아 검증하는 기능
     public boolean checkPassword(MovieUser user){
        System.out.printf("\n# 비밀번호를 입력해주세요.");
        String passWord = input("--> ");
        if (user.getPassword().equals(passWord)){
            return true;
        }else {
            return false;
        }

    }

    //예매정보를 출력하는 기능
    public void userMovieInfo(){
        System.out.printf("-----%ㅇㅇㅇ 님의 예매정보-----");
        System.out.printf("1.범죄도시4 4월 25일 08:00 성인 2명");

    }
    public void cancelMovie(){
        System.out.printf("1.범죄도시4 4월 25일 08:00 성인 2명\n취소하시겠습니다까? [Y,N]");
        String cancelCheck = input("[Y,N]-->> ");
    }

}



