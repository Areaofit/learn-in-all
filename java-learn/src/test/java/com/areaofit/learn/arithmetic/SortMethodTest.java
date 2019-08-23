package com.areaofit.learn.arithmetic;

import org.junit.Test;

public class SortMethodTest {

    @Test
    public void test() {
        int[] array = new int[]{2,3,1,4,6,0};
        int[] ret = SortMethod.bubbleSort(array);
        for (int i : ret)
        {
            System.out.print(i);
        }
    }

    @Test
    public void selectSortTest() {
        int[] array = new int[]{2,3,1,4,6,0};
        int[] ret = SortMethod.selectSort(array);
        for (int i : ret)
        {
            System.out.print(i);
        }
    }
}
