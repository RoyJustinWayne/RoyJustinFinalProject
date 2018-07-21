package user.web.servlet;

import user.dao.UpdateFunctions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaperServ extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaperServ() 
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
		String PapID = request.getParameter("PapID");
		String PapAuthor = request.getParameter("PapAuthor");
		String PapAuthor2 = request.getParameter("PapAuthor2");
		String PapTitle = request.getParameter("PapTitle");
		String PapAbstract = request.getParameter("PapAbstract");
		String PapPDF = request.getParameter("PapPDF");
		
		String PapAuthorAdd = request.getParameter("PapAuthorAdd");
		String PapAuthor2Add = request.getParameter("PapAuthor2Add");
		String PapTitleAdd = request.getParameter("PapTitleAdd");
		String PapAbstractAdd = request.getParameter("PapAbstractAdd");
		String PapPDFAdd = request.getParameter("PapPDFAdd");

	    if(request.getParameter("Update")!=null)
	    {
			UpdateFunctions x = new UpdateFunctions();
			x.updatePaper(PapID, PapAuthor,PapAuthor2,PapTitle,PapAbstract,PapPDF);
	    }
		
	    if(request.getParameter("Delete")!=null)
	    {
	    	UpdateFunctions y = new UpdateFunctions();
			y.deletePaper(PapID);
	    }
	    
	    if(request.getParameter("Add")!=null)
	    {
	    	UpdateFunctions z = new UpdateFunctions();
			z.insertPaper(PapTitleAdd, PapAbstractAdd, PapPDFAdd, PapAuthorAdd, PapAuthor2Add);
	    }
	    request.getRequestDispatcher("/jsps/PaperUpdate.jsp").forward(request, response);	
	}
}
