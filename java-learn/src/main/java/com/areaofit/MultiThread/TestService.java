package com.areaofit.MultiThread;

public class TestService {

    public void testMethod(){
        System.out.println("Hashcode:"+this.hashCode()+" ---> 当前线程是:"+Thread.currentThread().getName());
    }
}
