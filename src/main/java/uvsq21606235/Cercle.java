package uvsq21606235;

public class Cercle extends Formes {

	
	private Point centre;
	
	private double rayon;
	
	public Cercle(String nomF, Point centre,double cote) {
		super(nomF);
		this.centre = centre.clone();
		this.rayon = rayon;
	}
	
	public Point getCenre() {
		return this.centre.clone();
	}
	
	public double getRayon() {
		return this.rayon;
	}
	
	public void setRayon(double r) {
		this.rayon = r;
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

}
