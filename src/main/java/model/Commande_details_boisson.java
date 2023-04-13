package model;

public class Commande_details_boisson {
	
	private int id_com_det_boi;
	private int id_boisson;
	private int quantite;
	private int id_commande;

	
	
	
	public Commande_details_boisson(int id_boisson, int quantite, int id_commande) {
		super();
		this.id_boisson = id_boisson;
		this.quantite = quantite;
		this.id_commande = id_commande;
	}

	public Commande_details_boisson(int id_com_det_boi, int id_boisson, int quantite, int id_commande) {
		super();
		this.id_com_det_boi = id_com_det_boi;
		this.id_boisson = id_boisson;
		this.quantite = quantite;
		this.id_commande = id_commande;
	}

	public int getId_com_det_boi() {
		return id_com_det_boi;
	}

	public void setId_com_det_boi(int id_com_det_boi) {
		this.id_com_det_boi = id_com_det_boi;
	}

	public int getId_boisson() {
		return id_boisson;
	}

	public void setId_boisson(int id_boisson) {
		this.id_boisson = id_boisson;
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

	@Override
	public String toString() {
		return "Commande_details_boisson [id_com_det_boi=" + id_com_det_boi + ", id_boisson=" + id_boisson
				+ ", quantite=" + quantite + ", id_commande=" + id_commande + "]";
	}

	public Commande_details_boisson() {
		super();
	}
	
	

}
