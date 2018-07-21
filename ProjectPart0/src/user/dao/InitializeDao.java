package user.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InitializeDao 
{
	public void InitDB() throws IOException 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
					
			String URL = "jdbc:mysql://localhost:3306/sampledb";
			String USER = "john";
			String PASS = "pass1234";
			Connection connect = DriverManager.getConnection(URL, USER, PASS);
			
			String s = new String();
		    StringBuffer sb = new StringBuffer();
		    String path = "C:\\Users\\Justin\\eclipse-workspace\\userSQL.txt";
		    FileReader fr = new FileReader(new File(path));
		    BufferedReader br = new BufferedReader(fr);
		 
		            while((s = br.readLine()) != null)
		            {
		                sb.append(s);
		            }
		            br.close();

		            String[] arr = sb.toString().split(";");
		 
		            Statement st =  connect.createStatement();
		 
		            for(int i = 0; i<arr.length; i++)
		            {
		                if(!arr[i].trim().equals(""))
		                {
		                    st.executeUpdate(arr[i]);
		                    System.out.println(">>"+arr[i]);
		                }
		            }
				System.out.println("Created Tables"); 
				
				PreparedStatement preparedStatement = null;
				
				/*preparedStatement = connect
				          .prepareStatement("insert into  ProgramCommittee(PCID, PCName, PCNumAssigned) values (?, ?, ?)");
				      preparedStatement.setString(1, "1");
				      preparedStatement.setString(2, "Justin Roy");
				      preparedStatement.setString(3, "5");
				      preparedStatement.executeUpdate();
			*/
		}	catch(SQLException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/*
Statement statement = null;

statement = connect.createStatement();
statement.executeUpdate("DROP TABLE IF EXISTS Paper");
statement.executeUpdate("DROP TABLE IF EXISTS ProgramCommittee");
statement.executeUpdate("DROP TABLE IF EXISTS Review");

String sqlstmt = "CREATE TABLE IF NOT EXISTS Paper " +
               "(PapID INTEGER not NULL AUTO_INCREMENT, " +
               " PapAuthor VARCHAR(20), " + 
               " PapTitle VARCHAR(50), " + 
               " PapAbstract VARCHAR(10), " +
               " PapPDF VARCHAR(10), " +
               " PRIMARY KEY ( id ))"; 
 statement.executeUpdate(sqlstmt);
 
 sqlstmt = "CREATE TABLE IF NOT EXISTS ProgramCommittee " +
           "(PCID INTEGER not NULL AUTO_INCREMENT, " +
           " Name VARCHAR(20), " + 
           " Address VARCHAR(50), " + 
           " Status VARCHAR(10), " + 
           " PRIMARY KEY ( id ))"; 
 statement.executeUpdate(sqlstmt);
 
 sqlstmt = "CREATE TABLE IF NOT EXISTS ProgramCommittee " +
           "(id INTEGER not NULL AUTO_INCREMENT, " +
           " Name VARCHAR(20), " + 
           " Address VARCHAR(50), " + 
           " Status VARCHAR(10), " + 
           " PRIMARY KEY ( id ))"; 
 statement.executeUpdate(sqlstmt);
 
 sqlstmt = "ALTER TABLE ProgramCommittee " +
           "(id INTEGER not NULL AUTO_INCREMENT, " +
           " Name VARCHAR(20), " + 
           " Address VARCHAR(50), " + 
           " Status VARCHAR(10), " + 
           " PRIMARY KEY ( id ))"; 
 statement.executeUpdate(sqlstmt);
 */			
