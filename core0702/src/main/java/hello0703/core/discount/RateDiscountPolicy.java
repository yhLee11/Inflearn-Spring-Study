package hello0703.core.discount;

import hello0703.core.member.Grade;
import hello0703.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10;//10 퍼센트 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent/100;
        }else{
            return 0;
        }
    }
}
