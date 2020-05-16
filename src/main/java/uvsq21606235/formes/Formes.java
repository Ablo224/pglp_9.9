package uvsq21606235.formes;

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

}
