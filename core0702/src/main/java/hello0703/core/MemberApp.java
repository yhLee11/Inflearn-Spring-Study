package hello0703.core;

import hello0703.core.member.Grade;
import hello0703.core.member.Member;
import hello0703.core.member.MemberService;
import hello0703.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        //스프링 컨테이너 @Bean 관리
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);


        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

    }
}
