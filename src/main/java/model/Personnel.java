package model;

public class Personnel {
	
	private int id_personnel;
	private String nom;
	private String prenom;
	private String tel;
	private String mot_de_passe;
	private String email;
	private String position;
	
	
	public Personnel(String nom, String prenom, String tel, String mot_de_passe, String email, String position) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.mot_de_passe = mot_de_passe;
		this.email = email;
		this.position = position;
	}

	@Override
	public String toString() {
		return "Personnel [id_personnel=" + id_personnel + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel
				+ ", mot_de_passe=" + mot_de_passe + ", email=" + email + ", position=" + position + "]";
	}
	
	public Personnel(int id_personnel, String nom, String prenom, String tel, String mot_de_passe, String email,
			String position) {
		super();
		this.id_personnel = id_personnel;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.mot_de_passe = mot_de_passe;
		this.email = email;
		this.position = position;
	}


	public Personnel() {
		super();
	}

	public int getId_personnel() {
		return id_personnel;
	}


	public void setId_personnel(int id_personnel) {
		this.id_personnel = id_personnel;
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


	public String getMot_de_passe() {
		return mot_de_passe;
	}


	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}
}
