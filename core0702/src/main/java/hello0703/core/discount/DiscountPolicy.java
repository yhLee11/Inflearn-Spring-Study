package hello0703.core.discount;

import hello0703.core.member.Member;

public interface DiscountPolicy {

    //return 할인대상금액
    int discount(Member member, int price);

}
