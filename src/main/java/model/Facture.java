package model;

public class Facture {
	
	private int id_facture; 
	private String date;
	private float total;
	private int id_com_det;
	public int getId_facture() {
		return id_facture;
	}
	public void setId_facture(int id_facture) {
		this.id_facture = id_facture;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getId_com_det() {
		return id_com_det;
	}
	public void setId_com_det(int id_com_det) {
		this.id_com_det = id_com_det;
	}
	@Override
	public String toString() {
		return "Facture [id_facture=" + id_facture + ", date=" + date + ", total=" + total + ", id_com_det="
				+ id_com_det + "]";
	}
	public Facture(int id_facture, String date, float total, int id_com_det) {
		super();
		this.id_facture = id_facture;
		this.date = date;
		this.total = total;
		this.id_com_det = id_com_det;
	}
	public Facture() {
		super();
	}
	
	

}
