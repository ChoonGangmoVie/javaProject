package song;

import chanhee.UserRepository;
import yohanNew.Movie;
import yohanNew.*;

import java.util.ArrayList;
import java.util.List;

import static util.SimpleInput.input;

public class Ticketing {
    UserRepository ur = new UserRepository();
    ReservationRepository rr = new ReservationRepository();
    public void menu() {
        boolean flag = checkPassword();
        if (!flag) {
            return;
        }
        ticketingInfo();
    }

    private boolean checkPassword() {

        String inputPassword = input("비밀번호를 입력하세요.\n-->");
        if (inputPassword.equals(ur.getCurrentMovieUser().getPassword())) {
            return true;
        } else {
            System.out.println("비밀번호가 틀렸습니다.");
            return false;
        }


    }

    private void ticketingInfo() {


    }
}
