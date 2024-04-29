package songjihoon;

public class ReservationInfo {
    private static String userName;
    private String userId;
    private String userPassword;
    private String movieTitle;


    public ReservationInfo(String userName, String userId, String userPassword, String movieTitle) {
        this.userName = userName;
        this.userId = userId;
        this.userPassword = userPassword;
        this.movieTitle = movieTitle;
    }
    ReservationInfo info = new ReservationInfo("송지훈", "jjang1702", "jjang1234", "범죄도시4");



    public static String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    @Override
    public String toString() {
        return "ReservationInfo{" +
                "userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", movieTitle='" + movieTitle + '\'' +
                '}';
    }
}
