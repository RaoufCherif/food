package model;

public class Commentaire {
	int id_comm ;
	String commentaire;
	int rate;
	int id_client;
	int id_plat;
	
	
	
	public int getId_comm() {
		return id_comm;
	}



	public void setId_comm(int id_comm) {
		this.id_comm = id_comm;
	}



	public String getCommentaire() {
		return commentaire;
	}



	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}



	public int getRate() {
		return rate;
	}



	public void setRate(int rate) {
		this.rate = rate;
	}



	public int getId_client() {
		return id_client;
	}



	public void setId_client(int id_client) {
		this.id_client = id_client;
	}



	public int getId_plat() {
		return id_plat;
	}



	public void setId_plat(int id_plat) {
		this.id_plat = id_plat;
	}



	@Override
	public String toString() {
		return "Commentaire [id_comm=" + id_comm + ", commentaire=" + commentaire + ", rate=" + rate + ", id_client="
				+ id_client + ", id_plat=" + id_plat + "]";
	}



	public Commentaire(String commentaire, int rate, int id_client, int id_plat) {
		super();
		this.commentaire = commentaire;
		this.rate = rate;
		this.id_client = id_client;
		this.id_plat = id_plat;
	}



	public Commentaire(int id_comm, String commentaire, int rate, int id_client, int id_plat) {
		super();
		this.id_comm = id_comm;
		this.commentaire = commentaire;
		this.rate = rate;
		this.id_client = id_client;
		this.id_plat = id_plat;
	}



	public Commentaire() {
		super();
	}
	
	
	

}
