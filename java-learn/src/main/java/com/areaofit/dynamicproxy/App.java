package com.areaofit.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TicketSite ticketSite = new TicketSite(new TicketWeb());
        Ticket ticketWeb = (Ticket) Proxy.newProxyInstance(Ticket.class.getClassLoader(), new Class[] {Ticket.class}, ticketSite);
        int i = ticketWeb.sellTicket();
        System.out.println("买到的票号为："+i);
    }
}
