package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void berforeEach() {//테스트가 실행할 때마다 생성
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){//메서드가 끝날 때마다 실행되는 메서드: 콜백메서드
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {//join
        //given 뭔가 주어졌을 때: 데이터
        Member member = new Member();
        member.setName("hello");

        //when 이게 실행됐을 때: 검증부분
        Long saveId = memberService.join(member);

        //then 결과가 이렇게 되어야 한다: 검증확인
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        //방법1
        try {
            memberService.join(member2);//같은 이름으로 등록이 되면 fail
            memberService.join(member2);//같은 이름으로 등록이 되면 fail
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
        //방법2
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));//member2를 넣으면 앞에 예외가 터져야함: 성공
        //방법3
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}