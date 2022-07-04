package hello.core;

import hello.core.dicount.DiscountPolicy;
import hello.core.dicount.FixdiscountPolicy;
import hello.core.dicount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
        // MemberServiceImpl 같은 경우, new 해가지고 MemmoryMemberRepository 객체를 생성해서,
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }


    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
