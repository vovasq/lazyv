package com.vovas.lazyv.server.response;

import java.util.List;

public class ServerInfoResponse {
    private String hostName;
    private String passcode;
    private List<String> netInterfaces;
    private String serverState;
    private int port;

    public ServerInfoResponse(List<String> netInterfaces, String hostName, String passcode, String serverState, int port) {
        this.hostName = hostName;
        this.passcode = passcode;
        this.netInterfaces = netInterfaces;
        this.serverState = serverState;
        this.port = port;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public List<String> getNetInterfaces() {
        return netInterfaces;
    }

    public void setNetInterfaces(List<String> netInterfaces) {
        this.netInterfaces = netInterfaces;
    }

    public String getServerState() {
        return serverState;
    }

    public void setServerState(String serverState) {
        this.serverState = serverState;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
