package com.areaofit.MultiThread;

public class ThreadTest {

    public static void main(String[] args) {
        TestService service = new TestService();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                service.testMethod();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                service.testMethod();
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                service.testMethod();
            }
        });
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                service.testMethod();
            }
        });
        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                service.testMethod();
            }
        });
       thread1.start();
       thread2.start();
       thread3.start();
       thread4.start();
       thread5.start();
    }
}
