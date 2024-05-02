package song;

import chanhee.UserRepository;
import yohanNew.ReservationRepository;
import yohanNew.ReservationView;
import yohanNew.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static util.SimpleInput.input;
import static util.SimpleInput.stopInput;


public class Ticketing {
    UserRepository ur = new UserRepository();
    ReservationRepository rr = new ReservationRepository();
    ReservationView rv = new ReservationView();
    private static ReservationRepository repository;

    static {
        repository = new ReservationRepository();

    }


    public void menu() {
        boolean flag = checkPassword();
        if (!flag) {
            return;
        }
        viewReservationInfo();
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

    private void viewReservationInfo() {
        List<String> fgnasfa = new ArrayList<>();


        List<ReservationInfo> currentUsersReservationList = repository.getReservationInfoList()
                .stream()
                .filter(reservationInfo -> reservationInfo.getMovieUser().equals(ur.getCurrentMovieUser()))
                .collect(Collectors.toList());
        if(currentUsersReservationList.size() == 0) {
            repository.addReservationInfo(ReservationView.movieUser, "확인용1", "시간1", fgnasfa);
            repository.addReservationInfo(ReservationView.movieUser, "확인용2", "시간2", fgnasfa);
            repository.addReservationInfo(ReservationView.movieUser, "확인용3", "시간3", fgnasfa);

            System.out.println("예매하신 영화가 없습니다.");
            stopInput();
            return;
        }
        while (true) {
            int countNum = 1;
            for (ReservationInfo reservationInfo : currentUsersReservationList) {
                System.out.printf("%d %s %s\n", countNum++, reservationInfo.getMovie().getMovieName(),reservationInfo.getMovie().getTime());
            }
            System.out.println("0. 뒤로가기");
            System.out.println("예약취소할 영화의 번호를 입력해 주세요");
            int inputNumber = 0;
            try {
                inputNumber = Integer.parseInt(input(">>"));
                if(inputNumber == 0) return;
                System.out.printf("'%s'영화 예약이 취소되었습니다.\n", currentUsersReservationList.get(inputNumber - 1).getMovie().getMovieName());
                repository.getReservationInfoList().remove(currentUsersReservationList.get(inputNumber - 1));
                return;
            } catch (NumberFormatException e) {
                System.out.println("숫자로 입력해 주세요.");
                stopInput();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("정확한 번호를 입력해 주세요.");
                stopInput();
            }
        }
    };

}
