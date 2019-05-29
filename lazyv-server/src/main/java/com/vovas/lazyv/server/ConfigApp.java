package com.vovas.lazyv.server;

import com.vovas.lazyv.server.executors.KeyExecutor;
import com.vovas.lazyv.server.executors.KeyExecutorMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.net.SocketException;

@Configuration
public class ConfigApp {

    @Bean
    @Scope("singleton")
    public ConfigServer configServer() throws SocketException {
        return new ConfigServer("VovasHost", "8777", "Started", 8777, true);
    }

    @Bean
    @Scope("singleton")
    public ServiceLazyv serviceLazyv(){

        return new ServiceLazyv();
    }

    @Bean
    public KeyExecutor keyExecutor() {
        return new KeyExecutorMock();
    }

}
