package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList; 

public class main 
{
	public static void main(String[]args) throws Exception
	{
		 getConnection(); // to connect to the database
		 insert(); // insert the data into the database
		 getQuote(); // get the quote for the client 
	}
	
	public static Connection getConnection() throws Exception 
	{
		try
		{
			String driver = "com.mysql.jdbc.Driver"; 
			String url = "jdbc:mysql://localhost:3306/mydb";
			String userName = "root";
			String password = " "; Deleted for uploading 
			
			Class.forName(driver); 
			
			Connection conn = DriverManager.getConnection(url, userName, password); 
			System.out.println("Connected");
			return conn;
		}
		catch(Exception e)
		{
			System.out.println(e); 
		}
		
		return null;
	}
	
	public static void insert() throws Exception
	{
		try
		{
			Connection con = getConnection();
			String sql = "INSERT INTO PRODUCT (PRODUCT_NAME, DESCRIPTION) VALUES ('A', 'HEALTH')"; 
			PreparedStatement inserted = con.prepareStatement(sql);
			inserted.executeUpdate(); 

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void getQuote() throws Exception
	{
		try
		{
			Connection con = getConnection(); 
			PreparedStatement statement = con.prepareStatement("SELECT PRODUCT_NAME, DESCRIPTION FROM PRODUCT");
			ResultSet result = statement.executeQuery(); 
		
			while(result.next())
			{
				System.out.print(result.getString("PRODUCT_NAME")); 
				System.out.print(" ");
				System.out.println(result.getString("DESCRIPTION")); 
				System.out.print(" ");
			}			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
