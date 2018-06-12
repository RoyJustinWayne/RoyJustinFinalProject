package Src;

import java.io.*;
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
	
	public void post() throws IOException
	{
		
	final String JDBC_DRIVER= "com.mysql.jdbc.Driver";
	final String DB_URL="jdbc:mysql://localhost/sampledb";
	final String User="john";
	final String Pass="pass1234";
	Connection conn=null;
	Statement stmt=null;
	
	String s = new String();
    StringBuffer sb = new StringBuffer();
        try
        {
            FileReader fr = new FileReader(new File("user.sql"));
 
            BufferedReader br = new BufferedReader(fr);
 
            while((s = br.readLine()) != null)
            {
                sb.append(s);
            }
            br.close();

            String[] arr = sb.toString().split(";");
 
            Class.forName(JDBC_DRIVER);
    		conn = DriverManager.getConnection(DB_URL,User, Pass);
            Statement st =  conn.createStatement();
 
            for(int i = 0; i<arr.length; i++)
            {
                if(!arr[i].trim().equals(""))
                {
                    st.executeUpdate(arr[i]);
                    System.out.println(">>"+arr[i]);
                }
            }
		System.out.println("Created Tables");
		}
	
		catch(SQLException se)
		{}
	 	catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
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

