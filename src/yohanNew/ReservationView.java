package yohanNew;

import chanhee.Gender;
import chanhee.MovieUser;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static util.SimpleInput.input;

// 프로그램의 입,출력 처리
public class ReservationView {

    private static ReservationRepository repository;
    private static Movie movie;
    private static MovieUser movieUser;


    static {
        repository = new ReservationRepository();
        movie = new Movie("", 0, null, new ArrayList<>()); // 영화 정보 초기화
        movieUser = new MovieUser("rnfaos77", "2386", "김요한", 15, Gender.MALE);
//        movieUser = new MovieUser(movieUser.getId(), movieUser.getPassword(),movieUser.getName(), movieUser.getAge(), movieUser.getGender());
    }

    public static void movieReservation() {
        // movie 배열 (영화제목, 금액, 상영시간)
        List<Movie> movies = MovieInfo.getMovie();


        System.out.println("\n****** 영화 목록 ******");
        for (int i = 0; i < movies.size(); i++) {
            // movie 배열안에 각각의 movie 객체를 가져온다
            Movie movie = movies.get(i);
            System.out.printf("# %d. %s\n", i + 1, movie.getMovieName());
        }

        // 1. 영화 선택
        String menuNum = input("보고 싶은 영화 선택: ");

        // 선택한 영화 제목 저장
        String selectedMovieTitle = movies.get(Integer.parseInt(menuNum) - 1).getMovieName();
        // Repository에 영화 예매 정보 추가
//        repository.addMovieTitle(movieUser.getName(), selectedMovieTitle);

        // 2. 날짜 + 상영시간 선택
        switch (menuNum) {
            case "1":
                // 날짜 + 상영시간 출력
                System.out.println("\n****** 상영 시간 ******");
                List<String> times = movies.get(0).getTime();
                printMoviesTime(times);

                // 선택한 상영시간 선택 및 저장
                String selectedTime = selectMovieTime(movies.get(0).getTime());

                // 3. 좌석 선택
                seatChoice(selectedMovieTitle, selectedTime);
                break;
            case "2":
                System.out.println("\n****** 상영 시간 ******");
                times = movies.get(1).getTime();
                printMoviesTime(times);
                selectedTime = selectMovieTime(movies.get(1).getTime());
                seatChoice(selectedMovieTitle, selectedTime);
                break;
            case "3":
                System.out.println("\n****** 상영 시간 ******");
                times = movies.get(2).getTime();
                printMoviesTime(times);
                selectedTime = selectMovieTime(movies.get(2).getTime());
                seatChoice(selectedMovieTitle, selectedTime);
                break;
            case "4":
                System.out.println("\n****** 상영 시간 ******");
                times = movies.get(3).getTime();
                printMoviesTime(times);
                selectedTime = selectMovieTime(movies.get(3).getTime());
                adultSeatChoice(movieUser, selectedMovieTitle, selectedTime);
                break;
            case "5":
                System.out.println("\n****** 상영 시간 ******");
                times = movies.get(4).getTime();
                printMoviesTime(times);
                selectedTime = selectMovieTime(movies.get(4).getTime());
                seatChoice(selectedMovieTitle, selectedTime);
                break;
        }
    }


    private static void printMoviesTime(List<String> times) {
        for (int i = 0; i < times.size(); i++) {
            String time = times.get(i);
            System.out.printf("# %d. %s\n", i + 1, time);
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
    private static void adultSeatChoice(MovieUser user,String selectedMovieTitle, String selectedTime ) {
        if (repository.isNotAdult(user)) {
            System.out.println("19세 미만은 성인 영화를 예매할 수 없습니다.");
            System.out.println("영화 선택화면으로 돌아갑니다.");
            movieReservation();
        } else {
            seatChoice(selectedMovieTitle, selectedTime);
        }
    }

    // 일반영화: 그냥 좌석을 보여줌
    private static void seatChoice(String selectedMovieTitle, String selectedTime) {
        System.out.println("\n\n****** 영화 좌석 ******");
        System.out.println("****** 구매하고 싶은 좌석을 입력하세요. ******");

        // 구매한 좌석이 seats에 저장
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
        do {
            seatNumber = input("\n좌석을 입력하세요: ");
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


            // 추가 구매 여부 확인
            String continueChoice = input("좌석을 더 구매하시겠습니까? [y/n]: ");
            if (!continueChoice.equalsIgnoreCase("y")) {
                break;
            } else {
                // repository에 유저, 제목, 상영시간, 좌석 전달
                repository.addReservationInfo(movieUser, selectedMovieTitle, selectedTime, seats);

            }
        } while (true);
        viewReservationInfo();
    }

    private static void watchSeatList(String[][] seat) {
        for (String[] strings : seat) {
            for (int j = 0; j < strings.length; j++) {
                System.out.print(strings[j] + " ");
            }
            System.out.println();
        }
    }

    // 예약 정보를 확인하는 메서드
    private static void viewReservationInfo() {
        // 맵에 저장된 정보를 출력
        for (Map.Entry<String, Movie> entry : repository.getReservationMap().entrySet()) {
            String userName = entry.getKey();
            Movie movie = entry.getValue();
            System.out.println("예약자: " + userName);
            System.out.println("영화 제목: " + movie.getMovieName());
            System.out.println("상영 시간: " + movie.getTime());
            System.out.println("좌석: " + movie.getSeats());
            System.out.println("---------------------------------");
        }
    }

}
