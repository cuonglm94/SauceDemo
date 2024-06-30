package common;

import java.util.Properties;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Configuration {
	String configFilePath;
	
	
	public Configuration(String configFilePathInput) {
		this.configFilePath = configFilePathInput;
	}
	
	public String getConfigValueByKey(String key) {
		String value="";
		Properties config = new Properties();
		Reader reader;
		try {
			reader = new FileReader(configFilePath);
			config.load(reader);
			value=config.getProperty(key);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return value;
	}
	
	

}
