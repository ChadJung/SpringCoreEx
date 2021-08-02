package com.springcorex.core;

import com.springcorex.core.discount.DiscountPolicy;
import com.springcorex.core.discount.RateDiscountPolicy;
import com.springcorex.core.member.MemberRepository;
import com.springcorex.core.member.MemberService;
import com.springcorex.core.member.MemberServiceImpl;
import com.springcorex.core.member.MemoryMemberRepository;
import com.springcorex.core.order.OrderService;
import com.springcorex.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
    }

    @Bean
    public MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
