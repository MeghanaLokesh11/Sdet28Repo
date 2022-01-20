package com.crm.comcast.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * @author Meghana L
 *
 */

public class FileUtility {
	/**
	 * This method will fetch the data from the property file based on the key passed
	 * @param Key
	 * @return
	 * @throws Throwable 
	 */
	
	public String getPropertyFileData(String Key) throws Throwable {
		FileInputStream file = new FileInputStream(IPathCanstant.PROPERTYFILEPATH);
		Properties property = new Properties();
		property.load(file);
		return property.getProperty(Key);
	}

}
