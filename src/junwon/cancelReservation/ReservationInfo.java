package junwon.cancelReservation;

import chanhee.MovieUser;
import yohanNew.Movie;

public class ReservationInfo {
    private Movie movie;
    private MovieUser movieUser;

    public ReservationInfo(Movie movie, MovieUser movieUser) {
        this.movie = movie;
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
                "movie=" + movie +
                ", movieUser=" + movieUser +
                '}';
    }

    public MovieUser getMovieUser() {
        return movieUser;
    }

    public void setMovieUser(MovieUser movieUser) {
        this.movieUser = movieUser;
    }
}
