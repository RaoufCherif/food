package model;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Commande_details_boissonDAO2 {


	public void save(Commande_details_boisson com_det_boi) {
		
		try {
			if(com_det_boi.getId_com_det_boi() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement("UPDATE commande_details_boisson SET id_boisson = ?, quantite=? , id_commande = ? WHERE id_com_boi = ?  ");
				preparedStatement.setInt(1, com_det_boi.getId_boisson());
				preparedStatement.setInt(2, com_det_boi.getQuantite());
				preparedStatement.setInt(3, com_det_boi.getId_commande());
				preparedStatement.setInt(4, com_det_boi.getId_com_det_boi());
				
				preparedStatement.executeUpdate();
				
			} else {
				
				PreparedStatement preparedStatement = Database.connexion.prepareStatement("INSERT INTO commande_details_boisson (id_boisson, quantite, id_commande) VALUES (?,?,?) ");
				preparedStatement.setInt(1, com_det_boi.getId_boisson());
				preparedStatement.setInt(2, com_det_boi.getQuantite());
				preparedStatement.setInt(3, com_det_boi.getId_commande());
				preparedStatement.executeUpdate();
			
			
				
			}
			
			System.out.println("SAVED OK");
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
			
		}	
		
	}
	
	public Commande_details_boisson getById(int id) {
		
		try {
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM commande_details_boisson WHERE id_com_boi=?");	
			preparedStatement.setInt(1, id);
			
			ResultSet result = preparedStatement.executeQuery(); 
			
			Commande_details_boisson com = new Commande_details_boisson();
 			
			while(result.next()) {
				com.setId_com_det_boi(result.getInt("id_com_boi"));
				com.setQuantite(result.getInt("quantite"));
				com.setId_commande(result.getInt("id_commande"));
				
			}
			return com;
		}catch(Exception  ex) {
			
			ex.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<Commande_details_boisson> getAll(){
		ArrayList<Commande_details_boisson> coll = new ArrayList<Commande_details_boisson>();
		try {
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("SELECT * FROM commande_details_boisson ");			
			ResultSet result = preparedstatement.executeQuery();
			
			while(result.next()) {
				Commande_details_boisson com = new Commande_details_boisson();
				 com.setId_com_det_boi(result.getInt("id_com_boi"));
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
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("DELETE FROM commande_details_boisson WHERE id_com_boi=?");
			preparedstatement.setInt(1, id);
			
			preparedstatement.executeUpdate();
			
			System.out.println("DELETED OK");
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
		
	}

}
