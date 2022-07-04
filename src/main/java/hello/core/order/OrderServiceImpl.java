package hello.core.order;


import hello.core.dicount.DiscountPolicy;
import hello.core.dicount.FixdiscountPolicy;
import hello.core.dicount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {


    // 1. 주문 생성이 오면 회원 저장소에서 회원 정보를 먼저 조회를 하고고
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);

        // 2. 할인 정책에 회원을 그냥 통으로 넘깁니다.(확장성을 고려하여, grade 말고 통으로 넘김)
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
