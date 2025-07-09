package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.testng.annotations.Test;

public class TC012_ReadFromDB {
	
	//connection
	//statement
	//resultset
	
	@Test
	public void ReadFromDB() throws IOException {
		
		try {
			FileReader file = new FileReader("./src//test//resources//config.properties");
			Properties prop = new Properties();
			prop.load(file);
			String urlToLoad = prop.getProperty("appUrl");
			
			Connection con = DriverManager.getConnection(prop.getProperty("Host"),prop.getProperty("Databaseuser"),prop.getProperty("Databasepassword"));
			Statement stat = con.createStatement();
			
			String query = "select DISTINCT e.fname as emp_name, d.type as doc_type, e.email as emp_email, d.email as doc_email from Employee e left join document d on e.email = d.email";
			
			ResultSet rs = stat.executeQuery(query);
			
			while(rs.next()) {
				System.out.println(rs.getString("emp_name"));
				System.out.println(rs.getString("emp_email"));
				System.out.println(rs.getString("doc_type"));
				System.out.println(rs.getString("doc_email"));
			}
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
