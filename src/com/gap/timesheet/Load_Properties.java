package com.gap.timesheet;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

public class Load_Properties {

	public static Properties readpropertiesfile(String filepath) throws Exception {
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		if(filepath.contains("log4j"))
			PropertyConfigurator.configure(prop);
		return prop;

	}

}
