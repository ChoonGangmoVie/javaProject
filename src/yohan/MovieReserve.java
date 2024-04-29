package yohan;

import chanhee.MovieUser;

import java.util.Set;

// 1명의 영화 예매 정보
public class MovieReserve {

    private MovieUser movieUser; // 영화를 예매할 손님
    private Set<String> movieList; // 영화 목록 (1명이 여러개의 영화 예약할 수 있음)

    // 생성자

    public MovieReserve(Set<String> movieList) {
        this.movieList = movieList;
    }

    public MovieReserve(MovieUser movieUser, Set<String> movieList) {
        this.movieUser = movieUser;
        this.movieList = movieList;
    }

    public MovieUser getMovieUser() {
        return movieUser;
    }

    public void setMovieUser(MovieUser movieUser) {
        this.movieUser = movieUser;
    }

    public Set<String> getMovieList() {
        return movieList;
    }

    public void setMovieList(Set<String> movieList) {
        this.movieList = movieList;
    }

    @Override
    public String toString() {
        return "MovieReserve{" +
                "movieUser=" + movieUser +
                ", movieList=" + movieList +
                '}';
    }
}
