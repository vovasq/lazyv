package com.vovas.lazyv.server;

import com.vovas.lazyv.server.executors.KeyExecutor;
import com.vovas.lazyv.server.executors.KeyExecutorMock;
import com.vovas.lazyv.server.request.KeyRequest;
import com.vovas.lazyv.server.request.UpdateConfigServerRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.SocketException;


@RestController
public class ServerController {

    private static final Logger LOG = Logger.getLogger(ServerController.class);

    private KeyExecutor keyExecutor = new KeyExecutorMock();
    private NativeEasyKeySender nativeKeyExecutor = new NativeEasyKeySender();

    @Autowired
    private ServiceLazyv serviceLazyv;

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
        if (request.getPasscode().equals(getConfigServer().getPasscode())
                && getConfigServer().getIsVisible()) {
            nativeKeyExecutor.sendEasyKey(request.getCode());
            return "OK";
        }else if(getConfigServer().getIsVisible()){
            LOG.warn("Wrong passcode or server is not visble" + request);
            return "WRONG CODE";
        }
        return "SERVER IS OFF";
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
    public String updateServerConfig(UpdateConfigServerRequest request) {
        serviceLazyv.getConfigServer().setHostName(request.getHostName());
        serviceLazyv.getConfigServer().setPasscode(request.getPasscode());
        serviceLazyv.getConfigServer().setIsVisible(request.isVisible());
        LOG.info("Update info with params: hostname = " + request);
        return "OK";
    }

    @GetMapping("info")
    public ConfigServer getServerInfo() throws SocketException {
        ConfigServer config = serviceLazyv.getConfigServer();
        config.setNetInterfaces(config.initNetInterfaces());
        return config;
//                new ServerInfoResponse(Util.getNetInterfaces(),config.getHostName(),config.getPasscode(),config.getServerState(),config.getPort());
    }

}
