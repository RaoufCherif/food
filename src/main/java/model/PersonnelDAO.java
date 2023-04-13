package model;


import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;


public class PersonnelDAO {

	
	public void save(Personnel per) {
		
		try {
			if(per.getId_personnel() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement("UPDATE personnel SET nom=?, prenom=?, tel=? , mot_de_passe =?, email=?, role=?  WHERE id_personnel = ?  ");
				preparedStatement.setString(1,  per.getNom());
				preparedStatement.setString(2, per.getPrenom());
				preparedStatement.setString(3, per.getTel());
				preparedStatement.setString(4, per.getMot_de_passe());
				preparedStatement.setString(5, per.getEmail());
				preparedStatement.setString(6, per.getPosition());
				
				preparedStatement.setInt(7, per.getId_personnel());
				
				preparedStatement.executeUpdate();
				
				
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement("INSERT INTO personnel (nom, prenom, tel, mot_de_passe , email,role) VALUES (?,?,?,?,?,?) ");
				preparedStatement.setString(1,  per.getNom());
				preparedStatement.setString(2, per.getPrenom());
				preparedStatement.setString(3, per.getTel());
				preparedStatement.setString(4, per.getMot_de_passe());
				preparedStatement.setString(5, per.getEmail());
				preparedStatement.setString(6, per.getPosition());
				preparedStatement.executeUpdate();
				
			}
			
			System.out.println("SAVED OK");
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
			
		}	
		
	}
	
	public Personnel getById(int id) {
		
		try {
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM personnel WHERE id_personnel=?");	
			preparedStatement.setInt(1, id);
			
			ResultSet result = preparedStatement.executeQuery(); 
			
		Personnel per = new Personnel();
			while(result.next()) {
				per.setId_personnel(result.getInt("id_personnel"));
				per.setNom(result.getString("nom"));
				per.setPrenom(result.getString("prenom"));
				per.setTel(result.getString("tel"));
				per.setMot_de_passe(result.getString("mot_de_passe"));
				per.setEmail(result.getString("email"));
				per.setPosition(result.getString("role"));
			}
			return per;
		}catch(Exception  ex) {
			
			ex.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<Personnel> getAll(){
		ArrayList<Personnel> coll = new ArrayList<Personnel>();
		try {
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("SELECT * FROM personnel");			
			ResultSet result = preparedstatement.executeQuery();
			
			while(result.next()) {
				Personnel per = new Personnel();
				per.setId_personnel(result.getInt("id_personnel"));
				per.setNom(result.getString("nom"));
				per.setPrenom(result.getString("prenom"));
				per.setTel(result.getString("tel"));
				per.setMot_de_passe(result.getString("mot_de_passe"));
				per.setEmail(result.getString("email"));
				per.setPosition(result.getString("role"));
				
				coll.add(per);
				
			}
			return coll;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
			
		}
		
	}
	
	
	public Personnel connexion(String email, String pass) {
		
		try {
			
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("SELECT * FROM personnel WHERE email = ? AND mot_de_passe = ? ");
			preparedstatement.setString(1, email);
			preparedstatement.setString(2, pass);
			
			ResultSet result = preparedstatement.executeQuery();
			Personnel per = new Personnel();
			
			if(result.next()) {
				
			
				per.setId_personnel(result.getInt("id_personnel"));
				per.setNom(result.getString("nom"));
				per.setPrenom(result.getString("prenom"));
				per.setTel(result.getString("tel"));
				per.setMot_de_passe(result.getString("mot_de_passe"));
				per.setEmail(result.getString("email"));
				per.setEmail(result.getString("role"));
				
				return per;
			} else {
				
				return null;
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
			
		}
	}
	
	  
	
	public void deleteById(int id) {
		try {
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("DELETE FROM personnel WHERE id_personnel=?");
			preparedstatement.setInt(1, id);
			
			preparedstatement.executeUpdate();
			
			System.out.println("DELETED OK");
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
		
	}

}
