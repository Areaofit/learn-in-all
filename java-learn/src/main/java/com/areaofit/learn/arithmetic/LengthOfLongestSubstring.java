package com.areaofit.learn.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * 查找字符串中最长的不相同字符的字串
 */
public class LengthOfLongestSubstring {

    public static int get(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, max = 0;
        for (int i = 0;i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-left+1);
        }
        return max;
    }
}
