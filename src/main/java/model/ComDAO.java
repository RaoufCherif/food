package model;


import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ComDAO {
	

	public void save(Commentaire com) {
		
		try {
			if(com.getId_comm() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement("UPDATE commentaire SET commentaire=? , rate = ? , id_client = ? , id_plat = ? WHERE id_comm = ?  ");
				preparedStatement.setString(1, com.getCommentaire());
				preparedStatement.setInt(2, com.getRate());
				preparedStatement.setInt(3, com.getId_client());
				
				preparedStatement.setInt(4, com.getId_plat());
				
				preparedStatement.setInt(5, com.getId_comm());
				
				preparedStatement.executeUpdate();
				
				
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement("INSERT INTO commentaire (commentaire, rate, id_client, id_plat) VALUES (?,?,?,?) ");
				preparedStatement.setString(1, com.getCommentaire());
				preparedStatement.setInt(2, com.getRate());
				preparedStatement.setInt(3, com.getId_client());
				preparedStatement.setInt(4, com.getId_plat());
				
				
				
				preparedStatement.executeUpdate();
				
			}
			
			System.out.println("SAVED OK");
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
			
		}	
		
	}
	
	public Commentaire getById(int id) {
		
		try {
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM commentaire WHERE id_comm=?");	
			preparedStatement.setInt(1, id);
			
			ResultSet result = preparedStatement.executeQuery(); 
			
				Commentaire comm = new Commentaire();
 			
			while(result.next()) {
				comm.setId_comm(result.getInt("id_comm"));
				comm.setCommentaire(result.getString("commentaire"));
				comm.setRate(result.getInt("rate"));
				comm.setId_client(result.getInt("id_client"));
				comm.setId_plat(result.getInt("id_plat"));
				
			}
			return comm;
		}catch(Exception  ex) {
			
			ex.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<Commentaire> getAll(){
		ArrayList<Commentaire> coll = new ArrayList<Commentaire>();
		try {
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("SELECT * FROM commentaire ");			
			ResultSet result = preparedstatement.executeQuery();
			
			while(result.next()) {
				Commentaire comm = new Commentaire();
				comm.setId_comm(result.getInt("id_comm"));
				comm.setCommentaire(result.getString("commentaire"));
				comm.setRate(result.getInt("rate"));
				comm.setId_client(result.getInt("id_client"));
				comm.setId_plat(result.getInt("id_plat"));
				
				coll.add(comm);
				
			}
			return coll;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
			
		}
		
	}
	
	
	public ArrayList<Commentaire> getAllByIdPlat(int id){
		ArrayList<Commentaire> coll = new ArrayList<Commentaire>();
		try {
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("SELECT * FROM commentaire WHERE id_plat = ?");			
			preparedstatement.setInt(1, id);
			
			ResultSet result = preparedstatement.executeQuery();
			
			while(result.next()) {
				Commentaire comm = new Commentaire();
				comm.setId_comm(result.getInt("id_comm"));
				comm.setCommentaire(result.getString("commentaire"));
				comm.setRate(result.getInt("rate"));
				comm.setId_client(result.getInt("id_client"));
				comm.setId_plat(result.getInt("id_plat"));

				coll.add(comm);
				
			}
			return coll;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
			
		}
		
	}
	

	public void deleteById(int id) {
		try {
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("DELETE FROM commentaire WHERE id_comm=?");
			preparedstatement.setInt(1, id);
			
			preparedstatement.executeUpdate();
			
			System.out.println("DELETED OK");
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
		
	}
	

}
