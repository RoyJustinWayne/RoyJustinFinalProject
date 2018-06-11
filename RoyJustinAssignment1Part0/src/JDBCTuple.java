import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class JDBCTuple implements ActionListener 
{

public void main (String args[]) throws ClassNotFoundException 
{		
	JFrame guiFrame = new JFrame();	
	guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	guiFrame.setTitle("Database");
	guiFrame.setSize(300,250);
	final JPanel panel = new JPanel();
	JButton button = new JButton ("Init Database");
	button.addActionListener(this);
	panel.add(button);
}

@Override
	public void actionPerformed(ActionEvent e) 
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
	
		System.out.println("Attemptin to connect: ");
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
