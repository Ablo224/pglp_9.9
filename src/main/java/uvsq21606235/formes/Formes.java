package uvsq21606235.formes;

import uvsq21606235.*;

public abstract class Formes {
	
	private String nomForme;
	
	protected Formes(String nomF) {
		// TODO Auto-generated constructor stub
		nomForme = nomF;
	}

	/**
	 * obtention du nom de la forme
	 * @return
	 */
	
	public String getNomForme() {
		return nomForme; 
	}
	
	public void setNomForme(String nomF) {
		this.nomForme = nomF;
	}
	
	/**
	 * fonction qui deplacera une forme
	 * @param x
	 * @param y
	 */
	public abstract void deplace(double x, double y);
	
	
	/**
	 * 
	 */
	public void print() {
		System.out.println(nomForme);
	}
	
	/**
	 * obtention du centre d'un cercle
	 * @return
	 */
	public abstract Point getCentre();
	
	/**
	 * obtention du rayon d'un cercle
	 * @return
	 */
	public abstract double getRayon();
	
	/**
	 * obtention du point haut gauche d'un rectangle ou d'un triangle
	 * @return
	 */
	public abstract Point getOrigine();

	/**
	 * obtention du point bas droit d'un triangle
	 * @return
	 */
	public abstract Point getBd();

	/**
	 * obtention du point haut d'un triangle
	 * @return
	 */
	public abstract Point getH();

	/**
	 * obtention du point bas gauche d'un triangle
	 * @return
	 */
	public abstract Point getBg();
	
	/**
	 * coté d'un carré
	 * @return
	 */
	public abstract double getCote();

	/**
	 * largeur d'un rectangle
	 * @return
	 */
	public abstract double getLargeur();
	
	/**
	 * longueur d'un rectangle
	 * @return
	 */
	public abstract double getLongueur();

}
