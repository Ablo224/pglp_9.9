package uvsq21606235.formes;

import uvsq21606235.*;

public class Triangle extends Formes {

	/**
	 * représentation des trois points d'un triangle
	 */
	private Point h;
	private Point bg;
	private Point bd;
	
	
//	public Point getP(int indice) {
//			return p[indice].clone();
//	}
	
	@Override
	public Point getH() {
		return h;
	}

	public void setH(Point h) {
		this.h = h;
	}
	@Override
	public Point getBg() {
		return bg;
	}

	public void setBg(Point bg) {
		this.bg = bg;
	}
	
	
	public void setBd(Point bd) {
		this.bd = bd;
	}
	
	@Override
	public Point getBd() {
		return this.bd;
	}
 
	
	
	 
	public Triangle(String nomF,Point h, Point bg, Point bd) {
		super(nomF);
		// TODO Auto-generated constructor stub
		this.h = h;
		this.bg = bg;
		this.bd = bd;
	}

	@Override
	public void deplace(double x, double y) {
		// TODO Auto-generated method stub
//		for(int i=0; i<3; i++) {
//			p[i].deplace(x, y);
//		}
		
	}
	
	/**
	 * affichage d'un triangle
	 */
	public void print() {
//		// TODO Auto-generated method stub
//		super.print();
//		System.out.println("point n°1 : "+ p[0] +" point n°2 : "+ p[1] + "point n°1 : "+ p[2] );
	}



	@Override
	public Point getCentre() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public double getRayon() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public Point getOrigine() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public double getCote() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public double getLargeur() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public double getLongueur() {
		// TODO Auto-generated method stub
		return 0;
	}

}
