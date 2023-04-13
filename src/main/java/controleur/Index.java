package controleur;

import java.awt.Window.Type;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AvisDAO;
import model.Client;
import model.ClientDAO;
import model.Database;
import model.Plat;
import model.PlatDAO;
import model.TypeDAO;
import model.TypePlat;
import model.Avis;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Database.Connect();
	    
		ClientDAO  cldao = new ClientDAO();
		ArrayList<Client> collclient = cldao.getAll();
		
		AvisDAO avdao = new AvisDAO();
		
		ArrayList<Avis> collavis =  avdao.getAll();

	    Client client = cldao.getById(1);

		PlatDAO pldao = new PlatDAO();
		ArrayList<Plat> collplat = pldao.getAll();
		ArrayList<Plat> collplatEnt = pldao.getByAllIdType(1);
		ArrayList<Plat> collplatMain = pldao.getByAllIdType(2);
		ArrayList<Plat> collplatDes = pldao.getByAllIdType(3);
		TypeDAO typedao = new TypeDAO();
		
		ArrayList<TypePlat> colltype = typedao.getAll();
		
		request.setAttribute("collplatDes", collplatDes );
		request.setAttribute("collplatMain", collplatMain );
		request.setAttribute("collplatEnt", collplatEnt );
		request.setAttribute("colltype", colltype );
		request.setAttribute("collclient", collclient );
		request.setAttribute("collplat", collplat );
		request.setAttribute("collavis", collavis );
		request.setAttribute("client", client  );
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
