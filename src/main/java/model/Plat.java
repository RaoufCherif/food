package model;

public class Plat {
	
	private int id_plat;
	private String nom_plat;
	private double prix;
	private int id_type;
	private String image;
	private boolean deleted; 

	@Override
	public String toString() {
		return "Plat [id_plat=" + id_plat + ", nom_plat=" + nom_plat + ", prix=" + prix + ", id_type=" + id_type
				+", image=" + image + ", deleted=" + deleted + "]";
	}
	public int getId_plat() {
		return id_plat;
	}
	public void setId_plat(int id_plat) {
		this.id_plat = id_plat;
	}
	
	public boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	public String getNom_plat() {
		return nom_plat;
	}
	public void setNom_plat(String nom_plat) {
		this.nom_plat = nom_plat;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getId_type() {
		return id_type;
	}
	public void setId_type(int id_type) {
		this.id_type = id_type;
	}

	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	

	public Plat(int id_plat, String nom_plat, double prix, int id_type, String image, boolean deleted) {
		super();
		this.id_plat = id_plat;
		this.nom_plat = nom_plat;
		this.prix = prix;
		this.id_type = id_type;
		
		this.image = image;
		this.deleted = deleted;
	}
	
	
	public Plat(String nom_plat, double prix, int id_type, String image, boolean deleted) {
		super();
		this.nom_plat = nom_plat;
		this.prix = prix;
		this.id_type = id_type;
		
		this.image = image;
		this.deleted = deleted;
	}
	public Plat() {
		super();
	}
	
	
	
	

}
