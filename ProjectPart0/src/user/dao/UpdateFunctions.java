package user.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateFunctions
{	
	private java.sql.Connection connect;
	
	public void createConn()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String URL = "jdbc:mysql://localhost:3306/sampledb";
			String USER = "john";
			String PASS = "pass1234";
			connect = DriverManager.getConnection(URL, USER, PASS);
		} 
		catch (Exception e)
		{
			System.out.print(e);
		}
	}
	public void endConn()
	{
		try
		{
			connect.close();
		} 
		catch (SQLException e)
		{
			System.out.print(e);
		}
	}
	public void insertPaper(String PapTitle, String PapAbstract, String PapPDF, String PapAuthor, String PapAuthor2)
	{
		try
		{
			createConn();
			
			PreparedStatement preparedStatement = null;
			preparedStatement = connect
			          .prepareStatement("insert into  Paper (PapAuthor, PapAuthor2, PapTitle, PapAbstract, PapPDF) values (?, ?, ?, ?, ?)");
				  preparedStatement.setString(1, PapAuthor);
				  preparedStatement.setString(2, PapAuthor2);
				  preparedStatement.setString(3, PapTitle);
				  preparedStatement.setString(4, PapAbstract);
				  preparedStatement.setString(5, PapPDF);
			      preparedStatement.executeUpdate();	      
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		endConn();
	}
	public void deletePaper(String PapID)
	{
		try
		{
			createConn();
			
			PreparedStatement preparedStatement = null;
			preparedStatement = connect
			          .prepareStatement("DELETE FROM Paper WHERE PapID = "+ PapID);
			      preparedStatement.executeUpdate();
		}
		catch (Exception e)
		{
			System.out.print(e);
		}
		endConn();
	}
	
	public void updatePaper(String PapID, String PapAuthor, String PapAuthor2, String PapTitle, 
			String PapAbstract, String PapPDF)
	{
		try
		{
			createConn();	
			PreparedStatement preparedStatement = null;
			
			preparedStatement = connect.prepareStatement(
		            "UPDATE Paper SET PapAuthor = ?, PapAuthor2 = ?, PapTitle = ?, PapAbstract = ?, PapPDF = ? WHERE PapID = ?");
			preparedStatement.setString(1, PapAuthor);
			preparedStatement.setString(2, PapAuthor2);
			preparedStatement.setString(3, PapTitle);
			preparedStatement.setString(4, PapAbstract);
			preparedStatement.setString(5, PapPDF);
			preparedStatement.setString(6, PapID);
			
			preparedStatement.executeUpdate();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		endConn();
	}
	
	public void insertPCMember(String name, String assigned)
	{
		try
		{
			createConn();
			
			PreparedStatement preparedStatement = null;
			preparedStatement = connect
			          .prepareStatement("insert into  ProgramCommittee (PCName, PCNumAssigned) values (?, ?)");
				  preparedStatement.setString(1, name);
			      preparedStatement.setString(2, assigned);
			      preparedStatement.executeUpdate();			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		endConn();
	}
	
	public void deletePCMember(String PCID)
	{
		try
		{	
			createConn();	
			PreparedStatement preparedStatement = null;
			
			preparedStatement = connect
			          .prepareStatement("DELETE FROM ProgramCommittee WHERE PCID = "+ PCID);
			      preparedStatement.executeUpdate();			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		endConn();
	}
	
	public void updatePCMember(String PCID, String name, String numAssigned)
	{
		try
		{	
			createConn();	
			PreparedStatement preparedStatement = null;
			
			preparedStatement = connect.prepareStatement(
		            "UPDATE ProgramCommittee SET PCName = ?, PCNumAssigned = ? WHERE PCID = ?");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, numAssigned);
			preparedStatement.setString(3, PCID);
			      preparedStatement.executeUpdate();			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		endConn();
	}
	
	public void insertReview(String RevName, String RevDescript, String PapID, String RevDecision, String RevDate)
	{
		try
		{
			createConn();
			
			PreparedStatement preparedStatement = null;
			preparedStatement = connect
			          .prepareStatement("insert into  Review (RevName, RevDescript, RevDecision, RevDate, PapID) values (?, ?, ?, ?, ?)");
				  preparedStatement.setString(1, RevName);
			      preparedStatement.setString(2, RevDescript);
			      preparedStatement.setString(3, RevDecision);
			      preparedStatement.setString(4, RevDate);
			      preparedStatement.setString(5, PapID);
			      preparedStatement.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		endConn();
	}
	public void deleteReview(String RevID)
	{
		try
		{
			createConn();	
			PreparedStatement preparedStatement = null;
			
			preparedStatement = connect
			          .prepareStatement("DELETE FROM Review WHERE RevID = "+ RevID);
			      preparedStatement.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		endConn();
	}
	public void updateReview(String RevID, String RevName, String RevDescript, String RevDecision, 
			String RevDate, String PapID)
	{
		try
		{
			createConn();	
			PreparedStatement preparedStatement = null;
			
			preparedStatement = connect.prepareStatement(
		            "UPDATE Review SET RevName = ?, RevDescript = ?, RevDecision = ?, RevDate = ?, PapID = ? WHERE RevID = ?");
			preparedStatement.setString(1, RevName);
			preparedStatement.setString(2, RevDescript);
			preparedStatement.setString(3, RevDecision);
			preparedStatement.setString(4, RevDate);
			preparedStatement.setString(5, PapID);
			preparedStatement.setString(6, RevID);		
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		endConn();
	}	
}
