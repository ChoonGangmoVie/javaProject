package junwon.coupon;

import java.util.HashMap;
import java.util.Map;

public class CouponList{
    public static void main(String[] args) {


            Map<String,Object> coupon  = new HashMap<>();

            coupon.put("첫 회원가입","영화금액 20% 할인쿠폰");
            coupon.put("회원가입+카드등록","영화금액 50% 할인쿠폰");

            int num =1;
            System.out.println("쿠폰 내역");
            for (String songList : coupon.keySet()) {
                System.out.printf("#%d %s \n",num++,songList);
            }
        }
    }



