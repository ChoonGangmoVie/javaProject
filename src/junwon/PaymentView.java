package junwon;

import util.SimpleInput;
import static junwon.Payment.*;
import static junwon.Payment.getMoviePrice;
import static junwon.PaymentRepository.*;

public class PaymentView {

    //    카드등록 검증 - 안되어있다 - 카드등록 -  영화 결제 진행 (쿠폰 사용 유무) - 영화예매
    //    되어있다 - 영화 결제 진행

    public static void start(){
        choiceCardOrCash();
    }

    public static void registeredCardSelectMenu() {
        System.out.println("==============================");
        System.out.println("# 1. 카드 등록");
        System.out.println("# 2. 카드 조회");
        System.out.println("# 3. 카드 변경");
        System.out.println("# 4. 이전 메뉴로 돌아가기");

        String selectNum = SimpleInput.input(">> ");

        switch (selectNum){
            case "1":
                registeredCard();
                break;
            case "2":
                findCardInfo();
                break;
            case "3":
                changeCardInfo();
                break;
            case "4":
                break;
        }
    }

    private static void findCardInfo() {
        if(hwang.getCreditCardNum()==null){
            System.out.println("==============================");
            System.out.println("# 등록된 카드가 없습니다. 카드를 등록하시겠습니까?");
            String choiceRegisterCard = SimpleInput.input(">>(Y/N): ");
            if(choiceRegisterCard.equals("Y")){
                registeredCard();
            }else{
                registeredCardSelectMenu();
            }
        }else{
            System.out.println("==============================");
            System.out.println("# 등록카드정보 #");
            System.out.printf("# 카드소유주: %s\n",hwang.getUser());
            System.out.printf("# 카드번호: %s\n",hwang.getCreditCardNum());
        }
    }


    public static void choiceCardOrCash(){
        System.out.println("\n==============================\n");
        System.out.println("# 1. 카드 결제");
        System.out.println("# 2. 현금 결제");
        String choiceAnswer = SimpleInput.input(">>");
        switch (choiceAnswer){
            case "1":
                System.out.println("카드 결제를 선택하셨습니다.");
                System.out.println("==============================");
                cardCheck();
                break;
            case "2":
                System.out.println("현금 결제를 선택하셨습니다.");
                System.out.println("==============================");
                paymentToCash();
                break;
            default:
                System.out.println("잘못된 메뉴 번호 입니다.");
                System.out.println("==============================");
        }

    }

    public static void cardCheck() {

        // 카드가 등록된 상태
        if (hwang.getCreditCardNum()!=null) {
            // 등록 카드 결제 여부 확인
            System.out.println("등록 된 카드로 결제하시겠습니까?");
            System.out.printf("등록 된 카드번호: " + hwang.getCreditCardNum() + " (Y/N)\n");
            String payAnswer = SimpleInput.input(">>");
            System.out.println("==============================");

            if(payAnswer.equals("Y")){
                // 등록된 카드로 결제를 원할때
                if(getCardBalance() >= getMoviePrice()){
                    // 카드에 잔액/한도가 있을때
                    System.out.printf("결제 전 카드 잔액(한도): %s\n",getCardBalance());
                    System.out.printf("결제 될 카드 금액: %s\n",getMoviePrice());
                    System.out.printf("결제 후 카드 잔액(한도): %s\n", paymentBalance());
                    System.out.println("등록 된 카드로 결제가 완료되었습니다.");
                    System.out.println("==============================");

                }else{
                    // 카드에 잔액/한도가 부족할때
                    System.out.printf("현재 카드 잔액(한도): %s\n", getCardBalance());
                    System.out.printf("결제 될 카드 금액: %s\n",getMoviePrice());
                    System.out.println("카드 잔액(한도)가 부족합니다.");
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    System.out.println("==============================");
                    choiceCardOrCash();
                }

            }else {

                // 등록된 카드로 결제를 원하지 않을때
                System.out.println("등록 된 카드정보를 변경하시겠습니까?");
                String registerCard = SimpleInput.input(">>" + "(Y/N)");

                if(registerCard.equals("Y")){
                    // 카드 변경 메뉴로 이동
                    System.out.println("카드 변경 메뉴로 이동합니다.");
                    System.out.println("==============================");
                    changeCardInfo();

                }else{
                    // 이전 메뉴로 이동
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    choiceCardOrCash();

                }
            }

            // 카드가 미등록된 상태
        } else {

            System.out.println("등록 된 카드가 없습니다. 카드를 등록하시겠습니까?");
            String cardRegisterAnswer = SimpleInput.input(">> (Y/N)");
            if(cardRegisterAnswer.equals("Y")){

                // 카드 등록을 원할때
                System.out.println("카드 등록 메뉴로 이동합니다.");
                System.out.println("==============================");
                registeredCard();

            }else{

                // 카드 등록을 원하지 않을때
                System.out.println("카드 등록을 취소하였습니다. 이전 메뉴로 돌아갑니다.");
                choiceCardOrCash();

            }
        }
    }

