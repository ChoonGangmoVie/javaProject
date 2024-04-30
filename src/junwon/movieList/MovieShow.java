package junwon.movieList;

import util.SimpleInput;

import java.util.Map;

import static util.SimpleInput.input;

public class MovieShow extends MovieInfo {
    static String movieName="";
    static String timeTable;

    public MovieShow(String movieName, String showTime, String seatNumber) {
        super(movieName, showTime, seatNumber);
    }

    static void showMovieList() {
        System.out.println("\n\n****** 현재 상영중인 영화 목록 ******");
        System.out.println("# 1. 범죄도시");
        System.out.println("# 2. 파묘");
        System.out.println("# 3. 귀멸의 칼날");
        System.out.println("# 4. 진격의 거인");
        System.out.println("# 5. 하이큐");

        String selectNum = SimpleInput.input("# >> ");

        switch (selectNum) {
            case "1":
                movieName = "범죄도시";
                sumMenu();
                break;
            case "2":
                movieName = "파묘";
                sumMenu();
                break;
            case "3":
                movieName = "귀멸의 칼날";
                sumMenu();
                break;
            case "4":
                movieName = "진격의 거인";
                sumMenu();
                break;
            case "5":
                movieName = "하이큐";
                sumMenu();
                break;
            default:
                System.out.println("잘못된 메뉴 번호 입니다.");
        }
    }

    public static void sumMenu(){
        MovieInfo.setMovieName(movieName);
        showTimeTable();
        movieSchedule(movieName);
        selectTimeTable();
    }

    public static void movieSchedule(String movieName) {
        // MovieList 클래스의 getMovieSchedule 메서드 호출하여 영화 일정 가져오기
        Map<String, String[]> movieSchedule = MovieList.getMovieSchedule(movieName);
        String[] selectMovieSchedule = movieSchedule.get(movieName);
        for (String showTime : selectMovieSchedule) {
            System.out.println(showTime);
        }
        System.out.println("\n==============================");
    }

    private static void showTimeTable () {
        System.out.println("\n==============================");
        System.out.println("");
        System.out.println("######  " + movieName + "의 상영시간표  ######");
    }

    private static void selectTimeTable(){
        String timeSelect = SimpleInput.input("#>> ");
        switch (timeSelect){
            case "1":
                timeTable = ("# 1 .05월 07일 오전 09시 00분");
                MovieInfo.setShowTime(timeTable);
                timTableCheck();
            case "2":
                timeTable = ("# 2 .05월 10일 오후 03시 40분");
                timTableCheck();
                break;
            case "3":
                timeTable = ("# 3 .05월 13일 오후 06시 30분");
                timTableCheck();
                break;
            case "4":
                timeTable = ("# 4 .05월 16일 오후 05시 00분");
                timTableCheck();
                break;
            case "5":
                timeTable = ("# 5 .05월 25일 오후 08시 10분");
                timTableCheck();
                break;
        }
    }

    public static void timTableCheck(){
        System.out.printf("선택한 상영시간이 %s 가 맞습니까? (Y/N)",timeTable);
        System.out.println("\n==============================");
        timeLoopCheck();
    }

    public static void timeLoopCheck(){
        while (true) {
            String timeRecheck = SimpleInput.input("#>> ");
            System.out.println("\n==============================");
            if(timeRecheck.equals("Y") ||timeRecheck.equals("y")){
                notAdultSeatList();

                return;
            }else if (timeRecheck.equals("N") ||timeRecheck.equals("n")) {
                System.out.println("# 상영 시간표 선택 화면으로 돌아갑니다.");
                System.out.println("\n==============================");
                movieSchedule(movieName);
            }else{
                System.out.println("# Y/N 중 하나를 입력하세요");
            }
        }
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

