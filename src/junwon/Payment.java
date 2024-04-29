package junwon;

public class Payment {

    //    카드등록 검증 - 안되어있다 - 카드등록 -  영화 결제 진행 (쿠폰 사용 유무) - 영화예매
    //    되어있다 - 영화 결제 진행

    private static int moviePrice; // 영화가격
    private static String user; // 사용자
    private static String  creditCardNum; // 카드번호
    private static int cardBalance; // 카드잔액

    public Payment(String user, String creditCardNum, int cardBalance, int moviePrice) {
        this.user = user;
        this.creditCardNum = creditCardNum;
        this.cardBalance = cardBalance;
        this.moviePrice = 15000;
    }

    public static int getMoviePrice() {
        return moviePrice;
    }

    public void setMoviePrice(int moviePrice) {
        this.moviePrice = moviePrice;
    }

    public static int getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(int cardBalance) {
        this.cardBalance = cardBalance;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public static String getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(String newCarNum) {
        this.creditCardNum = newCarNum;
    }
}
