package junwon.movieList;


public class MovieInfo {

    private String movieName;
    private String showTime;
    private String seatNumber;

    public MovieInfo(String movieName, String showTime, String seatNumber) {
        this.movieName = movieName;
        this.showTime = showTime;
        this.seatNumber = seatNumber;
    }

    public String getMovieName() {
        return movieName;
    }

    public static void setMovieName(String movieName) {
        movieName = movieName;
    }

    public static void setShowTime(String showTime) {
        showTime = showTime;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getShowTime() {
        return showTime;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    @Override
    public String toString() {
        return "영화 제목: " + movieName + ", 상영 시간: " + showTime + ", 좌석 번호: " + seatNumber;
    }
}