package com.crm.comcast.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


import com.mysql.cj.jdbc.Driver;

/**
 *
 * @author Meghana
 *
 */

public class DataUtility {
	Connection connection=null;
	
	/**
	 * This Method will do the connection to database
	 * @throws Throwable
	 */
	
	public void connectToDB() throws Throwable {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "root");
	}
	/**
	 * This Method will close the  database connection
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable
	{
		connection.close();
	}
	/**
	 * Method will fetch all the data from the database
	 * @param querry
	 * @return
	 * @throws Throwable
	 */
	public ResultSet getAllData(String querry) throws Throwable {
		ResultSet result = connection.createStatement().executeQuery(querry);
		return result;
	}
	/**
	 * Method will update the data in database and it will verify
	 * @param querry
	 * @return
	 * @throws Throwable
	 */
	
	public boolean  updateData(String querry) throws Throwable {
		boolean flag=false;
		int result =connection.createStatement().executeUpdate(querry);
		if(result==1) {
			System.out.println("data is updated in database");
		}else {
			System.out.println("data is not updated in database");
		}
		return flag;
	}
	/**
	 * This Method will verify the given data is present in the database or not 
	 * @param querry
	 * @param columnNumber
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */
	public String getTheData(String querry,int columnNumber,String expectedData) throws Throwable {
		boolean flag=false;
		String actualData=null;
		ResultSet result = connection.createStatement().executeQuery(querry);
		while(result.next()) {
			String data =result.getString(columnNumber);
			if(data.equals(expectedData)) {
				actualData=data;
				flag=true;
				break;
			}
		}
		if(flag==true) {
			System.out.println("Data is present in the database");
			return actualData;
		}else {
			System.out.println("Data is not  present in the database");
			return actualData;
			
		}
	}
}
