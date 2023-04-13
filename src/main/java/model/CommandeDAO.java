package model;

import java.sql.Date;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class CommandeDAO {


	
	public int save(Commande com) {
		int newId = 0;
		try {
			if(com.getId_commande() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement("UPDATE commande SET date_de_commande=? , date_de_livraison = ? , id_client = ? WHERE id_commande = ?  ");
				preparedStatement.setString(1, com.getDate_de_commande());
				preparedStatement.setString(2, com.getDate_de_livraison());
				preparedStatement.setInt(3, com.getId_client());
				
				preparedStatement.setInt(4, com.getId_commande());
				
				preparedStatement.executeUpdate();

			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement("INSERT INTO commande (date_de_commande, date_de_livraison, id_client) VALUES (?,?,?) ",Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, com.getDate_de_commande());
				preparedStatement.setString(2, com.getDate_de_livraison());
				preparedStatement.setInt(3, com.getId_client());
				preparedStatement.executeUpdate();
				
				ResultSet keys = preparedStatement.getGeneratedKeys();
				
				int id = 1;
				while(keys.next()) {
					
					newId= keys.getInt(id);
					System.out.println("je suis le nouveau id   " + id);
	
				}
				
			}
			
			System.out.println("SAVED OK");
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
		
		}
		return newId;
		
	}
	
	public Commande getById(int id) {
		
		try {
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM commande WHERE id_commande=?");	
			preparedStatement.setInt(1, id);
			
			ResultSet result = preparedStatement.executeQuery(); 
			
			Commande com = new Commande();
 			
			while(result.next()) {
				com.setId_commande(result.getInt("id_commande"));
				com.setDate_de_commande(result.getString("date_de_commande"));
				com.setDate_de_livraison(result.getString("date_de_livraison"));
				com.setId_client(result.getInt("id_client"));
				
			}
			return com;
		}catch(Exception  ex) {
			
			ex.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<Commande> getAll(){
		ArrayList<Commande> coll = new ArrayList<Commande>();
		try {
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("SELECT * FROM avis ");			
			ResultSet result = preparedstatement.executeQuery();
			
			while(result.next()) {
				Commande com = new Commande();
				 com.setId_commande(result.getInt("id_commande"));
				 com.setDate_de_commande(result.getString("date_de_commande"));
				 com.setDate_de_livraison(result.getString("date_de_livraison"));
				 com.setId_client(result.getInt("id_client"));
				
				coll.add(com);
				
			}
			return coll;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
			
		}
		
	}
	

	public void deleteById(int id) {
		try {
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("DELETE FROM commande WHERE id_commande=?");
			preparedstatement.setInt(1, id);
			
			preparedstatement.executeUpdate();
			
			System.out.println("DELETED OK");
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
		
	}

}
