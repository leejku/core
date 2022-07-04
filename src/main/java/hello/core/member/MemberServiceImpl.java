package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 가입하고, 회원조회를 하기 위해서는 MemberRepository가 필요함

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
