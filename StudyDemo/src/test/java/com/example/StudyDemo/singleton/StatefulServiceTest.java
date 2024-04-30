package com.example.StudyDemo.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA : A사용자 10000원 주문
        int userA = statefulService1.order("userA", 10000);

        // ThreadB : B사용자 20000원 주문
        int userB = statefulService2.order("userB", 20000);

        // ThreadA : A사용자 주문 금액 조회
//        int price = statefulService1.getprice();
        System.out.println("userA = " + userA);
        System.out.println("userB = " + userB);

//        Assertions.assertThat(statefulService1.getprice()).isEqualTo(20000);
        assertThat(userA).isEqualTo(10000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}