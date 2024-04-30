package yohan;

import chanhee.MovieUser;


import static chanhee.Gender.MALE;

// 1명의 영화 예매 정보
public class MovieReserve {

    private MovieUser movieUser; // 영화를 예매할 손님
    private MovieInfo movieReservationList;// 영화 예약 목록 (영화제목, 날짜, 좌석리스트)


    // 생성자
    public MovieReserve() {

        movieUser = new MovieUser("rnfaos77", "1234", "김요한", 15, MALE);
    }


    public MovieUser getMovieUser() {
        return movieUser;
    }

    public void setMovieUser(MovieUser movieUser) {
        this.movieUser = movieUser;
    }

    public MovieInfo getMovieReservationList() {
        return movieReservationList;
    }

    public void setMovieReservationList(MovieInfo movieReservationList) {
        this.movieReservationList = movieReservationList;
    }

    // 나이 가져오기
    public int getUserAge() {
        return movieUser.getAge();
    }

    @Override
    public String toString() {
        return "MovieReserve{" +
                "movieUser=" + movieUser +
                ", movieList=" + movieReservationList +
                '}';
    }
}
