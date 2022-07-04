package hello.core.dicount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    // 정률 할인 비율은 10%
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price* discountPercent / 100; // 할인 금액을 반환하는 것이기 때문에, 가격에 0.1을 곱하면 됩니다.
        } else {
            return 0;
        }
    }
}
