package uvsq21606235.formes;

public class Carre extends Formes {

	private Point origine;
	
	private double cote;
	
	public Carre(String nomF, Point origine,double cote) {
		super(nomF);
		this.origine = origine.clone();
		this.cote = cote;
	}
	
	public Point getOrigine() {
		return this.origine.clone();
	}
	
	public double getCote() {
		return this.cote;
	}
	
	public void setCote(double c) {
		if(c > 0) this.cote = c;
	}
	
	public void setOrigine(Point p) {
		this.origine = p;
	}
	
	
	/**
	 * affichage d'un carré
	 */
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println("Cote :"+ cote +" Origine: "+ origine);
	}
	
	
	
	/**
	 * permet de deplacer le carré
	 */
	@Override
	public void deplace(double x, double y) {
		// TODO Auto-generated method stub
		origine.deplace(x, y);
		
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
