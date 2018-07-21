package user.web.servlet;

import user.dao.UpdateFunctions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServ extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServ() 
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
		
		String PCID = request.getParameter("PCID");
		String PCName = request.getParameter("PCName");
		String PCNumAssigned = request.getParameter("PCNumAssigned");
		
		String PCNameAdd = request.getParameter("PCNameAdd");
		String PCNumAssignedAdd = request.getParameter("PCNumAssignedAdd");

	    if(request.getParameter("Update")!=null)
	    {
			UpdateFunctions x = new UpdateFunctions();
			x.updatePCMember(PCID, PCName, PCNumAssigned);
	    }
		
	    if(request.getParameter("Delete")!=null)
	    {
	    	UpdateFunctions y = new UpdateFunctions();
			y.deletePCMember(PCID);
	    }
	    
	    if(request.getParameter("Add")!=null)
	    {
	    	UpdateFunctions z = new UpdateFunctions();
			z.insertPCMember(PCNameAdd, PCNumAssignedAdd);
	    }
	    request.getRequestDispatcher("/jsps/PCUpdate.jsp").forward(request, response);	
	}
}
