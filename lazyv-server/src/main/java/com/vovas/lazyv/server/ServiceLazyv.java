package com.vovas.lazyv.server;

import org.springframework.beans.factory.annotation.Autowired;


public class ServiceLazyv {

    @Autowired
    private ConfigServer configServer;

    public ConfigServer getConfigServer() {
        return configServer;
    }
}
