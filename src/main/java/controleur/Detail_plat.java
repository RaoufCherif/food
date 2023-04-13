package controleur;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Client;
import model.ClientDAO;
import model.ComDAO;
import model.Commentaire;
import model.Database;
import model.Plat;
import model.PlatDAO;

/**
 * Servlet implementation class Detail_plat
 */
@WebServlet("/Detail_plat")
public class Detail_plat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Detail_plat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database.Connect();
		
		int id = Integer.valueOf(request.getParameter("id_plat"));
		
		ClientDAO  cldao = new ClientDAO();
		ArrayList<Client> collclient = cldao.getAll();
		PlatDAO pldao =new PlatDAO();
		Plat plat = pldao.getById(id);
		
	
		HttpSession session = request.getSession( true );

		ComDAO cdao = new ComDAO();
		ArrayList<Commentaire> comm = cdao.getAllByIdPlat(plat.getId_plat());
	
		
		if(request.getParameter("c_submit") !=null) {
			
			   int id_client =   (Integer)session.getAttribute("userId");
			   
				String nom = request.getParameter("c_nom");
				String email = request.getParameter("c_email");
				String message = request.getParameter("c_message");
				int rate = Integer.valueOf(request.getParameter("c_rate"));
				
			Commentaire commentaire = new 	Commentaire(message,rate,id_client,id);
			cdao.save(commentaire);
			
		}
		
		request.setAttribute("collclient", collclient);
		request.setAttribute("comm", comm);
		request.setAttribute("plat", plat);
		request.getRequestDispatcher("detail_plat.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
