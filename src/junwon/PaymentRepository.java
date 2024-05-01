package junwon;

public class PaymentRepository {

//    카드등록 검증 - 안되어있다 - 카드등록 -  영화 결제 진행 (쿠폰 사용 유무) - 영화예매
//    되어있다 - 영화 결제 진행

    static Payment hwang = new Payment ("황준원","1234-5678-9999-0000",100000,12000);

    public static int paymentBalance(){
        return Payment.getCardBalance()-Payment.getMoviePrice();
    }

    public static String changeCardNum(String cardNum, String cardNum2, String cardNum3, String cardNum4) {

        String newCarNum = new String(cardNum + "-" + cardNum2 + "-" +  cardNum3 + "-" +  cardNum4);
        hwang.setCreditCardNum(newCarNum);
        return newCarNum;
    }
}


