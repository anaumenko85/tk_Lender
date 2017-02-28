package com.example.java;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;



public class ConfigProperties {
	private static Properties TEST_PROPERTIES;

	static {
		TEST_PROPERTIES = new Properties();
		URL testUrl = ClassLoader.getSystemResource("Config.properties");

		try {
			TEST_PROPERTIES.load(testUrl.openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return TEST_PROPERTIES.getProperty(key);
	}

	public static int getWaitTime() {
		return Integer.parseInt(getProperty("imp.wait"));
	}
}
