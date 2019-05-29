package com.vovas.lazyv.server;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Field;

@SpringBootApplication
public class LazyvServerApplication {

	private static final Logger LOG = Logger.getLogger(LazyvApp.class);

	static {
		LOG.info("*************Starting LazyvApp************");
//		LOG.info("Current java.library.path" + System.getProperty("java.library.path"));
		Field fieldSysPath = null;
		try {
			fieldSysPath = ClassLoader.class.getDeclaredField( "sys_paths" );
			fieldSysPath.setAccessible(true);
			fieldSysPath.set(null, null);
			System.setProperty( "java.library.path", "./");
			System.loadLibrary("native");
			LOG.info("************* Succesfull importing of native libs ************");
//			LOG.info("After setting up java.library.path = " + System.getProperty("java.library.path"));
		} catch (Throwable e) {
			e.printStackTrace();
			LOG.error("Start was unsuccessful due to problems with native libs");
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(LazyvServerApplication.class, args);
	}

}
