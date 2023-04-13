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
import model.Panier;
import model.PanierDetails;
import model.PanierDetails_boisson;
import model.Panier_boisson;


/**
 * Servlet implementation class Single_boisson
 */
@WebServlet("/Single_boisson")
public class Single_boisson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Single_boisson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database.Connect();
		int id_boisson = Integer.valueOf(request.getParameter("id_boisson"));
		
		BoissonDAO bdao = new BoissonDAO();
		Boisson boisson = bdao.getById(id_boisson);
		System.out.println(boisson);
		ArrayList<Boisson>  collboi =  bdao.getAll();
		
		if(request.getParameter("add_boisson") !=null ) {
			HttpSession session = request.getSession(true);
			
			int qte = Integer.valueOf( request.getParameter("quantity_boisson"));

			 PanierDetails_boisson	panieradd = new PanierDetails_boisson( boisson, qte);
			Panier_boisson panier_boisson = (Panier_boisson)session.getAttribute("panier_boisson");
			panier_boisson.ajouterBoisson(panieradd);
			 session.setAttribute("panier_boisson", panier_boisson);
		
		}
		request.setAttribute("collboi", collboi);
		request.setAttribute("boisson", boisson);
		request.getRequestDispatcher("single_boisson.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
