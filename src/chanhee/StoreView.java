package chanhee;

import static util.SimpleInput.*;

public class StoreView {

    public void showStoreScreen() {
        System.out.println("# 1. 매점 이용하기");
        System.out.println("# 2. 매점 이용 종료");
    }

    public void popcorn() {
        System.out.println("\n========== 팝콘 ==========");
        System.out.println("고소팝콘(M) / 고소팝콘(L)");
        System.out.println("카라멜팝콘(M) / 카라멜팝콘(L)");
        System.out.println("더블치즈팝콘(M) / 더블치즈팝콘(L)");
        System.out.println("바질어니언팝콘(M) / 바질어니언팝콘(L)");

    }

    public void drinks() {
        System.out.println("========== 음료 ==========");
        System.out.println("탄산음료(M) / 탄산음료(L)");
        System.out.println("아메리카노(ICE) / 아메리카노(HOT)");
        System.out.println("에이드(ORANGE) / 에이드(GRAPEFRUIT)");
    }

    public void snack() {
        System.out.println("========== 스낵 ==========");
        System.out.println("칠리치즈나쵸");
        System.out.println("플레인 핫도그");
        System.out.println("칠리치즈 핫도그");
    }

    public void store() {
        popcorn();
        drinks();
        snack();
//        input("- 구매하실 메뉴를 ")
    }
}
