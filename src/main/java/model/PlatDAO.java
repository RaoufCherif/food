package model;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;


public class PlatDAO {
	

	
	public void save(Plat plat) {
		
		try {
			if(plat.getId_plat() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement("UPDATE plat SET nom_plat=?, prix=?, id_type=?  , image = ?, deleted = ? WHERE id_plat = ?  ");
				preparedStatement.setString(1, plat.getNom_plat());
				preparedStatement.setDouble(2, plat.getPrix());
				preparedStatement.setInt(3, plat.getId_type());
				preparedStatement.setString(4, plat.getImage());
				preparedStatement.setBoolean(5, plat.getDeleted());
				
				preparedStatement.setInt(6, plat.getId_plat());
				
				preparedStatement.executeUpdate();
				
				
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement("INSERT INTO plat (nom_plat, prix, id_type, image,deleted) VALUES (?,?,?,?,?) ");
				preparedStatement.setString(1, plat.getNom_plat());
				preparedStatement.setDouble(2, plat.getPrix());
				preparedStatement.setInt(3, plat.getId_type());

				preparedStatement.setString(4, plat.getImage());
				preparedStatement.setBoolean(5, plat.getDeleted());
				
				preparedStatement.executeUpdate();
			}
			
			System.out.println("SAVED OK");
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
			
		}	
		
	}
	
	public Plat getById(int id) {
		
		try {
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM plat WHERE id_plat=?");	
			preparedStatement.setInt(1, id);
			
			ResultSet result = preparedStatement.executeQuery(); 
			
			Plat plat = new Plat();
			
			while(result.next()) {
				plat.setId_plat(result.getInt("id_plat"));
				plat.setNom_plat(result.getString("nom_plat"));
				plat.setPrix(result.getDouble("prix"));
				plat.setId_type(result.getInt("id_type"));
				
				plat.setImage(result.getString("image"));
				plat.setDeleted(result.getBoolean("deleted"));
				
				
			}
			return plat;
		}catch(Exception  ex) {
			
			ex.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<Plat> getByAllIdType(int id){
		ArrayList<Plat> coll = new ArrayList<Plat>();
		
		try {
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("SELECT * FROM plat WHERE id_type = ? ");		
			preparedstatement.setInt(1, id);
			
			ResultSet result = preparedstatement.executeQuery();
			
			while(result.next()) {
				Plat plat = new Plat();
				plat.setId_plat(result.getInt("id_plat"));
				plat.setNom_plat(result.getString("nom_plat"));
				plat.setPrix(result.getDouble("prix"));
				plat.setId_type(result.getInt("id_type"));
				plat.setImage(result.getString("image"));
				plat.setDeleted(result.getBoolean("deleted"));
				
				coll.add(plat);
				
			}
			return coll;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
			
		}
		
	}
	
	public ArrayList<Plat> getAll(){
		ArrayList<Plat> coll = new ArrayList<Plat>();
		try {
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("SELECT * FROM plat  ");			
			ResultSet result = preparedstatement.executeQuery();
			
			while(result.next()) {
				Plat plat = new Plat();
				plat.setId_plat(result.getInt("id_plat"));
				plat.setNom_plat(result.getString("nom_plat"));
				plat.setPrix(result.getDouble("prix"));
				plat.setId_type(result.getInt("id_type"));
				plat.setImage(result.getString("image"));
				plat.setDeleted(result.getBoolean("deleted"));
				
				coll.add(plat);
				
			}
			return coll;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
			
		}
		
	}
	

	public void deleteById(int id) {
		try {
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("UPDATE plat SET deleted = 1 WHERE id_plat=?");
			preparedstatement.setInt(1, id);
			
			preparedstatement.executeUpdate();
			
			System.out.println("DELETED OK");
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
		
	}

}
