package com.vovas.lazyv.server;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

class NetInterface{
  private String name;
  private String ip;

  public NetInterface(String name, String ip) {
    this.name = name;
    this.ip = ip;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

public class ConfigServer
{
  private String hostName;
  private String passcode;
  private List<NetInterface> netInterfaces;
  private String serverState;
  private int port;
  private boolean isVisible;

  public ConfigServer(String hostName, String passcode, String serverState, int port, boolean isVisible) throws SocketException {
    this.hostName=hostName;
    this.passcode=passcode;
    this.netInterfaces=initNetInterfaces();
    this.serverState=serverState;
    this.port=port;
    this.isVisible=isVisible;
  }

  public  List<NetInterface> initNetInterfaces() throws SocketException {
    Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
    List<NetInterface> res = new ArrayList<>();
    for (NetworkInterface netint : Collections.list(nets)) {
      Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
      for (InetAddress inetAddress : Collections.list(inetAddresses)) {
        if (inetAddress.isSiteLocalAddress() && !inetAddress.isLoopbackAddress()) {
          res.add(new NetInterface(netint.getDisplayName(), inetAddress.toString().replace("/", "")));
        } else {
          continue;
        }
      }
    }
    return res;
  }

  public String getHostName()
  {
    return hostName;
  }

  public void setHostName(String hostName)
  {
    if(hostName != null)
      this.hostName=hostName;
  }

  public String getPasscode()
  {
    return passcode;
  }

  public void setPasscode(String passcode)
  {
    if(passcode != null)
      this.passcode=passcode;
  }

  public List<NetInterface> getNetInterfaces()
  {
    return netInterfaces;
  }

  public void setNetInterfaces(List<NetInterface> netInterface)
  {
    this.netInterfaces=netInterfaces;
  }

  public String getServerState()
  {
    return serverState;
  }

  public void setServerState(String serverState)
  {
    this.serverState=serverState;
  }

  public int getPort()
  {
    return port;
  }

  public void setPort(int port)
  {
    this.port=port;
  }

  public boolean getIsVisible()
  {
    return isVisible;
  }

  public void setIsVisible(boolean isVisible)
  {
    this.isVisible=isVisible;
  }

  @Override public String toString()
  {
    return "Config{" +
        "hostName='" + hostName + '\'' +
        ", passcode='" + passcode + '\'' +
        ", netInterfaces='" + netInterfaces.toString() + '\'' +
        ", serverState='" + serverState + '\'' +
        ", port='" + port + '\'' +
        ", isVisible='" + isVisible + '\'' +
        '}';
  }
}
