package controleur;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Commande;
import model.CommandeDAO;
import model.Commande_details;
import model.Commande_details_boisson;
import model.Commande_details_boissonDAO2;
import model.Commande_detailsDAO;
import model.Database;
import model.Panier;
import model.PanierDetails;
import model.PanierDetails_boisson;
import model.Panier_boisson;

/**
 * Servlet implementation class Valider_commande
 */
@WebServlet("/Valider_commande")
public class Valider_commande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Valider_commande() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	Database.Connect();
	
	Date date = new Date();
	
	System.out.println(date);
	
  String comdate = new SimpleDateFormat("yyyy-MM-dd").format(date);
	String payer= request.getParameter("payement") ;

	
		if(payer !=null) {
		
			String date_liv = request.getParameter("date_livraison");
		
			HttpSession session = request.getSession(true); 
			int id_client= (int)session.getAttribute("userId");	
		 	System.out.println("je suis le parameter payment = " +payer);
		 	Commande_details_boissonDAO2 comboidao = new Commande_details_boissonDAO2();
		 	CommandeDAO commandedao=new CommandeDAO();
			
			Commande commande=new Commande(comdate,date_liv, id_client);
		     int idCom = commandedao.save(commande);
		     	
		
			Commande_detailsDAO cdetail = new Commande_detailsDAO();
			
			Panier panier=(Panier)session.getAttribute("panier");
			Panier_boisson panier_boisson=(Panier_boisson)session.getAttribute("panier_boisson");
			//long millis = System.currentTimeMillis();
			
			for(PanierDetails pd:panier.articles) {
			int id_plat = pd.getPlat().getId_plat();
			int qte = pd.getQte();
		
			System.out.println(id_plat+ " id plat " + qte+ " qte " + idCom +" id commande");
			Commande_details comd = new Commande_details(id_plat, qte, idCom);
			 cdetail.save(comd); 
				System.out.println(comd);
			}

			for(PanierDetails_boisson pdb:panier_boisson.articles) {
				int id_boi = pdb.getBoisson().getId_boisson();
				int qteb = pdb.getQte();
				Commande_details_boisson comd = new Commande_details_boisson(id_boi, qteb, idCom);
				comboidao.save(comd);	
			}
			
			panier.vider();
			panier_boisson.vider();
			session.setAttribute("panier",panier);
			session.setAttribute("panier_boisson",panier_boisson);
			response.sendRedirect("Payement_valider"); 
		}
		
		else {
		
		request.getRequestDispatcher("checkout.jsp").forward(request, response);
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
