package com.areaofit.learn.jmespath;

import com.areaofit.learn.jmespath.functionExtend.CalculateFunction;
import com.areaofit.learn.jmespath.functionExtend.MatchWordsFunction;
import com.areaofit.learn.jmespath.functionExtend.SetNumFunction;
import com.areaofit.learn.jmespath.functionExtend.SubstringFunction;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.burt.jmespath.Expression;
import io.burt.jmespath.JmesPath;
import io.burt.jmespath.RuntimeConfiguration;
import io.burt.jmespath.function.FunctionRegistry;
import io.burt.jmespath.jackson.JacksonRuntime;

public class Jmespath {

    public static String P_DATA = "{\"status\":{\"code\":\"0\",\"description\":\"ok\"}" +
            ",\"data\":{\"averageMileage\":\"81.29\",\"fuelPercent\":\"57%\",\"weekMileage\":\"569.00\"" +
            ",\"percent_displace\":\"-159.33%\",\"economizeFuel\":\"-478.00\",\"weekFuel\":\"300.00\"" +
            ",\"averageFuel\":\"52.72\",\"percent_mile\":\"-173.81%\",\"mile_save\":\"-989.00\"" +
            ",\"carbonDisplacement\":\"-1128.56\",\"vin\":\"LWSRCB5K6KA000141\"}}";

    public static String MODEL_DATA = "{\"vin\":\"LWSRCB5K6KA000141\",\"status\": {\"code\": `\"0\"`,\"description\": `\"ok\"`}," +
            "\"data\": data.{\"averageMileage\":averageMileage,\"fuelPercent\":fuelPercent," +
            "\"economizeFuel\":calculate(to_number(economizeFuel), `\"mul\"`, set_num(match_words(substring(vin,`6`,`8`),`\"G2\"`), `1.23`, `4.56`))}}";

    public static String MODEL_DATA_2 = "{\"vin\":\"LWSRCB5K6KA000141\",\"status\": {\"code\": `\"0\"`,\"description\": `\"ok\"`}," +
            "\"data\": data.{\"averageMileage\":averageMileage,\"fuelPercent\":fuelPercent," +
            "\"vin\":`\"$(vin)\"`}}";

    public static void main(String[] args) throws Exception{
        Jmespath jmespath = new Jmespath();
        jmespath.test();
    }

    public void test() throws Exception {
        FunctionRegistry registry = FunctionRegistry.defaultRegistry();
        FunctionRegistry myFunction = registry.extend(new SubstringFunction(),
                new MatchWordsFunction(), new SetNumFunction(), new CalculateFunction());
        RuntimeConfiguration configuration = new RuntimeConfiguration.Builder()
                .withFunctionRegistry(myFunction).build();
        JmesPath<JsonNode> runtime = new JacksonRuntime(configuration);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode p = mapper.readTree(P_DATA);
        Expression<JsonNode> expression = runtime.compile(MODEL_DATA);
        JsonNode result = expression.search(p);
        System.out.println(result);

    }

    /**
    public void matchWordsTest() throws Exception {
        FunctionRegistry registry = FunctionRegistry.defaultRegistry();
        FunctionRegistry myFunction = registry.extend(new MatchWordsFunction());
        RuntimeConfiguration configuration = new RuntimeConfiguration.Builder()
                .withFunctionRegistry(myFunction).build();
        JmesPath<JsonNode> runtime = new JacksonRuntime(configuration);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode p = mapper.readTree("{\"a\":{\"b\":\"abcd\"}}");
        JsonNode result = runtime.compile("match_words(a.b, 'abc')").search(p);
        System.out.println(result);
    }

    public void substringFunc() throws Exception {
        FunctionRegistry registry = FunctionRegistry.defaultRegistry();
        FunctionRegistry myFunction = registry.extend(new SubstringFunction(), new MatchWordsFunction());
        RuntimeConfiguration configuration = new RuntimeConfiguration.Builder()
                .withFunctionRegistry(myFunction).build();
        JmesPath<JsonNode> runtime = new JacksonRuntime(configuration);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode p = mapper.readTree("{\"a\":{\"b\":\"abcd\"}}");
        JsonNode result = runtime.compile("match_words(substring(a.b, `1`, `3`), 'bc')").search(p);
        System.out.println(result);
    }

    public void  basicFunc() throws Exception {
        JmesPath<JsonNode> runtime = new JacksonRuntime();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode p = mapper.readTree("{\"status\": {\"code\": \"12016004\",\"description\": \"调用数据接口出错\"},\"data\": {\"d\":1}}");
        Expression<JsonNode> expression = runtime.compile("{\"vin\":\"dddd\",\"status\": {\"code\": `\"0\"`,\"description\": `\"ok\"`},\"data\": data}");
        JsonNode result = expression.search(p);
        System.out.println(result);
    }

    public void sinFunc() throws Exception {
        FunctionRegistry registry = FunctionRegistry.defaultRegistry();
        FunctionRegistry myFunction = registry.extend(new SinFunction());
        RuntimeConfiguration configuration = new RuntimeConfiguration.Builder()
                .withFunctionRegistry(myFunction).build();
        JmesPath<JsonNode> runtime = new JacksonRuntime(configuration);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode p = mapper.readTree("{\"a\":{\"b\":4}}");
        JsonNode result = runtime.compile("sin(a.b)").search(p);
        System.out.println(result);
    }

    public void replaceFunc() throws Exception {
        FunctionRegistry registry = FunctionRegistry.defaultRegistry();
        FunctionRegistry myFunction = registry.extend(new ReplaceFunction());
        RuntimeConfiguration configuration = new RuntimeConfiguration.Builder()
                .withFunctionRegistry(myFunction).build();
        JmesPath<JsonNode> runtime = new JacksonRuntime(configuration);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode p = mapper.readTree("{\"a\":{\"b\":\"abcdefg\"}}");
        JsonNode result = runtime.compile("replace(a.b, [['a','b'],['c','b']])").search(p);
        System.out.println(result);
    }

    public void splitFunc() throws Exception {
        FunctionRegistry registry = FunctionRegistry.defaultRegistry();
        FunctionRegistry myFunction = registry.extend(new SplitFunction());
        RuntimeConfiguration configuration = new RuntimeConfiguration.Builder()
                .withFunctionRegistry(myFunction).build();
        JmesPath<JsonNode> runTime = new JacksonRuntime(configuration);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode p = mapper.readTree("{\"a\":{\"b\":\"a|b|c|d|e|f|g\"}}");
        JsonNode result = runTime.compile("split(a.b, '\\|')").search(p);
        System.out.println(result);
    }
     **/
}