    private static void registeredCard() {
        System.out.println("# 등록할 카드 번호를 입력하세요");
        cardLengthCheck();
        findCardInfo();
    }

    private static String changeCardInfo() {
        System.out.println("# 변경할 카드 번호를 입력하세요");
        cardLengthCheck();
        System.out.println("==============================");
        System.out.println(" 카드 정보가 변경 되었습니다");
        System.out.println("==============================");
        System.out.printf("# 변경된 카드 정보: %s\n", hwang.getCreditCardNum());
        System.out.println("==============================");
        return null;
    }

    private static String cardLengthCheck(){
        String CardNum;
        while (true) {
            CardNum = SimpleInput.input("@첫번째 4자리@\n반드시 숫자 4자리를 입력하세요>> ");
            System.out.println("==============================");
            if (CardNum.length() == 4) {
                break;
            }
        }
        String CardNum2;
        while (true) {
            CardNum2 = SimpleInput.input("@두번째 4자리@\n반드시 숫자 4자리를 입력하세요>> ");
            System.out.println("==============================");
            if (CardNum2.length() == 4) {
                break;
            }
        }
        String CardNum3;
        while (true) {
            CardNum3 = SimpleInput.input("@세번째 4자리@\n반드시 숫자 4자리를 입력하세요>> ");
            System.out.println("==============================");
            if (CardNum3.length() == 4) {
                break;
            }
        }
        String CardNum4;
        while (true) {
            CardNum4 = SimpleInput.input("@네번째 4자리@\n반드시 숫자 4자리를 입력하세요>> ");
            if (CardNum4.length() == 4) {
                break;
            }
        }

        changeCardNum(CardNum, CardNum2, CardNum3, CardNum4);
        return null;
    }


    // 현금 결제 진행시
    private static void paymentToCash() {
        int account = (int) ((Math.random() * 8999) + 1000);
        int account2 = (int) ((Math.random() * 8999) + 1000);
        int account3 = (int) ((Math.random() * 8999) + 1000);
        int account4 = (int) ((Math.random() * 8999) + 1000);
        String[] bank = {"국민", "신한", "중앙", "하나", "농협"};
        double random=Math.random();
        int num = (int)Math.round(random * (bank.length-1));
        System.out.printf("@"+bank[num]+"은행@");
        System.out.printf(" (계상계좌로 30분이내로 입금 부탁 드립니다).\n>>%s-%s-%s-%s\n",account,account2,account3,account4);
        System.out.printf("# 영화제목: 범죄도시\n");
        System.out.printf("# 상영시간: 2024년 4월 29일 15시30분\n");
        System.out.printf("# 영화금액: %s원\n",hwang.getMoviePrice());
        System.out.println("\n==============================");
    }

}
