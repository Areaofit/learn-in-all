package com.areaofit.learn.arithmetic;

import org.junit.Assert;
import org.junit.Test;

public class LengthOfLongestSubstringTest {

    @Test
    public void testGet() throws Exception {
        int result = LengthOfLongestSubstring.get("abcabcbb");
        Assert.assertEquals(3, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme