package yohan;

import java.time.LocalDate;
import java.util.List;

public class MovieInfo {

    private String movieName; // 영화 제목
    private LocalDate reserveDate; // 날짜
    private List<String> seats; // 좌석 리스트

    public MovieInfo(String movieName, LocalDate reserveDate, List<String> seats) {
        this.movieName = movieName;
        this.reserveDate = reserveDate;
        this.seats = seats;
    }

    public String getMovieName(String menuNum) {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public LocalDate getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(LocalDate reserveDate) {
        this.reserveDate = reserveDate;
    }

    public List<String> getSeats() {
        return seats;
    }

    public void setSeats(List<String> seats) {
        this.seats = seats;
    }
}
