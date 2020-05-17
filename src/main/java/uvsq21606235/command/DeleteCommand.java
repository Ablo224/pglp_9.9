package uvsq21606235.command;

import java.util.ArrayList;

import uvsq21606235.dao.DAO;
import uvsq21606235.dao.DaoFactoryJdbc;
import uvsq21606235.formes.Carre;
import uvsq21606235.formes.Cercle;
import uvsq21606235.formes.EnsembleForme;
import uvsq21606235.formes.Formes;
import uvsq21606235.formes.Point;
import uvsq21606235.formes.Rectangle;
import uvsq21606235.formes.Triangle;

public class DeleteCommand implements Command{

	private ArrayList<Formes> listForme;
	
	
	public  DeleteCommand(ArrayList<Formes> f) {
		// TODO Auto-generated constructor stub
		this.listForme = f;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		DaoFactoryJdbc dfj = new DaoFactoryJdbc();
		
		for(Formes f:  listForme) {
			if(f.getClass() == Carre.class) {
				DAO<Carre> dCa = dfj.createDaoCarre();
				dCa.delete((Carre) f);
			}else if(f.getClass() == Rectangle.class) {
				DAO<Rectangle> dRe = dfj.createDaoRectangle();
				dRe.delete((Rectangle) f);
			}else if(f.getClass() == Cercle.class) {
				DAO<Cercle> dCe = dfj.createDaoCercle();
				dCe.update((Cercle) f);
			}else if(f.getClass() == Triangle.class) {
				DAO<Triangle> dTr = dfj.createDaoTriangle();
				dTr.update((Triangle) f);
			}else {
				DAO<EnsembleForme> dEf = dfj.createDaoGroupeForme();
				dEf.delete((EnsembleForme) f);
			}
		}
	
	}
}
