package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    //생성자 주입
    @Autowired//스프링이 스프링 컨테이너에 있는 memberService와 연결시켜 주는 역할
    public MemberController(MemberService memberService){//생성자로 한번 등록함
        this.memberService=memberService;
    }

    //필드 주입
//    @Autowired private MemberService memberService;

    //setter 주입
//    @Autowired
//    public void setMemberService(MemberService memberService){
//        this.memberService = memberService;
//    }

}
