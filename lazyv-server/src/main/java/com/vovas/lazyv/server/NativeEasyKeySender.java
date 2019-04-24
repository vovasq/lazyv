package com.vovas.lazyv.server;


public class NativeEasyKeySender {

//    public boolean isKeyNumberOk(int key){
//        return key < 7 && key > -1;
//    }

//    TODO: make public and move to executors package with interface
    native void sendEasyKey(int key);
    native void sendChar(char key);
}
