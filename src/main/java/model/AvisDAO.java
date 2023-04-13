package model;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;

public class AvisDAO {

	public void save(Avis avis) {
		
		try {
			if(avis.getId_avis() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement("UPDATE avis SET avis=? , rate = ? , id_client = ? WHERE id_avis = ?  ");
				preparedStatement.setString(1, avis.getAvis());
				preparedStatement.setInt(2, avis.getRate());
				preparedStatement.setInt(3, avis.getId_client());
				
				preparedStatement.setInt(4, avis.getId_avis());
				
				preparedStatement.executeUpdate();
				
				
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement("INSERT INTO avis (avis, rate, id_client) VALUES (?,?,?) ");
				preparedStatement.setString(1, avis.getAvis());
				preparedStatement.setInt(2, avis.getRate());
				preparedStatement.setInt(3, avis.getId_client());
				preparedStatement.executeUpdate();
				
			}
			
			System.out.println("SAVED OK");
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
			
		}	
		
	}
	
	public Avis getById(int id) {
		
		try {
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM avis WHERE id_avis=?");	
			preparedStatement.setInt(1, id);
			
			ResultSet result = preparedStatement.executeQuery(); 
			
				Avis avis = new Avis();
 			
			while(result.next()) {
				avis.setId_avis(result.getInt("id_avis"));
				avis.setAvis(result.getString("avis"));
				avis.setRate(result.getInt("rate"));
				avis.setId_client(result.getInt("id_client"));
				
			}
			return avis;
		}catch(Exception  ex) {
			
			ex.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<Avis> getAll(){
		ArrayList<Avis> coll = new ArrayList<Avis>();
		try {
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("SELECT * FROM avis ");			
			ResultSet result = preparedstatement.executeQuery();
			
			while(result.next()) {
				Avis avis = new Avis();
				avis.setId_avis(result.getInt("id_avis"));
				avis.setAvis(result.getString("avis"));
				avis.setRate(result.getInt("rate"));
				avis.setId_client(result.getInt("id_client"));
				
				coll.add(avis);
				
			}
			return coll;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
			
		}
		
	}
	

	public void deleteById(int id) {
		try {
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("DELETE FROM avis WHERE id_avis=?");
			preparedstatement.setInt(1, id);
			
			preparedstatement.executeUpdate();
			
			System.out.println("DELETED OK");
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
		
	}

}
