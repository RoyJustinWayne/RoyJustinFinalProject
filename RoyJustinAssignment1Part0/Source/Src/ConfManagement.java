package Src;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.*;



public class ConfManagement extends HttpServlet
{

	private static final long serialVersionUID = 1L;
	public void main (String args[]) throws ClassNotFoundException 
	{		
	}
	
	 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	 {
		ConfManagement myClass = new ConfManagement();
		myClass.post();
	 }
	
	public void post()
	{
	final String JDBC_DRIVER= "com.mysql.jdbc.Driver";
	final String DB_URL="jdbc:mysql://localhost/sampledb";
	final String User="john";
	final String Pass="pass1234";
	Connection conn=null;
	Statement stmt=null;
	
	try
		{
		Class.forName(JDBC_DRIVER);
	
		System.out.println("Attempting to connect: ");
		conn = DriverManager.getConnection(DB_URL,User, Pass);
	
		System.out.println("Connection Successful");
	
		stmt=conn.createStatement();
		//Fix this to read the SQL file and execute like this.
		
		//String sql="create table registration"+"(id INTEGER not null,"+"first VARCHAR(255),"+"last VARCHAR(255),"
		//+"age INTEGER,"+"PRIMARY KEY(I'd))";
	
		//stmt.executeUpdate(sql);
	
		System.out.println("creating table in dB");
		}
	
		catch(SQLException se)
	
		{} // Do nothing
	 	catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
		try
		{
		}
			finally
			{
				try
				{
					if(stmt!=null) conn.close();
				}
				
				catch(SQLException se)
				{ 
					se.printStackTrace();
				}
			}
	}
}

