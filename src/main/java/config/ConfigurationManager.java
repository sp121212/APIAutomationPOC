package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import exp.ApiFrameWorkException;

public class ConfigurationManager {
	
	private Properties prop;
	private FileInputStream fis;
	
	public Properties initProp() {
		prop = new Properties();
		try {
			String envName = System.getProperty("env");
			System.out.println("env name: "+ envName);
			if(envName == null) {
				fis = new FileInputStream("./src/test/resources/config/qa-config.properties");
			}
			else {
				switch (envName.trim().toLowerCase()) {
				case "qa" :
					fis = new FileInputStream("./src/test/resources/config/qa-config.properties");
					break;
					
				case "stage" :
					fis = new FileInputStream("./src/test/resources/config/stage-config.properties");
					break;	
					
				case "dev" :
					fis = new FileInputStream("./src/test/resources/config/dev-config.properties");
					break;	
					
				case "prod" :
					fis = new FileInputStream("./src/test/resources/config/config.properties");
					break;	
				
				default :
					System.out.println("Please provide correct env qa, prod, stage or dev");
					throw new ApiFrameWorkException("Invalid env input : "+ envName);
				}
			}
			
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	} 

}
