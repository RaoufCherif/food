package model;

import java.util.ArrayList;

public class Panier {
	public ArrayList<PanierDetails> articles = new ArrayList<PanierDetails>();

	public Panier(ArrayList<PanierDetails> articles) {
		this.articles = articles;
	}

	public Panier() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Panier [articles=" + articles + "]";
	}
	
	public int count() {
		return this.articles.size();
	}
	
	public void ajouter(PanierDetails p) {
		boolean exist=false;
		for(PanierDetails dp:articles) {
			if(dp.getPlat().getId_plat()==p.getPlat().getId_plat()) {
				exist=true;
				dp.setQte(dp.getQte()+p.getQte());
			}
		}
		if(!exist) {
			articles.add(p);
		}
	}

	
	public double total() {
		double total=0;
		for(PanierDetails pp:articles) {
			total+=pp.getPlat().getPrix()*pp.getQte();
		}
		return total;
	}
	
	public void delete(int produitid) {
		PanierDetails detail= new PanierDetails();
		for(PanierDetails pp:articles) {
			if(pp.getPlat().getId_plat()==produitid) {
				detail=pp;
			}
		}
		articles.remove(detail);
	}
	
	public void vider() {
		articles= new ArrayList<PanierDetails>();
	}	
}
