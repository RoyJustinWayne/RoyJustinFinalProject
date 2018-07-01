package user.web.servlet;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.*;
import javax.servlet.http.*;

import user.dao.InitializeDao;


public class ConfManagement extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	 {
		InitializeDao newObj = new InitializeDao();
		newObj.InitDB();
	 }
}

