package user.web.servlet;
import user.dao.UpdateFunctions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReviewServ extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServ() 
    {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		String RevID = request.getParameter("RevID");
		String RevName = request.getParameter("RevName");
		String RevDescript = request.getParameter("RevDescript");
		String RevDecision = request.getParameter("RevDecision");
		String RevDate = request.getParameter("RevDate");
		String PapID = request.getParameter("PapID");
		
		String RevNameAdd = request.getParameter("RevNameAdd");
		String RevDescriptAdd = request.getParameter("RevDescriptAdd");
		String RevDecisionAdd = request.getParameter("RevDecisionAdd");
		String RevDateAdd = request.getParameter("RevDateAdd");
		String PapIDAdd = request.getParameter("PapIDAdd");

	    if(request.getParameter("Update")!=null)
	    {
			UpdateFunctions x = new UpdateFunctions();
			x.updateReview(RevID, RevName, RevDescript, RevDecision, RevDate, PapID);
	    }
		
	    if(request.getParameter("Delete")!=null)
	    {
	    	UpdateFunctions y = new UpdateFunctions();
			y.deleteReview(RevID);
	    }
	    
	    if(request.getParameter("Add")!=null)
	    {
	    	UpdateFunctions z = new UpdateFunctions();
			z.insertReview(RevNameAdd, RevDescriptAdd, PapIDAdd, RevDecisionAdd, RevDateAdd);
	    }
	    request.getRequestDispatcher("/jsps/ReviewUpdate.jsp").forward(request, response);	
	}
}
