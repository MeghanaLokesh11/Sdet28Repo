package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetTheDataFromPropertyFileTest {

	public static void main(String[] args) throws IOException {
		
		// java object representation of physical property file
		   FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
		   
		// create an object for properties class
		    Properties property = new Properties();
		    
		// load the key and value from the property file
		    property.load(fis);
		    
		// Fetch the values using respective Keys
		   String browser = property.getProperty("browser");
		   String url = property.getProperty("url");
		   String username = property.getProperty("username");
		   String password = property.getProperty("password");
		   
		// print the key values
		   System.out.println(browser);
		   System.out.println(url);
		   System.out.println(username);
		   System.out.println(password);

	}

}
