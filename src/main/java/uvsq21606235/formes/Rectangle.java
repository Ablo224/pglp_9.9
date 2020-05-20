package uvsq21606235.formes;

public class Rectangle extends Formes {

	private double longueur;
	
	private double largeur;
	
	private Point origine;
	
	public Point getOrigine() {
		return origine.clone();
	}
	
	public double getLongueur() {
		return this.longueur;
	}
	
	public void setLongueur(double l) {
		if(l > 0) this.longueur = l;
	}
	
	public double getLargeur() {
		return this.largeur;
	}
	
	public void setLargeur(double l) {
		if(l > 0) this.largeur = l;
	}
	
	public void setOrigine(Point p) {
		this.origine = p;
	}
	
	
	
	
	public Rectangle(String nomF,Point origine,double longueur, double largeur) {
		super(nomF);
		// TODO Auto-generated constructor stub
		this.origine = origine.clone();
		this.longueur = longueur;
		this.largeur = largeur;
	}

	@Override
	public void deplace(double x, double y) {
		// TODO Auto-generated method stub
		origine.deplace(x, y);
	}

	
	/**
	 * affichage d'un rectangle
	 */
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println("longueur :"+ longueur +" largeur: "+ largeur +" Origine :"+ origine);
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
	public Point getBd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getH() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getBg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getCote() {
		// TODO Auto-generated method stub
		return 0;
	}
}
