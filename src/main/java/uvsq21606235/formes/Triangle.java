package uvsq21606235.formes;


public class Triangle extends Formes {

	/**
	 * représentation des trois points d'un triangle
	 */
	private Point[] p;
	
	
	public Point getP(int indice) {
			return p[indice].clone();
	}
	
	
	 
	public Triangle(String nomF,Point p1,Point p2, Point p3) {
		super(nomF);
		// TODO Auto-generated constructor stub
		p = new Point[3];
		this.p[0] = p1.clone();
		this.p[1] = p2.clone();
		this.p[2] = p3.clone();
	}

	@Override
	public void deplace(double x, double y) {
		// TODO Auto-generated method stub
		for(int i=0; i<3; i++) {
			p[i].deplace(x, y);
		}
		
	}
	
	/**
	 * affichage d'un triangle
	 */
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println("point n°1 : "+ p[0] +" point n°2 : "+ p[1] + "point n°1 : "+ p[2] );
	}

}
