package model;

public class Avis {
	private int id_avis;
	private String avis;
	private int rate;
	private int id_client;
	public int getId_avis() {
		return id_avis;
	}
	public void setId_avis(int id_avis) {
		this.id_avis = id_avis;
	}
	public String getAvis() {
		return avis;
	}
	public void setAvis(String avis) {
		this.avis = avis;
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
	@Override
	public String toString() {
		return "Avis [id_avis=" + id_avis + ", avis=" + avis + ", rate=" + rate + ", id_client=" + id_client + "]";
	}
	public Avis(int id_avis, String avis, int rate, int id_client) {
		super();
		this.id_avis = id_avis;
		this.avis = avis;
		this.rate = rate;
		this.id_client = id_client;
	}
	public Avis() {
		super();
	}
	
	
	

}
