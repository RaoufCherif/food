package model;

public class Client {
	private int id_client;
	private String nom;
	private String prenom;
	private String tel;
	private String email;
	private String mot_de_passe;
	
	@Override
	public String toString() {
		return "Client [id_client=" + id_client + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", email="
				+ email + ", mot_de_passe=" + mot_de_passe + "]";
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	public Client(String nom, String prenom, String tel, String email, String mot_de_passe) {
		super();
	
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.email = email;
		this.mot_de_passe = mot_de_passe;
	}

	
	
	public Client(int id_client, String nom, String prenom, String tel, String email, String mot_de_passe) {
		super();
		this.id_client = id_client;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.email = email;
		this.mot_de_passe = mot_de_passe;
	}

	public Client() {
		super();
	}
	
	

}
