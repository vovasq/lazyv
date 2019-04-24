package com.vovas.lazyv.server;

import com.vovas.lazyv.server.executors.KeyExecutor;
import com.vovas.lazyv.server.executors.KeyExecutorMock;
import com.vovas.lazyv.server.request.KeyRequest;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServerController {

    private static final Logger LOG = Logger.getLogger(ServerController.class);

    private KeyExecutor keyExecutor = new KeyExecutorMock();
    private NativeEasyKeySender nativeKeyExecutor = new NativeEasyKeySender();

    private ServiceLazyv serviceLazyv = new ServiceLazyv(
            new ConfigServer("VovasHost", "8777", "127.0.0.1", "Started", "8777", true));

    @GetMapping("alive")
    public String aliveString() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        keyExecutor.pressKeyByCode(1);
        return "OK";
    }

    @PostMapping("press")
    public String pressKey(KeyRequest request) {

        LOG.info("Present key with code: " + request);
        nativeKeyExecutor.sendEasyKey(request.getCode());
        return "OK";
    }


    @PostMapping("mock")
    public String mockPressKey(KeyRequest request) {

        LOG.info("Present key with code: " + request);
        keyExecutor.pressKeyByCode(request.getCode());
        return "OK";
    }

    @GetMapping("config")
    public ConfigServer getConfigServer() {
        return serviceLazyv.getConfigServer();
    }

    @PostMapping("update")
    public String updateServerConfig(@RequestBody String hostName, String passcode, boolean isVisible) {
        serviceLazyv.getConfigServer().setHostName(hostName);
        serviceLazyv.getConfigServer().setPasscode(passcode);
        serviceLazyv.getConfigServer().setIsVisible(isVisible);
        return "OK";
    }

}
