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
        Random random = new Random();
        System.out.println(random.nextInt(10000000));
    }
}
