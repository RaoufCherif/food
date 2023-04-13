package model;

public class PanierDetails {
	
	private Plat plat;
	private int qte;

	public PanierDetails() {
	}
	public PanierDetails(Plat plat, int qte) {
		super();
		this.plat = plat;
		this.qte = qte;
	}
	
	public Plat getPlat() {
		return plat;
	}
	public void setPlat(Plat plat) {
		this.plat = plat;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	
	@Override
	public String toString() {
		return "Panier [Plat=" + plat + ", qte=" + qte + "]";
	}
}
