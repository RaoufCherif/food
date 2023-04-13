package model;

public class Commande_details {
	
	private int id_com_det;
	private int id_plat;
	private int quantite;
	private int id_commande;
	
	
	public int getId_plat() {
		return id_plat;
	}
	public void setId_plat(int id_plat) {
		this.id_plat = id_plat;
	}
	public int getId_com_det() {
		return id_com_det;
	}
	public void setId_com_det(int id_com_det) {
		this.id_com_det = id_com_det;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public int getId_commande() {
		return id_commande;
	}
	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}

	public Commande_details(int id_plat , int quantite, int id_commande) {
		super();
		this.quantite = quantite;
		this.id_commande = id_commande;
		this.id_plat = id_plat;
	}
	public Commande_details(int id_com_det, int id_plat, int quantite, int id_commande) {
		super();
		this.id_com_det = id_com_det;
		this.quantite = quantite;
		this.id_commande = id_commande;
		this.id_plat = id_plat;
	}
	@Override
	public String toString() {
		return "Commande_details [id_com_det=" + id_com_det + ", quantite=" + quantite + ", id_commande=" + id_commande
				+ ", id_plat=" + id_plat + "]";
	}
	public Commande_details() {
		super();
	}
	
	

}
