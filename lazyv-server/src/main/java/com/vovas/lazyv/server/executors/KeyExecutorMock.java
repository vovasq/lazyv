package com.vovas.lazyv.server.executors;

import org.apache.log4j.Logger;

public class KeyExecutorMock implements KeyExecutor {
    private static final Logger LOG = Logger.getLogger(KeyExecutorMock.class);

    @Override
    public void pressKeyByCode(int code) {
        LOG.info("pressedKeyByCode with params: " + code);
    }
}
