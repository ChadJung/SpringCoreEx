package com.springcorex.core.order;

import com.springcorex.core.AppConfig;
import com.springcorex.core.member.Grade;
import com.springcorex.core.member.Member;
import com.springcorex.core.member.MemberService;
import com.springcorex.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberID = 1L;
        Member member = new Member(memberID, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberID, "itemA", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}