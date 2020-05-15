package uvsq21606235;

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

}
