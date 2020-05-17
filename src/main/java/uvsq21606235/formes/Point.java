package uvsq21606235.formes;

public class Point {
	
	/**
	 * abscisse 
	 */
	private double x;
	
	/**
	 * oridonnée
	 */
	private double y;
	
	
	public Point(double abs, double ord) {
		this.x = abs;
		this.y = ord;
	}
	
	/**
	 * constructeur par défaut
	 */
	public Point() {
		this.x = 0;
		this.y = 0;
		
	}
	
	/**
	 * obtention de l'abscisse
	 * @return
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * obtention de l'ordonné
	 * @return
	 */
	public double getY() {
		return this.y;
	}
	
	/**
	 * obtention d'une copie d'un point
	 */
	@Override
	public Point clone() {
		return new Point(x,y);
	}
	
	@Override
	public String toString() {
		return "("+x+","+y+")";
		
	}
	
	public void deplace(double x, double y) {
		this.x += x;
		this.y += y;
	}

}
