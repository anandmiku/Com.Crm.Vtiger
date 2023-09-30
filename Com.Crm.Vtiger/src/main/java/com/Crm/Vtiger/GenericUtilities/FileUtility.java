package com.Crm.Vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of generic method to fetch the data from property file
 * @author Ananda
 *
 */

public class FileUtility
{
	/**
	 * this method helps us to fetch he data from property file
	 * @Ananda
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String getDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.propertyfilepath);
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}

}
