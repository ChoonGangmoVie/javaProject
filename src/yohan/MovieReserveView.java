package yohan;

import static util.SimpleInput.input;

// 프로그램의 입출력 처리 담당
public class MovieReserveView {

    private static MovieReserveRepository repository = new MovieReserveRepository();
    private static MovieReserve movieReserve;


    // 전역 변수
    private static boolean isFirstMenuPrinted = false; // 처음 메뉴 출력 여부를 관리하는 변수

    // 프로그램 실행
    public static void reservationStart() {

        while (true) {
            if (!isFirstMenuPrinted) { // 처음 메뉴를 출력한 경우
                System.out.println("# 1. 영화예매");
            }
            isFirstMenuPrinted = true; // isFirstMenuPrinted를 true로 설정하여 다시 출력되지 않도록 함

            String menuNum = input(">> ");
            switch (menuNum) {
                case "1":
                    movieChoice();
                    break;
            }
        }
    }

    // 1. 영화 목록에서 영화를 선택
    private static void movieChoice() {

        movieList();
        String menuNum = input(">> ");
        switch (menuNum) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
                weatherChoice(menuNum);
                repository.addMovie(menuNum); // 영화 movieReservationList에 추가
                break;
            case "6":
                System.out.println("# 1. 영화예매");
                reservationStart();
                break;
            default:
                System.out.println("\n\n# 올바르지 않은 선택입니다.");
                reservationStart();
                break;
        }
    }


    private static void movieList() {
        System.out.println("\n\n****** 현재 상영중인 영화 목록 ******");
        System.out.println("# 1. 범죄도시4");
        System.out.println("# 2. 파묘");
        System.out.println("# 3. 귀멸의 칼날");
        System.out.println("# 4. 진격의 거인");
        System.out.println("# 5. 하이큐");
        System.out.println("=======================");
        System.out.println("# 6. 뒤로가기");
    }


    // 2. 영화 날짜 및 상영 시간 선택
    private static void weatherChoice(String menuNum) {

        System.out.println("\n\n****** 영화 상영 시간 ******");
        if (menuNum.equals("1")) {
            movieWeatherList1();
        } else if (menuNum.equals("2")) {
            movieWeatherList2();
        } else if (menuNum.equals("3")) {
            movieWeatherList3();
        } else if (menuNum.equals("4")) {
            movieWeatherList4();
        } else {
            movieWeatherList5();
        }
        System.out.println("# 6. 뒤로가기");

        String menuNumber = input(">> ");
        switch (menuNumber) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
                remainingSeatChoice(menuNumber);
                break;
            case "6":
                movieChoice();
                break;
            default:
                System.out.println("\n\n# 올바르지 않은 선택입니다.");
                break;
        }
    }

    private static void movieWeatherList1() {
        System.out.println("# 1. 05월 07일 오전 09시 00분");
        System.out.println("# 2. 05월 10일 오후 03시 40분");
        System.out.println("# 3. 05월 13일 오후 06시 30분");
        System.out.println("# 4. 05월 16일 오후 05시 00분");
        System.out.println("# 5. 05월 25일 오후 08시 10분");
    }

    private static void movieWeatherList2() {
        System.out.println("# 1. 05월 07일 오전 09시 00분");
        System.out.println("# 2. 05월 10일 오후 03시 40분");
        System.out.println("# 3. 05월 13일 오후 06시 30분");
        System.out.println("# 4. 05월 16일 오후 05시 00분");
        System.out.println("# 5. 05월 25일 오후 08시 10분");
    }

    private static void movieWeatherList3() {
        System.out.println("# 1. 05월 07일 오전 09시 00분");
        System.out.println("# 2. 05월 10일 오후 03시 40분");
        System.out.println("# 3. 05월 13일 오후 06시 30분");
        System.out.println("# 4. 05월 16일 오후 05시 00분");
        System.out.println("# 5. 05월 25일 오후 08시 10분");
    }

    private static void movieWeatherList4() {
        System.out.println("****** 본 영화는 [청소년 관람불가] 입니다. ******");
        System.out.println("****** 관람 시 신분증을 꼭 지참해 주세요. ^^7 ******");
        System.out.println("# 1. 05월 07일 오전 09시 00분");
        System.out.println("# 2. 05월 10일 오후 03시 40분");
        System.out.println("# 3. 05월 13일 오후 06시 30분");
        System.out.println("# 4. 05월 16일 오후 05시 00분");
        System.out.println("# 5. 05월 25일 오후 08시 10분");

    }

    private static void movieWeatherList5() {
        System.out.println("# 1. 05월 07일 오전 09시 00분");
        System.out.println("# 2. 05월 10일 오후 03시 40분");
        System.out.println("# 3. 05월 13일 오후 06시 30분");
        System.out.println("# 4. 05월 16일 오후 05시 00분");
        System.out.println("# 5. 05월 25일 오후 08시 10분");
    }

    // 3. 영화 좌석 선택
    private static void remainingSeatChoice(String menuNumber) {
        System.out.println("\n\n****** 영화 좌석 ******");
        System.out.println("****** 구매하고 싶은 좌석을 입력하세요. ******");
        switch (menuNumber) {
            case "1":
            case "2":
            case "3":
            case "5":
                notAdultSeatList();
                break;
            case "4":
                adultSeatList();
                break;
        }
        System.out.println("\n\n# 뒤로가기");
    }

    // 일반 영화 좌석
    private static void notAdultSeatList() {
        // 5 x 10 영화관 좌석 생성
        String[][] seat = new String[5][10];
        String[] eng = {"A", "B", "C", "D", "E"};
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                seat[i][j] = eng[i] + (j + 1);
            }
        }

        // 영화관 좌석 번호 확인
        watchSeatList(seat);

        String seatNumber = null;
        while (true) {
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
        }
    }

    // 성인 영화 좌석 ( + 나이 검증)
    private static void adultSeatList() {
        if (repository.isNotAdult()) {
            System.out.println("이 영화는 19세 이상만 시청할 수 있습니다.");
            System.exit(0);
        } else {
            // 5 x 10 영화관 좌석 생성
            String[][] seat = new String[5][10];
            String[] eng = {"A", "B", "C", "D", "E"};
            for (int i = 0; i < seat.length; i++) {
                for (int j = 0; j < seat[i].length; j++) {
                    seat[i][j] = eng[i] + (j + 1);
                }
            }

            // 영화관 좌석 번호 확인
            watchSeatList(seat);

            String seatNumber = null;
            while (true) {
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
            }
        }
    }

    private static void watchSeatList(String[][] seat) {
        for (String[] strings : seat) {
            for (int j = 0; j < strings.length; j++) {
                System.out.print(strings[j] + " ");
            }
            System.out.println();
        }
    }
}

