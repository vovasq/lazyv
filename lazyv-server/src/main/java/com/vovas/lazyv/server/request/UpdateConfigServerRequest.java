package com.vovas.lazyv.server.request;

public class UpdateConfigServerRequest {
    private final String hostName;
    private final String passcode;
    private final boolean isVisible;

    public UpdateConfigServerRequest(String hostName, String passcode, boolean isVisible) {
        this.hostName = hostName;
        this.passcode = passcode;
        this.isVisible = isVisible;
    }

    public String getHostName() {
        return hostName;
    }

    public String getPasscode() {
        return passcode;
    }

    public boolean isVisible() {
        return isVisible;
    }

    @Override
    public String toString() {
        return "UpdateConfigServerRequest{" +
                "hostName='" + hostName + '\'' +
                ", passcode='" + passcode + '\'' +
                ", isVisible=" + isVisible +
                '}';
    }
}
