package yohanNew;


import chanhee.Gender;
import chanhee.MovieUser;
import chanhee.UserRepository;
import junwon.Payment;
import junwon.PaymentRepository;
import junwon.PaymentView;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static chanhee.MovieView.showMainScreen;
import static util.SimpleInput.input;

// 프로그램의 입,출력 처리
public class ReservationView {

    private static ReservationRepository repository;
    public static Movie movie;
    public static MovieUser movieUser;
    private static UserRepository userRepository;

    static {
        repository = new ReservationRepository();
        movie = new Movie("", 0, null, new ArrayList<>()); // 영화 정보 초기화
        userRepository = new UserRepository();
//        movieUser = new MovieUser("rnfaos77", "2386", "김요한", 15, Gender.MALE, null);
        movieUser = userRepository.getCurrentMovieUser();
    }

    // 프로그램 실행
    public static void movieReservation() {
        // movie 배열 (영화제목, 금액, 상영시간)
        List<Movie> movies = MovieInfo.getMovie();

        System.out.println(" ");
        System.out.println("\u001B[33m****** 영화 목록 ******");
        System.out.println("\u001B[0m");
        for (int i = 0; i < movies.size(); i++) {
            // movie 배열안에 각각의 movie 객체를 가져온다
            Movie movie = movies.get(i);
            System.out.printf("🔸  %d. %s         \n", i + 1, movie.getMovieName());
        }

        // 1. 영화 선택
        String menuNum = input("\u001B[34m보고 싶은 영화 선택: ");
        System.out.println("\u001B[0m");


        // 선택한 영화 제목 저장
        String selectedMovieTitle = "";
        try {
            selectedMovieTitle = movies.get(Integer.parseInt(menuNum) - 1).getMovieName();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\u001B[31m****** 영화 잘못 고르셨어요 고갱님; \uD83E\uDD23 ******");
            System.out.println("\u001B[0m");
        }

        // 2. 날짜 + 상영시간 선택
        switch (menuNum) {
            case "1":
                // 날짜 + 상영시간 출력
                System.out.println("\n\u001B[33m****** 상영 시간 ******");
                System.out.println("\u001B[0m");

                List<String> times = movies.get(0).getTime();
                printMoviesTime(times);

                // 선택한 상영시간 선택 및 저장
                String selectedTime = "";
                try {
                    selectedTime = selectMovieTime(movies.get(0).getTime());
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("\n\u001B[31m****** 시간을 다시 선택해주세요,, 😵😵😵😵😵 ******");
                    System.out.println("\u001B[0m");
                    printMoviesTime(times);
                    selectedTime = selectMovieTime(movies.get(0).getTime());
                }

                // 3. 좌석 선택
                seatChoice(selectedMovieTitle, selectedTime);
                break;
            case "2":
                System.out.println("\n\u001B[33m****** 상영 시간 ******");
                System.out.println("\u001B[0m");
                times = movies.get(1).getTime();
                printMoviesTime(times);

                // 선택한 상영시간 선택 및 저장

                try {
                    selectedTime = selectMovieTime(movies.get(1).getTime());
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("\n\u001B[31m****** 시간을 다시 선택해주세요,, 😵😵😵😵😵 ******");
                    System.out.println("\u001B[0m");
                    printMoviesTime(times);
                    selectedTime = selectMovieTime(movies.get(1).getTime());
                }

                seatChoice(selectedMovieTitle, selectedTime);
                break;
            case "3":
                System.out.println("\n\u001B[33m****** 상영 시간 ******");
                System.out.println("\u001B[0m");
                times = movies.get(2).getTime();
                printMoviesTime(times);

                // 선택한 상영시간 선택 및 저장
                try {
                    selectedTime = selectMovieTime(movies.get(2).getTime());
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("\n\u001B[31m****** 시간을 다시 선택해주세요,, 😵😵😵😵😵 ******");
                    System.out.println("\u001B[0m");
                    printMoviesTime(times);
                    selectedTime = selectMovieTime(movies.get(2).getTime());
                }

                seatChoice(selectedMovieTitle, selectedTime);
                break;
            case "4":
                System.out.println("\n\u001B[33m****** 상영 시간 ******");
                System.out.println("\u001B[0m");
                times = movies.get(3).getTime();
                printMoviesTime(times);

                // 선택한 상영시간 선택 및 저장
                try {
                    selectedTime = selectMovieTime(movies.get(3).getTime());
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("\n\u001B[31m****** 시간을 다시 선택해주세요,, 😵😵😵😵😵 ******");
                    System.out.println("\u001B[0m");
                    printMoviesTime(times);
                    selectedTime = selectMovieTime(movies.get(3).getTime());
                }

                adultSeatChoice(movieUser, selectedMovieTitle, selectedTime);
                break;
            case "5":
                System.out.println("\n\u001B[33m****** 상영 시간 ******");
                System.out.println("\u001B[0m");
                times = movies.get(4).getTime();
                printMoviesTime(times);

                // 선택한 상영시간 선택 및 저장
                try {
                    selectedTime = selectMovieTime(movies.get(4).getTime());
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("\n\u001B[31m****** 시간을 다시 선택해주세요,, 😵😵😵😵😵 ******");
                    System.out.println("\u001B[0m");
                    printMoviesTime(times);
                    selectedTime = selectMovieTime(movies.get(4).getTime());
                }

                seatChoice(selectedMovieTitle, selectedTime);
                break;
            default:
                movieReservation();
        }
    }


    private static void printMoviesTime(List<String> times) {
        for (int i = 0; i < times.size(); i++) {
            String time = times.get(i);
            System.out.printf("🔸  %d. %s\n", i + 1, time);
        }
    }

    private static String selectMovieTime(List<String> times) {
        // 사용자로부터 선택한 상영 시간의 번호를 입력받음
        String menuNumber = input(">> ");
        int selectedTimeIndex = Integer.parseInt(menuNumber) - 1;

        // 선택한 상영 시간 반환
        return times.get(selectedTimeIndex);
    }

    // 성인영화: 나이 검증을 통과하면 좌석을 보여줌
    private static void adultSeatChoice(MovieUser user, String selectedMovieTitle, String selectedTime) {
        if (repository.isNotAdult(user)) {

            System.out.println("❌❌❌ \u001B[31m19세 미만은 성인 영화를 예매할 수 없습니다 ❌❌❌ ");
            System.out.println("영화 선택화면으로 돌아갑니다.");
            System.out.println("\u001B[0m");
            movieReservation();
        } else {
            seatChoice(selectedMovieTitle, selectedTime);
        }
    }

    // 일반영화: 그냥 좌석을 보여줌
    private static void seatChoice(String selectedMovieTitle, String selectedTime) {
        System.out.println("\n\u001B[33m****** 영화 좌석 ******");
        System.out.println("****** \uD83D\uDC47구매하고 싶은 좌석을 입력하세요.\uD83D\uDC47 ******");
        System.out.println("\u001B[0m");

        // 선택 영화 제목 및 시간 보내기
        PaymentRepository.getMoveNameTime(selectedMovieTitle,selectedTime);

        // 좌석이 저장될 리스트
        List<String> seats = movie.getSeats();

        // 5 x 10 좌석 생성
        String[][] seat = new String[5][10];
        String[] eng = {"A", "B", "C", "D", "E"};
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                seat[i][j] = eng[i] + (j + 1);
            }
        }
        watchSeatList(seat);

