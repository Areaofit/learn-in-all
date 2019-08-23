package com.areaofit.clienta;

import com.areaofit.clienta.properties.RpcUrls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@RestController("/")
public class ClientAApplication {

    @Autowired
    private RpcUrls rpcUrls;

    public static void main(String[] args) {
        SpringApplication.run(ClientAApplication.class, args);
    }

    @RequestMapping("/a")
    public void test() {
        Map<String, Map<String, Object>> funcGroupMap = rpcUrls.getRpcSettings().get("gjs11").get("getstatus");
        System.out.println(rpcUrls.getRpcSettings());
        System.out.println("sss");
    }

}
