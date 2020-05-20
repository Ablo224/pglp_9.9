package uvsq21606235.formes;

import java.util.ArrayList;
import java.util.Iterator;

public class EnsembleForme extends Formes implements Iterable<Formes> {

	/**
	 * L'ensemble des formes
	 */
	private ArrayList<Formes> lesFormes;
	
	public EnsembleForme(String nomF) {
		super(nomF);
		// TODO Auto-generated constructor stub
		lesFormes = new ArrayList<Formes>();
	}
	
	public ArrayList<Formes> getListForme(){
		return (ArrayList<Formes>) lesFormes.clone();
		
	}
	
	public void ajoutForme(Formes f) {
		if(!lesFormes.contains(f)) {
			lesFormes.add(f);
		}
		
	}
	
	public void supprimerForme(Formes f) {
		if(lesFormes.contains(f))
			lesFormes.remove(f);
	}

	@Override
	public Iterator<Formes> iterator() {
		// TODO Auto-generated method stub
		return lesFormes.iterator();
	}

	@Override
	public void deplace(double x, double y) {
		// TODO Auto-generated method stub
		for(Formes f: lesFormes)
			f.deplace(x, y);
		
	}
	
	public void print() {
		// TODO Auto-generated method stub
		super.print();
		System.out.println("Ensemble de forme (");
			for(Formes f: lesFormes) {
				f.print();
			}
			System.out.println(")");
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
