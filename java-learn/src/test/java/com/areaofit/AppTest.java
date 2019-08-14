package com.areaofit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testGroup() {
        String REGEX = "\\$\\(([\\w\\.]+)\\)";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher("abc$(vin)hjw$(ok)www");
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String str = m.group(1);
            System.out.println(str);
            m.appendReplacement(sb, "001");
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
    }
}
