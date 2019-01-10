package com.areaofit.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TicketSite<Ticket> implements InvocationHandler {

    private Ticket ticket;

    public TicketSite(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("携程正在帮您购票...");
        Object result = method.invoke(ticket, args);
        System.out.println("携程祝贺你购票成功，旅途愉快！");
        return result;
    }
}
