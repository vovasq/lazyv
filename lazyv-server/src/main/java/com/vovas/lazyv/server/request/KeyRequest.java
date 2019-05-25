package com.vovas.lazyv.server.request;

public class KeyRequest {
    private int code;
    private String passcode;

    public KeyRequest(int code, String passcode) {
        this.code = code;
        this.passcode = passcode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    @Override
    public String toString() {
        return "KeyRequest{" +
                "code=" + code +
                ", passcode='" + passcode + '\'' +
                '}';
    }
}
