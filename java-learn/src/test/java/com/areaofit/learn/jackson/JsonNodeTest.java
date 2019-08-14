package com.areaofit.learn.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.Iterator;

public class JsonNodeTest {

    @Test
    public void test1() throws Exception {
        String json = "{\"a\":{\"b\":{\"c\":\"ok\"}}}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(json);
        System.out.println(jsonNode);
        System.out.println(jsonNode.get("a"));
    }
}
