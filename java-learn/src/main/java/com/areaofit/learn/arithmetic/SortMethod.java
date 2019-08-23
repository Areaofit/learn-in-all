package com.areaofit.learn.arithmetic;

/**
 * 排序算法集合
 */
public class SortMethod {

    /**
     * 冒泡排序算法：
     * 1、比较相邻的两个数，把较大（较小）的数往后放；
     * 2、一次循环后，数组的最后一个数则为最大的数；
     * 3、依次循环，最后得到从小到大的数组排序；
     * @param source
     * @return
     */
    public static int[] bubbleSort(int[] source) {
        if (source.length == 0 || source.length == 1)
        {
            return source;
        }
        else
        {
            for (int i = 0;i < source.length;i++) {
                for (int j = 0;j < source.length - i - 1;j++) {
                    if (source[j] > source[j+1])
                    {
                        int temp = source[j+1];
                        source[j+1] = source[j];
                        source[j] = temp;
                    }
                }
            }
            return source;
        }
    }

    /**
     * 选择排序算法：
     *
     * @param source
     * @return
     */
    public static int[] selectSort(int[] source) {
        for (int i = 0;i < source.length;i++) {
            int temp = i;
            for (int j = i+1;j < source.length;j++) {
                if (source[j] < source[temp])
                {
                    temp = j;
                }
            }
            int tempVal = source[i];
            source[i] = source[temp];
            source[temp] = tempVal;
        }
        return source;
    }

    /**
     *
     * @param source
     * @return
     */
    public static int[] insertSort(int[] source) {
        for (int i = 0;i < source.length;i++) {
            int tempIndex = i;
            int tempVal = source[i];
            if (tempIndex-1 > 0 && source[i+1] < source[i]) {

            }
        }
        return source;
    }

}
