package model;

public class PanierDetails_boisson {
	
	
	private int qte;
	private Boisson boisson;
	
	public PanierDetails_boisson( Boisson boisson, int qte) {
		super();
		this.qte = qte;
		this.boisson = boisson;
	}
	
	public Boisson getBoisson() {
		return boisson;
	}
	public void setBoisson(Boisson boisson) {
		this.boisson = boisson;
	}
	public PanierDetails_boisson() {
	}

	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	
	@Override
	public String toString() {
		return "Panier [Boisson=" + boisson + ", qte=" + qte + "]";
	}
}
