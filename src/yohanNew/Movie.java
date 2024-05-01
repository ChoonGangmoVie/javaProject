package yohanNew;

import java.time.LocalDateTime;
import java.util.List;

// 영화의 정보와 금액
public class Movie {

    private String movieName; // 영화 제목
    private int fee; // 금액
    private List<String> time; // 상영시간
    private List<String> seats; // 좌석


    public Movie() {
    }

    public Movie(String movieName, int fee, List<String> time, List<String> seats) {
        this.movieName = movieName;
        this.fee = fee;
        this.time = time;
        this.seats = seats;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }

    public List<String> getSeats() {
        return seats;
    }

    public void setSeats(List<String> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", fee=" + fee +
                ", time=" + time +
                ", seats=" + seats +
                '}';
    }
}
