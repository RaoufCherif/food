package model;

import java.util.ArrayList;

public class Panier_boisson {
	public ArrayList<PanierDetails_boisson> articles = new ArrayList<PanierDetails_boisson>();

	public Panier_boisson(ArrayList<PanierDetails_boisson> articles) {
		this.articles = articles;
	}

	public Panier_boisson() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Panier [articles=" + articles + "]";
	}
	
	public int count() {
		return this.articles.size();
	}
	

	
	public void ajouterBoisson(PanierDetails_boisson b) {
		boolean exist=false;
		for(PanierDetails_boisson dp:articles) {
			if(dp.getBoisson().getId_boisson()==b.getBoisson().getId_boisson()) {
				exist=true;
				dp.setQte(dp.getQte()+b.getQte());
			}
		}
		if(!exist) {
			articles.add(b);
		}
	}
	
	
	public double total() {
		double total=0;
		for(PanierDetails_boisson pp:articles) {
			total+=pp.getBoisson().getPrix()*pp.getQte();
		}
		return total;
	}
	
	public void delete(int produitid) {
		PanierDetails_boisson detail= new PanierDetails_boisson();
		for(PanierDetails_boisson pp:articles) {
			if(pp.getBoisson().getId_boisson()==produitid) {
				detail=pp;
			}
		}
		articles.remove(detail);
	}
	
	public void vider() {
		articles= new ArrayList<PanierDetails_boisson>();
	}	
}
