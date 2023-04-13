package controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Client;
import model.ClientDAO;
import model.Database;

/**
 * Servlet implementation class Login_redirect
 */
@WebServlet("/Login_redirect")
public class Login_redirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_redirect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database.Connect();
		String binscrir = request.getParameter("b_inscrir");
        Boolean messageInscriptionOk = false;

		if(binscrir != null  ) {
	  String nom = 	request.getParameter("nom");	
	  String prenom = 	request.getParameter("prenom");	
	  String tel = 	request.getParameter("tel");
	  String email = 	request.getParameter("email");	
	  String mot_de_passe = 	request.getParameter("mot_de_passe");	
	  ClientDAO cldao = new ClientDAO(); 
	  Client cl = new Client(nom, prenom,tel,email,mot_de_passe);

	  cldao.save(cl);
	  messageInscriptionOk = true;
	  System.out.println(cl);
			
		}
		
		
		String blogin = request.getParameter("l_log_in");
		 Boolean messageLogInNo = false;
		 Boolean connected = false;
		 

		 if(blogin != null) {
			 
		  String email = request.getParameter("l_email");
		  String pass = request.getParameter("l_mot_de_passe");
		  ClientDAO cldao = new ClientDAO(); 
		  Client cl = cldao.connexion(email, pass);
		  
		  if(cl == null) {
			  
			  System.out.println("CONNEXION NO");
			  messageLogInNo = true;
		  }else {
			  System.out.println("CONNEXION OK");
			  HttpSession session = request.getSession(true);
			  session.setAttribute("userId", cl.getId_client());
			  session.setAttribute("nom", cl.getNom());
			  session.setAttribute("isConnected", true);
			  
			  connected = true;
			
			  
			  response.sendRedirect("Valider_commande");
		  }
			 
			 
		 }
		 
		 request.setAttribute("messageLogInNo", messageLogInNo);
		 request.setAttribute("messageInscriptionOk", messageInscriptionOk);
	
		 if(connected == false) {
			 request.getRequestDispatcher("login_redirect.jsp").forward(request, response);
				
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
