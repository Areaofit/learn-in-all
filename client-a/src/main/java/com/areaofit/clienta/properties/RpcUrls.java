package com.areaofit.clienta.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@ConfigurationProperties(prefix = "rpcUrls")
@Component
public class RpcUrls {

    private Map<String, Map<String, Map<String, Map<String, Object>>>> rpcSettings;

    public Map<String, Map<String, Map<String, Map<String, Object>>>> getRpcSettings() {
        return rpcSettings;
    }

    public void setRpcSettings(Map<String, Map<String, Map<String, Map<String, Object>>>> rpcSettings) {
        this.rpcSettings = rpcSettings;
    }
}
