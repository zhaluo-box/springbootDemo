package com.example.mqconsumer;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JavaEEDDemo {


    @Test
    public void brokerTest() {

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
            if (sum > 15) {
                System.out.println(sum + "sum  求和");
                break;
            }
        }

    }

    @Test
    public void ifDemo() {

        int age = 45;

        if (age > 20) {
            log.info("你已经是一个青年人了");
        }
        if (age > 40) {
            log.info("你已经是一个中年人了");
        }
        if (age > 60) {
            log.info("你已经是一个老年人了");
        }

    }

    @Test
    public void ifDemo2() {

        int age = 45;


        if (age > 60) {
            log.info("你已经是一个老年人了");
        }

        if (age > 40) {
            log.info("你已经是一个中年人了");
        }

        if (age > 20) {
            log.info("你已经是一个青年人了");
        }
    }


    @Test
    public void switchDemo() {

        int sex = 2;

        switch (sex) {

            case 1: {
                log.info("This is a girl");
            }
            case 2: {
                log.info("This is a boy");
            }
        }

    }
}
