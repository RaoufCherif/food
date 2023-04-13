package controleur;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Boisson;
import model.BoissonDAO;
import model.Database;
import model.PanierDetails;
import model.Plat;
import model.PlatDAO;
import model.Panier;

/**
 * Servlet implementation class Singl_plat
 */
@WebServlet("/Single_plat")
public class Single_plat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Single_plat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database.Connect();
		int id = Integer.valueOf(request.getParameter("id_plat"));

		PlatDAO pldao =new PlatDAO();
		Plat plat = pldao.getById(id);
		ArrayList<Plat>  platByType =  pldao.getByAllIdType(plat.getId_type());
		
		if(request.getParameter("add") !=null ) {
			HttpSession session = request.getSession(true);
			
			int qte = Integer.valueOf( request.getParameter("quantity"));
			
			PanierDetails panieradd = new PanierDetails( plat, qte);
		
			Panier panier = (Panier)session.getAttribute("panier");
			
			 panier.ajouter(panieradd);
			 session.setAttribute("panier", panier);
		
		}
		
	
		
		request.setAttribute("platByType", platByType);
		request.setAttribute("plat", plat);
		request.getRequestDispatcher("single_plat.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
