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
		
		String PCIDMod = request.getParameter("PCIDMod");
		String PCNameMod = request.getParameter("PCNameMod");
		String PCNumAssignedMod = request.getParameter("PCNumAssignedMod");
		String PCEmailMod = request.getParameter("PCEmailMod");
		String PCAffiliationMod = request.getParameter("PCAffiliationMod");
		
		String PCIDDel = request.getParameter("PCIDDel");
		
		String PCNameAdd = request.getParameter("PCNameAdd");
		String PCNumAssignedAdd = request.getParameter("PCNumAssignedAdd");
		String PCEmailAdd = request.getParameter("PCEmailAdd");
		String PCAffiliationAdd = request.getParameter("PCAffiliationAdd");
		
		String PCIDAssignment = request.getParameter("PapIDAdd1");
		String Name1 = request.getParameter("PCNameAdd1");
		String Name2 = request.getParameter("PCNameAdd2");
		String Name3 = request.getParameter("PCNameAdd3");
				

	    if(request.getParameter("Update")!=null)
	    {
			UpdateFunctions x = new UpdateFunctions();
			x.updatePCMember(PCIDMod, PCNameMod, PCNumAssignedMod, PCEmailMod, PCAffiliationMod);
	    }
		
	    if(request.getParameter("Delete")!=null)
	    {
	    	UpdateFunctions y = new UpdateFunctions();
			y.deletePCMember(PCIDDel);
			System.out.println(PCIDDel);
	    }
	    
	    if(request.getParameter("Add")!=null)
	    {
	    	UpdateFunctions z = new UpdateFunctions();
			z.insertPCMember(PCNameAdd, PCNumAssignedAdd, PCEmailAdd, PCAffiliationAdd);
	    }
	    
	    if(request.getParameter("Assign")!=null)
	    {
	    	UpdateFunctions w = new UpdateFunctions();
			w.AssignPCMembers(PCIDAssignment, Name1, Name2, Name3);
	    }
	    request.getRequestDispatcher("/jsps/PCUpdate.jsp").forward(request, response);	
	}
}
