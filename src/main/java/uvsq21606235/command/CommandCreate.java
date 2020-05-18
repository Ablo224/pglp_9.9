package uvsq21606235.command;

import java.sql.SQLException;

import uvsq21606235.dao.*;
import uvsq21606235.dao.DaoFactoryJdbc;
import uvsq21606235.formes.*;

public class CommandCreate implements Command {
	
	private Formes forme;
	
	public CommandCreate(Formes f) {
        this.forme = f;
    }

	@Override
	public void execute() throws SQLException {
		// TODO Auto-generated method stub
		Formes f = null;
		DaoFactoryJdbc dfj = new DaoFactoryJdbc();
		
		if(forme.getClass() == Carre.class) {
			DAO<Carre> dCa = dfj.createDaoCarre();
			f = dCa.create((Carre) forme);
		}else if(forme.getClass() == Rectangle.class) {
			DAO<Rectangle> dRe = dfj.createDaoRectangle();
			f = dRe.create((Rectangle) forme);
		}else if(forme.getClass() == Cercle.class) {
			DAO<Cercle> dCe = dfj.createDaoCercle();
			f = dCe.create((Cercle) forme);
		}else if(forme.getClass() == Triangle.class) {
			DAO<Triangle> dTr = dfj.createDaoTriangle();
			f = dTr.create((Triangle) forme);
		}else {
			DAO<EnsembleForme> dEf = dfj.createDaoGroupeForme();
			f = dEf.create((EnsembleForme) forme);
		}
		if (f == null) {
            System.err.println("Forme inexistante");
        }
	}

}
