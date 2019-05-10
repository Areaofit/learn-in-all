package com.areaofit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Random;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void testRandom() {
        String s1 = new String("1")+new String("1");
        s1 = s1.intern();
        String s2 = "11";
        System.out.println(s1 == s2);
        String s3 = new String("Hello");

        String s4 = new String("Hello");
        String s5 = s4+"1";
        System.out.println(s3.equals(s4));
    }
}
