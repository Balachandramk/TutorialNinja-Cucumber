package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	public Properties initializeProperties() {
		
		Properties configProp = new Properties();
		File configPropPath = new File(
				System.getProperty("user.dir") + "\\src\\test\\resources\\config\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(configPropPath);
			configProp.load(fis);
		} catch (Throwable t) {
			t.printStackTrace();
		}

		return configProp;
	}

}
