package model;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;

public class TypeDAO {


	
	public void save(TypePlat type) {
		
		try {
			if(type.getId_type() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement("UPDATE type SET type=? , image = ? WHERE id_type = ?  ");
				preparedStatement.setString(1, type.getType());
				preparedStatement.setString(2, type.getImage());
		
				preparedStatement.setInt(3, type.getId_type());
				
				preparedStatement.executeUpdate();
				
				
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement("INSERT INTO type (type,image) VALUES (?,?) ");
				preparedStatement.setString(1, type.getType());
				preparedStatement.setString(2, type.getImage());
				
				preparedStatement.executeUpdate();
				
			}
			
			System.out.println("SAVED OK");
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
			
		}	
		
	}
	
	public TypePlat getById(int id) {
		
		try {
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM type WHERE id_type=?");	
			preparedStatement.setInt(1, id);
			
			ResultSet result = preparedStatement.executeQuery(); 
			
		TypePlat type = new TypePlat();
			
			while(result.next()) {
				type.setId_type(result.getInt("id_type"));
				type.setType(result.getString("type"));
				type.setImage(result.getString("image"));

			}
			return type;
		}catch(Exception  ex) {
			
			ex.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<TypePlat> getAll(){
		ArrayList<TypePlat> coll = new ArrayList<TypePlat>();
		try {
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("SELECT * FROM type ");			
			ResultSet result = preparedstatement.executeQuery();
			
			while(result.next()) {
				TypePlat type = new TypePlat();
				type.setId_type(result.getInt("id_type"));
				type.setType(result.getString("type"));
				type.setImage(result.getString("image"));
				
				coll.add(type);
				
			}
			return coll;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
			
		}
		
	}
	

	public void deleteById(int id) {
		try {
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("DELETE FROM type WHERE id_type=?");
			preparedstatement.setInt(1, id);
			
			preparedstatement.executeUpdate();
			
			System.out.println("DELETED OK");
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
		
	}

}
