package controleur;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Boisson;
import model.BoissonDAO;
import model.Client;
import model.ClientDAO;
import model.Database;
import model.Plat;
import model.PlatDAO;
import model.TypeDAO;
import model.TypePlat;

/**
 * Servlet implementation class Menu
 */
@WebServlet("/Menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Menu() {
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
		
		PlatDAO pldao = new PlatDAO();
		ArrayList<Plat> collplat = pldao.getAll();
		ArrayList<Plat> collplatEnt = pldao.getByAllIdType(1);
		ArrayList<Plat> collplatMain = pldao.getByAllIdType(2);
		ArrayList<Plat> collplatDes = pldao.getByAllIdType(3);
		TypeDAO typedao = new TypeDAO();
		
		ArrayList<TypePlat> colltype = typedao.getAll();
		
		
		BoissonDAO boidao = new BoissonDAO();
		ArrayList<Boisson> colBoi = boidao.getAll();
		
		
		
		request.setAttribute("colBoi", colBoi );
		request.setAttribute("collplatDes", collplatDes );
		request.setAttribute("collplatMain", collplatMain );
		request.setAttribute("collplatEnt", collplatEnt );
		request.setAttribute("colltype", colltype );
		request.setAttribute("collclient", collclient );
		request.setAttribute("collplat", collplat );
		
		request.getRequestDispatcher("menu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
