package com.vovas.lazyv.server;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;

public class LazyvApp {

    private static final Logger LOG = Logger.getLogger(LazyvApp.class);

    static {
        LOG.info("*************Starting LazyvApp************");
        LOG.info("Current java.library.path" + System.getProperty("java.library.path"));
        Field fieldSysPath = null;
        try {
            fieldSysPath = ClassLoader.class.getDeclaredField( "sys_paths" );
            fieldSysPath.setAccessible(true);
            fieldSysPath.set(null, null);
            System.setProperty( "java.library.path", "./");
            System.loadLibrary("native");
            LOG.info("After setting up java.library.path = " + System.getProperty("java.library.path"));
        } catch (Throwable e) {
            e.printStackTrace();
            LOG.error("Start was unsuccessful due to problems with native libs");
        }
    }

    public static void main(String[] args) {
        LOG.info("Let's invoke some native methods!");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NativeEasyKeySender sender = new NativeEasyKeySender();
        sender.sendEasyKey(2);

        sender.sendChar('v');
        sender.sendChar('o');
        sender.sendChar('v');
        sender.sendChar('a');
        sender.sendChar('s');
    }
}
