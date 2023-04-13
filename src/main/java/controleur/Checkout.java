package controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Database;
import model.Panier_boisson;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	Database.Connect();
	HttpSession session = request.getSession(true); // creation de session
	Panier paniers=(Panier)session.getAttribute("paniers");
	Panier_boisson panier_boisson=(Panier_boisson)session.getAttribute("panier_boisson");
	
	if(request.getParameter("valider") !=null) {
		String date_livraison = request.getParameter("date_livraison");
		request.setAttribute("date_livraison", date_livraison);
		session.setAttribute("panier_boisson",panier_boisson);
		session.setAttribute("paniers",paniers);
		System.out.println(date_livraison);
	}
	
	
		request.getRequestDispatcher("checkout.jsp").forward(request, response);

	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
