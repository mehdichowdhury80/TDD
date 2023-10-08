package utils;

import java.io.IOException;
import java.util.Properties;

import constant.KeyConfig;

public class ReadConfig {
	Properties properties;

	public ReadConfig() throws IOException {
		loadProperties();

	}

	public void loadProperties() throws IOException {
		properties = new Properties();
		properties.load(getClass().getClassLoader().getResourceAsStream("configaration.properties"));
	}

	public String getValue(KeyConfig key) {
		return properties.getProperty(key.toString());

	}

}
