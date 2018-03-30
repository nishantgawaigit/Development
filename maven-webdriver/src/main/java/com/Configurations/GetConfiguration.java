package com.Configurations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class GetConfiguration {
	static Properties prop;

	public GetConfiguration() {
		File src = new File(System.getProperty("user.dir")+"//Configuration//Project.property");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(src);
			prop = new Properties();
			//prop.setProperty("base.dir",System.getProperty("user.dir"));
			prop.put("base.dir",System.getProperty("user.dir"));
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
			e.printStackTrace();
		}

	}
	
	public static void getProperty(){
			System.out.println(prop.getProperty("chromeDriver"));
			System.out.println(prop.getProperty("base.dir"));
	}

	public static void main(String args[]){
		GetConfiguration con=new GetConfiguration();
		con.getProperty();
		
		
	}
	
}
