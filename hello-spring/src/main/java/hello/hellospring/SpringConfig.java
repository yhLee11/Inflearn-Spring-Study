package hello.hellospring;

import hello.hellospring.controller.MemberController;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());//스프링 빈에 등록되어 있는 memberRepository를 MemberService에 넣어준다.
    }

    @Bean
    public MemberRepository memberRepository() {//인터페이스는 new 안됨
        return new MemoryMemberRepository();
    }
}
