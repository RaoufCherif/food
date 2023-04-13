package model;
import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.util.ArrayList;



public class BoissonDAO {



	
	public void save(Boisson boi) {
		
		try {
			if(boi.getId_boisson() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement("UPDATE boison SET nom_boisson=?, prix=?, image=? ,stock=?  WHERE id_boisson = ?  ");
				preparedStatement.setString(1, boi.getNom_boisson());
				preparedStatement.setDouble(2, boi.getPrix());
				preparedStatement.setString(3, boi.getImage());
				preparedStatement.setInt(4, boi.getStock());
				
		
				preparedStatement.setInt(5, boi.getId_boisson());
				
				preparedStatement.executeUpdate();
				
				
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement("INSERT INTO boisson (nom_boisson, prix, image,stock) VALUES (?,?,?,?) ");
				preparedStatement.setString(1, boi.getNom_boisson());
				preparedStatement.setDouble(2, boi.getPrix());
				preparedStatement.setString(3, boi.getImage());
				preparedStatement.setInt(4, boi.getStock());
				
				
				preparedStatement.executeUpdate();
				
			}
			
			System.out.println("SAVED OK");
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
			
		}	
		
	}
	
	public Boisson getById(int id) {
		
		try {
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM boisson WHERE id_boisson=?");	
			preparedStatement.setInt(1, id);
			
			ResultSet result = preparedStatement.executeQuery(); 
			
			Boisson boisson = new Boisson();
			
			while(result.next()) {
				boisson.setId_boisson(result.getInt("id_boisson"));
				boisson.setNom_boisson(result.getString("nom_boisson"));
				boisson.setPrix(result.getDouble("prix"));
				boisson.setImage(result.getString("image"));
				boisson.setStock(result.getInt("stock"));
		
				
				
			}
			return boisson;
		}catch(Exception  ex) {
			
			ex.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<Boisson> getAll(){
		ArrayList<Boisson> coll = new ArrayList<Boisson>();
		try {
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("SELECT * FROM boisson ");			
			ResultSet result = preparedstatement.executeQuery();
			
			while(result.next()) {
				Boisson boisson = new Boisson();
				boisson.setId_boisson(result.getInt("id_boisson"));
				boisson.setNom_boisson(result.getString("nom_boisson"));
				boisson.setPrix(result.getDouble("prix"));
				boisson.setImage(result.getString("image"));
				boisson.setStock(result.getInt("stock"));
				
				
				coll.add(boisson);
				
			}
			return coll;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
			
		}
		
	}
	

	public void deleteById(int id) {
		try {
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("DELETE FROM boisson WHERE id_boisson = ?");
			preparedstatement.setInt(1, id);
			
			preparedstatement.executeUpdate();
			
			System.out.println("DELETED OK");
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
		
	}

}
