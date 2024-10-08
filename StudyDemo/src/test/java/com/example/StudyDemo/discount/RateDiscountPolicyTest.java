package com.example.StudyDemo.discount;

import com.example.StudyDemo.Member.Grade;
import com.example.StudyDemo.Member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
    
    @Test
    @DisplayName("VIP 10% 할인 적용")
    void vip_o() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);
        
        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인 적용 x")
    void vip_x() {
        //given
        Member member = new Member(1L, "memberA", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(0);
    }

}