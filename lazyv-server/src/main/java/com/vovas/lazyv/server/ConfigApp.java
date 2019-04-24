//package com.vovas.lazyv.server;
//
//import com.vovas.lazyv.server.executors.KeyExecutor;
//import com.vovas.lazyv.server.executors.KeyExecutorMock;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ConfigApp
//{
//  @Bean
//  public ConfigServer configServer()
//  {
//    return new ConfigServer("VovasHost", "8777", "127.0.0.1","Started", "8777",true);
//  }
//
////  @Bean
////  public ServiceLazyv serviceLazyv(){
////
////    return new ServiceLazyv(
////            new ConfigServer("VovasHost", "8777", "127.0.0.1",
////                    "Started", "8777",true));
////  }
//
//  @Bean
//  public KeyExecutor keyExecutor(){
//    return new KeyExecutorMock();
//  }
//
//}
