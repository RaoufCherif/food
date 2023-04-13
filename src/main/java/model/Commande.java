package model;

public class Commande {
	private int id_commande;
	private String date_de_commande;
	private String date_de_livraison;
	private int id_client;
	
	public int getId_commande() {
		return id_commande;
	}
	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}
	public String getDate_de_commande() {
		return date_de_commande;
	}
	public void setDate_de_commande(String date_de_commande) {
		this.date_de_commande = date_de_commande;
	}
	public String getDate_de_livraison() {
		return date_de_livraison;
	}
	public void setDate_de_livraison(String date_de_livraison) {
		this.date_de_livraison = date_de_livraison;
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	@Override
	public String toString() {
		return "Commande [id_commande=" + id_commande + ", date_de_commande=" + date_de_commande
				+ ", date_de_livraison=" + date_de_livraison + ", id_client=" + id_client + "]";
	}
	public Commande(int id_commande, String date_de_commande, String date_de_livraison, int id_client) {
		super();
		this.id_commande = id_commande;
		this.date_de_commande = date_de_commande;
		this.date_de_livraison = date_de_livraison;
		this.id_client = id_client;
	}
	public Commande( String date_de_commande, String date_de_livraison, int id_client) {
		super();
		this.date_de_commande = date_de_commande;
		this.date_de_livraison = date_de_livraison;
		this.id_client = id_client;
	}
	public Commande() {
		super();
	}
	
	

}
