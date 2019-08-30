package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class reads data from config property file
 */

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File src = new File("./config/config.properties");

		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is:" + e.getMessage());
		}

	}

	public String getApplicationURL() {
		String URL = pro.getProperty("baseURL");
		return URL;
	}

	public String getUsername() {
		String username = pro.getProperty("username");
		return username;
	}

	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}

	public String getfirefoxPath() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}

	public String getchromePath() {

		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

}
