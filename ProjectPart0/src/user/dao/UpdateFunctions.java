package user.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateFunctions
{	
	private java.sql.Connection connect;
	
	//For less bloated code.
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
	//For less bloated code.
	public void closeConnection()
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
	public void insertPaper(String PapTitle, String PapAbstract, String PapPDF, String PapAuthor, String PapAuthor2, String PapAccepted)
	{
		try
		{
			createConn();
			
			PreparedStatement preparedStatement = null;
			preparedStatement = connect
			          .prepareStatement("insert into  Paper (PapAuthor, PapAuthor2, PapTitle, PapAbstract, PapPDF, PapAccepted) values (?, ?, ?, ?, ?,?)");
			preparedStatement.setString(1, PapAuthor);
			preparedStatement.setString(2, PapAuthor2);
			preparedStatement.setString(3, PapTitle);
			preparedStatement.setString(4, PapAbstract);
			preparedStatement.setString(5, PapPDF);
			preparedStatement.setString(5, PapAccepted);
			preparedStatement.executeUpdate();	      
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		closeConnection();
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
		closeConnection();
	}
	
	public void updatePaper(String PapIDMod, String PapAuthorMod, String PapAuthor2Mod, String PapTitleMod, 
			String PapAbstractMod, String PapPDFMod, String PapAcceptedMod)
	{
		try
		{
			createConn();	
			PreparedStatement preparedStatement = null;
			
			preparedStatement = connect.prepareStatement(
		            "UPDATE Paper SET PapAuthor = ?, PapAuthor2 = ?, PapTitle = ?, PapAbstract = ?, PapPDF = ?, PapAccepted = ? WHERE PapID = ?");
			preparedStatement.setString(1, PapAuthorMod);
			preparedStatement.setString(2, PapAuthor2Mod);
			preparedStatement.setString(3, PapTitleMod);
			preparedStatement.setString(4, PapAbstractMod);
			preparedStatement.setString(5, PapPDFMod);
			preparedStatement.setString(6, PapAcceptedMod);
			preparedStatement.setString(7, PapIDMod);
			
			preparedStatement.executeUpdate();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
	}
	
	public void insertPCMember(String name, String assigned, String email, String affiliation)
	{
		try
		{
			createConn();
			
			PreparedStatement preparedStatement = null;
			preparedStatement = connect
			          .prepareStatement("insert into  ProgramCommittee (PCName, PCNumAssigned, PCEmail, PCAffiliation) values (?, ?, ?, ?)");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, assigned);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, affiliation);
			preparedStatement.executeUpdate();			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
	}
	
	public void deletePCMember(String PCIDDel)
	{
		try
		{	
			createConn();	
			PreparedStatement preparedStatement = null;
			
			preparedStatement = connect
			          .prepareStatement("DELETE FROM ProgramCommittee WHERE PCID = "+ PCIDDel);
			preparedStatement.executeUpdate();	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
	}
	
	public void updatePCMember(String PCID, String PCName, String PCNumAssigned, String PCEmail, String PCAffiliation)
	{
		try
		{	
			createConn();	
			PreparedStatement preparedStatement = null;
			
			preparedStatement = connect.prepareStatement(
		            "UPDATE ProgramCommittee SET PCName = ?, PCNumAssigned = ?, PCEmail = ?, PCAffiliation = ? WHERE PCID = ?");
			preparedStatement.setString(1, PCName);
			preparedStatement.setString(2, PCNumAssigned);
			preparedStatement.setString(3, PCEmail);
			preparedStatement.setString(4, PCAffiliation);
			preparedStatement.setString(5, PCID);
			preparedStatement.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
	}
	public void AssignPCMembers(String PapID, String Name1, String Name2, String Name3)
	{
		try
		{	
			createConn();	
			PreparedStatement preparedStatement = null;
			
			preparedStatement = 
					connect.prepareStatement("insert into  Assignments (PapIDAssign, PapAuthorAssign, PapAuthor2Assign, PapAuthor3Assign) values (?, ?, ?, ?)");
			preparedStatement.setString(1, PapID);
			preparedStatement.setString(2, Name1);
			preparedStatement.setString(3, Name2);
			preparedStatement.setString(4, Name3);
			preparedStatement.executeUpdate();			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
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
		closeConnection();
	}
	public void deleteReview(String RevIDDel)
	{
		try
		{
			createConn();	
			PreparedStatement preparedStatement = null;
			
			preparedStatement = connect
			          .prepareStatement("DELETE FROM Review WHERE RevID = "+ RevIDDel);
			preparedStatement.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
	}
	public void updateReview(String RevNameMod, String RevDescriptMod, String RevDecisionMod, 
			String RevDateMod, String PapIDMod, String RevIDMod)
	{
		try
		{
			createConn();	
			PreparedStatement preparedStatement = null;
			
			preparedStatement = connect.prepareStatement(
		            "UPDATE Review SET RevName = ?, RevDescript = ?, RevDecision = ?, RevDate = ?, PapID = ? WHERE RevID = ?");
			preparedStatement.setString(1, RevNameMod);
			preparedStatement.setString(2, RevDescriptMod);
			preparedStatement.setString(3, RevDecisionMod);
			preparedStatement.setString(4, RevDateMod);
			preparedStatement.setString(5, PapIDMod);
			preparedStatement.setString(6, RevIDMod);
			preparedStatement.executeUpdate();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		closeConnection();
	}	
}
