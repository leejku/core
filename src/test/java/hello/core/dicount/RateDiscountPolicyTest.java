package hello.core.dicount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        /**
         * given
         * VIP 회원이 존재합니다.
         */
        Long memberId = 1L;
        int price = 10000;
        Member member = new Member(memberId, "memberVIP", Grade.VIP);

        /**
         * when
         * 할인 정책 discount 메소드를 호출하여 member 객체와 상품가격을 통으로 넘긴다.
         */
        int discountPrice = discountPolicy.discount(member, price);


        /**
         * then
         * 정률 할인을 적용한 할인 금액은 1000원이 되어야 합니다.
         */
        assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")

    void vip_x() {
        //given
        Long memberId = 2L;
        int price = 10000;
        Member member = new Member(memberId, "memberBASIC", Grade.BASIC);

        //when
        int discountPrice = discountPolicy.discount(member, price);

        //then
        assertThat(discountPrice).isEqualTo(0);
    }

}