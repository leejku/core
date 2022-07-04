package hello.core.member;

import java.util.HashMap;
import java.util.Map;


//데이터 베이스가 확정되지 않았기 때문에, MemoryMemberRepository를 사용하여, 프로그램을 개발한다.
//메모리에서만 하기 때문에 테스트 용으로 사용하며,종료 시에 날라가는 데이터이다.
public class MemoryMemberRepository implements MemberRepository {
    // 인터페이스를 임플리먼트한 실제 구현체에서 메서드를 오버라이드해서 사용한다.


    // key : 회원 아이디, value : 회원 객체
    private static Map<Long, Member> store = new HashMap<>();
    // 동시성 이슈

    // 저장이기 때문에 return 값이 void로 없음
    @Override
    public void save(Member member) {

        // 해쉬맵에 아래 데이터를 넣는다, member의 getId는 자동으로 생성되는 것이 아닌데?
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
