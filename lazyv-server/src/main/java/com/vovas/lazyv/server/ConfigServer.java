package com.vovas.lazyv.server;

public class ConfigServer
{
  private String hostName;
  private String passcode;
  private String ip;
  private String serverState;
  private String port;
  private boolean isVisible;

  public ConfigServer(String hostName, String passcode, String ip, String serverState, String port, boolean isVisible)
  {
    this.hostName=hostName;
    this.passcode=passcode;
    this.ip=ip;
    this.serverState=serverState;
    this.port=port;
    this.isVisible=isVisible;
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

  public String getIp()
  {
    return ip;
  }

  public void setIp(String ip)
  {
    this.ip=ip;
  }

  public String getServerState()
  {
    return serverState;
  }

  public void setServerState(String serverState)
  {
    this.serverState=serverState;
  }

  public String getPort()
  {
    return port;
  }

  public void setPort(String port)
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
        ", ip='" + ip + '\'' +
        ", serverState='" + serverState + '\'' +
        ", port='" + port + '\'' +
        ", isVisible='" + isVisible + '\'' +
        '}';
  }
}
