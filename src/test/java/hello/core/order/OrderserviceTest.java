package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderserviceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void order() {
        //given
        // OrderServiceImpl()의 메소드 사용을 위해 new 키워드로 초기화


        //1. member 정보 생성
        Long memberId = 1L;
        Member member = new Member(memberId, "test", Grade.VIP);



        // when
        //2. Member 정보 저장
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);


        //then
        // 계산된 결과가, 상품 가격화 할인 가격을 뺀 것과 같은지 확인한다.
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
        Assertions.assertThat(order.calculatePrice()).isEqualTo(order.getItemPrice() - order.getDiscountPrice());

    }






}
