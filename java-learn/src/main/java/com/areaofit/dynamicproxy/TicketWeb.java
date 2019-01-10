package com.areaofit.dynamicproxy;

import java.util.Random;

/**
 * 售票类
 */
public class TicketWeb implements Ticket{

    /**
     * 售票
     */
    @Override
    public int sellTicket() {
        Random random = new Random();
        int i = random.nextInt(10000000);
        System.out.println("12306售出的票号为："+i);
        return i;
    }
}
