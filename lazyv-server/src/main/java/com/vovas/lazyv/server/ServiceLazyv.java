package com.vovas.lazyv.server;

public class ServiceLazyv
{

  private ConfigServer configServer;

  public ServiceLazyv(ConfigServer configServer)
  {
    this.configServer=configServer;
  }

  public ConfigServer getConfigServer() {
    return configServer;
  }
}