        String seatNumber = null;
        boolean isFirstTime = true; // 첫 번째 구매 여부를 확인하기 위한 플래그
        do {
            System.out.println("\u001B[34m");
            seatNumber = input("\n좌석을 입력하세요: ");
            System.out.println("\u001B[0m");

            // 입력이 빈 칸인지 확인
            if(seatNumber.trim().isEmpty()) {
                System.out.println("\u001B[31m좌석은 꼭 입력해 주셔야 해요.😭");
                System.out.println("\u001B[0m");
                watchSeatList(seat);
                continue;
            }

            // 입력한 좌석이 유효한지 확인
            boolean isValidSeat = false;
            for (int i = 0; i < seat.length; i++) {
                for (int j = 0; j < seat[i].length; j++) {
                    if (seat[i][j].equals(seatNumber)) {
                        isValidSeat = true;
                        break;
                    }
                }
            }

            if(!isValidSeat) {
                System.out.println("\u001B[31m존재하지 않는 좌석입니다! 다시 입력해주세요 😵‍💫 ");
                System.out.println("\u001B[0m");
                watchSeatList(seat);
                continue;
            }




            // 구매 완료한 좌석 X로 변경
            for (int i = 0; i < seat.length; i++) {
                for (int j = 0; j < seat[i].length; j++) {
                    if (seat[i][j].equals(seatNumber)) {
                        seat[i][j] = " X";
                    }
                }
            }
            watchSeatList(seat);


            // 구매한 좌석을 seats에 저장
            seats.add(seatNumber);

            // 첫번째 구매할 때만 실행하고 종료, 추가 구매에 대한 저장은 while문 안에서 실행
            if (isFirstTime) {
                repository.addReservationInfo(movieUser, selectedMovieTitle, selectedTime, seats);
                isFirstTime = false; // 첫 번째 구매 완료 후 플래그 변경
//                System.out.println("예약 정보가 추가되었습니다: " + repository.getReservationInfoList());
            }

            // 추가 구매 여부 확인
            String continueChoice = input("\u001B[34m좌석을 더 구매하시겠습니까? [Y/N]: ");
            System.out.println("\u001B[0m");
            if (!continueChoice.equalsIgnoreCase("y")) {
                // 추가 구매를 하지 않는 경우에만 예약 정보 확인
                if (!continueChoice.equalsIgnoreCase("n")) {
                    // repository에 유저, 제목, 상영시간, 좌석 전달
                    repository.addReservationInfo(movieUser, selectedMovieTitle, selectedTime, seats);
                }
                break;
            }
        } while (true);

        viewReservationInfo(); // 추가 구매를 하지 않는 경우에만 호출


        PaymentView.start();
    }


    private static void watchSeatList(String[][] seat) {
        for (String[] strings : seat) {
            for (int j = 0; j < strings.length; j++) {
                System.out.print(strings[j] + " ");
            }
            System.out.println();
        }
    }

    // 예약 정보를 확인코드
    public static void viewReservationInfo() {

        repository.getReservationInfoList()
                .forEach(r -> {

                    String movieTime = r.getMovie().getTime().toString().replaceAll("[\\[\\]]", "");
                    String movieSeats = r.getMovie().getSeats().toString().replaceAll("[\\[\\]]", "");
                    System.out.printf("%s님이 예매하신 영화는 %s이고, 영화 상영 시간은 %s, 좌석은 %s입니다."
                    , r.getMovieUser().getName(), r.getMovie().getMovieName(), movieTime, movieSeats);

                    System.out.printf("# 영화제목: %s\n",ReservationRepository.getSendMovieInfo().getMovieName());
                    System.out.printf("# 상영시간: %s\n",ReservationRepository.getSendMovieInfo().getTime());
                    System.out.printf("# 영화금액: %s원\n",ReservationRepository.getSendMovieInfo().getFee());

                    System.out.println("기존 저장 저보를 취소합니다.");



                });
        showMainScreen();

    }

}
