package model;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CommentaireDAO {


	public void save(Commande_details com_det) {
		
		try {
			if(com_det.getId_com_det() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement("UPDATE commande_details SET id_plat = ?, quantite=? , id_commande = ? WHERE id_com_det = ?  ");
				preparedStatement.setInt(1, com_det.getId_plat());
				preparedStatement.setInt(2, com_det.getQuantite());
				preparedStatement.setInt(3, com_det.getId_commande());
				preparedStatement.setInt(4, com_det.getId_com_det());
				
				preparedStatement.executeUpdate();
				
			} else {
				
				PreparedStatement preparedStatement = Database.connexion.prepareStatement("INSERT INTO commande_details (id_plat, quantite, id_commande) VALUES (?,?,?) ");
				preparedStatement.setInt(1, com_det.getId_plat());
				preparedStatement.setInt(2, com_det.getQuantite());
				preparedStatement.setInt(3, com_det.getId_commande());
				preparedStatement.executeUpdate();
			
			
				
			}
			
			System.out.println("SAVED OK");
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
			
		}	
		
	}
	
	public Commande_details getById(int id) {
		
		try {
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM commande_details WHERE id_com_det=?");	
			preparedStatement.setInt(1, id);
			
			ResultSet result = preparedStatement.executeQuery(); 
			
			Commande_details com = new Commande_details();
 			
			while(result.next()) {
				com.setId_com_det(result.getInt("id_com_det"));
				com.setQuantite(result.getInt("quantite"));
				com.setId_commande(result.getInt("id_commande"));
				
			}
			return com;
		}catch(Exception  ex) {
			
			ex.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<Commande_details> getAll(){
		ArrayList<Commande_details> coll = new ArrayList<Commande_details>();
		try {
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("SELECT * FROM avis ");			
			ResultSet result = preparedstatement.executeQuery();
			
			while(result.next()) {
				Commande_details com = new Commande_details();
				 com.setId_com_det(result.getInt("id_com_det"));
				 com.setQuantite(result.getInt("quantite"));
				 
				 com.setId_commande(result.getInt("id_commande"));
				
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
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("DELETE FROM commande_details WHERE id_com_det=?");
			preparedstatement.setInt(1, id);
			
			preparedstatement.executeUpdate();
			
			System.out.println("DELETED OK");
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
		
	}

}
