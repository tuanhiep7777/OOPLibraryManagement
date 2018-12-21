package dal;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class KetNoi {

	public static Connection con;
	private static String driver, url, user, password, connectionURL;
	
	private static void readPropertiesFile() {
		
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream("LogIn_Info.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = pro.getProperty("driver");
		url = pro.getProperty("url");
		user = pro.getProperty("user");
		password = pro.getProperty("password");
		
		// connection string 
		connectionURL = url + ";user=" + user + ";password=" + password;
	}
	
	public static Connection getConnect() throws ClassNotFoundException, SQLException {
		
		readPropertiesFile();
		Class.forName(driver);
		con = DriverManager.getConnection(connectionURL);
		return con;
	}
}
