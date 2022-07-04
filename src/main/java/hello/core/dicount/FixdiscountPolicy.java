package hello.core.dicount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixdiscountPolicy implements DiscountPolicy {

    // 정액 할인은 무조건 1000원 할인을 해주기 때문에,우선 할인 금액을 지정
    private int discountFixAmount = 1000; //1000원 할인

    //하지만 등급이 VIP일 경우에만 1000원 할인을 해줌

    @Override
    public int discount(Member member, int price) {
        // vip인 경우에 정액 할인 금액인 1000원을 return 하고, 아닌 경우는 0을 return 한다.
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }

}
