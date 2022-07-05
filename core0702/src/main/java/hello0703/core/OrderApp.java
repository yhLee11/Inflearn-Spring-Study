package hello0703.core;

import hello0703.core.member.Grade;
import hello0703.core.member.Member;
import hello0703.core.member.MemberService;
import hello0703.core.order.Order;
import hello0703.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();//구체클래스가 아닌 인터페이스에만 의존
//        MemberService memberService = appConfig.memberService();//MemberServiceImpl 객체를 반환
//        OrderService orderService = appConfig.orderService();//OrderServiceImpl 객체를 반환
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("MemberService", MemberService.class);
        OrderService orderService = ac.getBean("OrderService", OrderService.class);

        Long memberId=1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println("order = " + order);
        System.out.println("order.getDiscountPrice = " + order.getDiscountPrice());
    }
}
