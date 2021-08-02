package com.springcorex.core.discount;

import com.springcorex.core.member.Grade;
import com.springcorex.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercentage = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercentage / 100;
        } else {
            return 0;
        }

    }
}
