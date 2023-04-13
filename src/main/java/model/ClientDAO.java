package model;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;



public class ClientDAO {
	
	public void save(Client client) {
		
		try {
			if(client.getId_client() != 0 ) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement("UPDATE Client SET nom=?, prenom=?, tel=? , email=? , mot_de_passe =? WHERE id_client = ?  ");
				preparedStatement.setString(1, client.getNom());
				preparedStatement.setString(2, client.getPrenom());
				preparedStatement.setString(3, client.getTel());
				preparedStatement.setString(4, client.getEmail());
				preparedStatement.setString(5, client.getMot_de_passe());
				
				preparedStatement.setInt(6, client.getId_client());
				
				preparedStatement.executeUpdate();
				
				
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement("INSERT INTO Client (nom, prenom, tel, email, mot_de_passe) VALUES (?,?,?,?,?) ");
				preparedStatement.setString(1,client.getNom());
				preparedStatement.setString(2,client.getPrenom());
				preparedStatement.setString(3,client.getTel());
				preparedStatement.setString(4,client.getEmail());
				preparedStatement.setString(5,client.getMot_de_passe());
				
				preparedStatement.executeUpdate();
				
			}
			
			System.out.println("SAVED OK");
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
			
		}	
		
	}
	
	public Client getById(int id) {
		
		try {
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM Client WHERE id_client=?");	
			preparedStatement.setInt(1, id);
			
			ResultSet result = preparedStatement.executeQuery(); 
			
			Client client = new Client();
			while(result.next()) {
				client.setId_client(result.getInt("id_client"));
				client.setNom(result.getString("nom"));
				client.setPrenom(result.getString("prenom"));
				client.setTel(result.getString("tel"));
				client.setEmail(result.getString("email"));
				client.setMot_de_passe(result.getString("mot_de_passe"));
				
			}
			return client;
		}catch(Exception  ex) {
			
			ex.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<Client> getAll(){
		ArrayList<Client> coll = new ArrayList<Client>();
		try {
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("SELECT * FROM Client");			
			ResultSet result = preparedstatement.executeQuery();
			
			while(result.next()) {
				Client client = new Client();
				client.setId_client(result.getInt("id_client"));
				client.setNom(result.getString("nom"));
				client.setPrenom(result.getString("prenom"));
				client.setTel(result.getString("tel"));
				client.setEmail(result.getString("email"));
				client.setMot_de_passe(result.getString("mot_de_passe"));
				
				coll.add(client);
				
			}
			return coll;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
			
		}
		
	}
	
	
	public Client connexion(String email, String pass) {
		
		try {
			
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("SELECT * FROM Client WHERE email = ? AND mot_de_passe = ? ");
			preparedstatement.setString(1, email);
			preparedstatement.setString(2, pass);
			
			ResultSet resultat = preparedstatement.executeQuery();
			Client client = new Client();
			
			if(resultat.next()) {
				
				client.setId_client(resultat.getInt("id_client"));
				client.setNom(resultat.getString("nom"));
				client.setPrenom(resultat.getString("prenom"));
				client.setTel(resultat.getString("tel"));
				client.setEmail(resultat.getString("email"));
				client.setMot_de_passe(resultat.getString("mot_de_passe"));
				
				return client;
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
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("DELETE FROM Client WHERE id_client=?");
			preparedstatement.setInt(1, id);
			
			preparedstatement.executeUpdate();
			
			System.out.println("DELETED OK");
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
		
	}

}
