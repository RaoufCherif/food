package model;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;

public class FactureDAO {




	public void save(Facture fac) {
		
		try {
			if(fac.getId_facture() != 0) {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement("UPDATE facture SET date=? , total = ? , id_com_det = ? WHERE id_facture= ?  ");
				preparedStatement.setString(1, fac.getDate());

				preparedStatement.setFloat(2, fac.getTotal());
				
				preparedStatement.setInt(3, fac.getId_com_det());
				
				preparedStatement.setInt(4, fac.getId_facture());
				
				preparedStatement.executeUpdate();
				
				
			} else {
				PreparedStatement preparedStatement = Database.connexion.prepareStatement("INSERT INTO facture (date, total , id_com_det) VALUES (?,?,?) ");
				preparedStatement.setString(1, fac.getDate());
				preparedStatement.setFloat(2, fac.getTotal());
				preparedStatement.setInt(3, fac.getId_com_det());
				
				
				preparedStatement.executeUpdate();
				
			}
			
			System.out.println("SAVED OK");
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("SAVED NO");
			
		}	
		
	}
	
	public Facture getById(int id) {
		
		try {
			PreparedStatement preparedStatement  = Database.connexion.prepareStatement("SELECT * FROM facture WHERE id_facture=?");	
			preparedStatement.setInt(1, id);
			
			ResultSet result = preparedStatement.executeQuery(); 
			
			Facture com = new Facture();
 			
			while(result.next()) {
				com.setId_facture(result.getInt("id_facture"));
				com.setDate(result.getString("date"));
				com.setTotal(result.getInt("total"));
				com.setId_com_det(result.getInt("id_com_det"));
				
			}
			return com;
		}catch(Exception  ex) {
			
			ex.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<Facture> getAll(){
		ArrayList<Facture> coll = new ArrayList<Facture>();
		try {
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("SELECT * FROM facture ");			
			ResultSet result = preparedstatement.executeQuery();
			
			while(result.next()) {
				Facture com = new Facture();
				
				 com.setId_facture(result.getInt("id_facture"));
				 com.setDate(result.getString("date"));
				 com.setTotal(result.getInt("total"));
				 
				 com.setId_com_det(result.getInt("id_com_det"));
				
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
			PreparedStatement preparedstatement = Database.connexion.prepareStatement("DELETE FROM facture WHERE id_facture=?");
			preparedstatement.setInt(1, id);
			
			preparedstatement.executeUpdate();
			
			System.out.println("DELETED OK");
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			System.out.println("DELETED NO");
		}
		
	}

}
