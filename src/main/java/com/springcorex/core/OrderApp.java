package com.springcorex.core;

import com.springcorex.core.member.Grade;
import com.springcorex.core.member.Member;
import com.springcorex.core.member.MemberService;
import com.springcorex.core.order.Order;
import com.springcorex.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberID = 1L;
        Member member = new Member(memberID, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberID, "itemA", 20000);

        System.out.println("order = " + order);
    }
}
