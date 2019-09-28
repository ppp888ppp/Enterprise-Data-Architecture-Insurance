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
			String password = " "; //Deleted for uploading 
			
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
			String sql = "SELECT PRODUCT_NAME, DESCRIPTION FROM PRODUCT"; 
			
			/*
				Here, you can put any **sql** quries getting inquries based on the EER design provided with pdf file.
				For example,
				
				1.Print all the information from invoice table where the due date is august 10th. 
					SELECT *
					FROM INVOICE
					WHERE DUE_DATE = Aug.10th 

				2. Print customer ssn and billing code from invoice table where billing code is b234 and the paid date is Aug. 28th.
					SELECT CUSTOMER_CUSTOMER_SSN, BILLING_ACCOUNT_BILLING_CODE
					FROM INVOICE
					WHERE BILLING_ACCOUNT_BILLING_CODE = B234 AND PAID_DATE = ‘AUG 28’ 

				3.Print all customer’s name, invoice number, product name and the description where th customer’s zip code is 07301 
					SELECT C.FIRST_NAME, C.LAST_NAME, I.INVOICE_NUMBER, P.PRODUCT_NAME, P.DESCRIPTION
					FROM C.CUSTOMER, I.INVOICE, P.PRODUCT.NAME
					WHERE C.CUSTOMER_ZIP = 07301
			*/
	
			PreparedStatement statement = con.prepareStatement(sql);
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
