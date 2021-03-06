package uvsq21606235.formes;

public class Cercle extends Formes {

	
	private Point centre;
	
	private double rayon;
	
	public Cercle(String nomF, Point centre,double rayon) {
		super(nomF);
		this.centre = centre.clone();
		this.rayon = rayon;
	}
	
	public Point getCentre() {
		return this.centre.clone();
	}
	
	public double getRayon() {
		return this.rayon;
	}
	
	public void setRayon(double r) {
		this.rayon = r;
	}
	
	public void setCentre(Point p) {
		this.centre = p;
	}
	
	/**
	 * affichage d'un cercle
	 */
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println("Cercle de rayon "+ rayon +" et de centre: "+ centre);
	}
	
	/**
	 * permet de deplacer le cercle
	 */
	@Override
	public void deplace(double x, double y) {
		// TODO Auto-generated method stub
		centre.deplace(x, y);
		
	}

	@Override
	public Point getOrigine() {
		// TODO Auto-generated method stub
		return null;
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
