package model;

public class Boisson {
	private int id_boisson;
	private String nom_boisson;
	private Double prix;
	private String image;
	private int stock;
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}


	
	public int getId_boisson() {
		return id_boisson;
	}
	public void setId_boisson(int id_boisson) {
		this.id_boisson = id_boisson;
	}
	public String getNom_boisson() {
		return nom_boisson;
	}
	public void setNom_boisson(String nom_boisson) {
		this.nom_boisson = nom_boisson;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Boisson [id_boisson=" + id_boisson + ", nom_boisson=" + nom_boisson + ", prix=" + prix + ", stock="
				+ stock + "]";
	}

	public Boisson(int id_boisson, String nom_boisson, Double prix, String image, int stock) {
		super();
		this.id_boisson = id_boisson;
		this.nom_boisson = nom_boisson;
		this.prix = prix;
		this.image = image;
		this.stock = stock;
	
	}
	
	public Boisson( String nom_boisson, Double prix, String image, int stock) {
		super();
	
		this.nom_boisson = nom_boisson;
		this.prix = prix;
		this.image = image;
		this.stock = stock;
	
	}
	public Boisson() {
		super();
	}
	
	
	

}
