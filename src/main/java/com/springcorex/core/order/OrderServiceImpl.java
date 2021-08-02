package com.springcorex.core.order;

import com.springcorex.core.discount.DiscountPolicy;
import com.springcorex.core.member.Member;
import com.springcorex.core.member.MemberRepository;
import com.springcorex.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberID, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberID);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberID, itemName, itemPrice, discountPrice);
    }
}
