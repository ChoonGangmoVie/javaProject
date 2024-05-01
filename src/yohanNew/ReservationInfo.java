package yohanNew;

import chanhee.MovieUser;

// 1명의 영화 예매 정보
public class ReservationInfo {

    private MovieUser movieUser; // 영화를 예매한 사람
    private Movie movie; // 영화 정보

    // 생성자
    public ReservationInfo(MovieUser movieUser, Movie movie) {
        this.movieUser = movieUser;
        this.movie = movie;
    }

    public MovieUser getMovieUser() {
        return movieUser;
    }

    public void setMovieUser(MovieUser movieUser) {
        this.movieUser = movieUser;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "ReservationInfo{" +
                "movieUser=" + movieUser +
                ", movie=" + movie +
                '}';
    }
}
