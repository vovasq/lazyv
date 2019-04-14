package com.vovas.lazyv.server;


import com.vovas.lazyv.server.NativeEasyKeySender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

    private NativeEasyKeySender keySender = new NativeEasyKeySender();

    @GetMapping("checkparam")
    public String aliveWithParam(@RequestParam String id) {
        return "Your id = " + id;
    }

    @GetMapping("f5")
    public String aliveString() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        keySender.sendEasyKey(2);
        return "It is alive!!!";
    }
}
