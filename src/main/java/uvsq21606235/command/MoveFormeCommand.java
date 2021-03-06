package uvsq21606235.command;

import java.sql.SQLException;

import uvsq21606235.dao.*;
import uvsq21606235.formes.*;

public class MoveFormeCommand implements Command {

	private GestionFormes gestionFormes;
	private String forme;
	private String param;
	
	public MoveFormeCommand(GestionFormes gestionFormes, String f, String param)
	{
		this.gestionFormes = gestionFormes;
		this.forme = f;
		this.param = param;
	}
	
	@Override
	public String execute()
	{
		return gestionFormes.move(this.forme, this.param);
	}


	public GestionFormes getGestionFormes() {
		return gestionFormes;
	}

	public void setGestionFormes(GestionFormes gestionFormes) {
		this.gestionFormes = gestionFormes;
	}

	public String getF() {
		return forme;
	}

	public void setF(String f) {
		this.forme = f;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
	
//	private Formes forme;
//	
//	private Point p;
//	
//	public  MoveCommand(Formes f, Point p) {
//		// TODO Auto-generated constructor stub
//		this.forme = f;
//		this.p = p.clone();
//	}
//	
//	@Override
//	public String execute() throws SQLException {
//		// TODO Auto-generated method stub
//		forme.deplace(p.getX(), p.getY());
//		DaoFactoryJdbc dfj = new DaoFactoryJdbc();
//		
//		if(forme.getClass() == Carre.class) {
//			DAO<Carre> dCa = dfj.createDaoCarre();
//			dCa.update((Carre) forme);
//		}else if(forme.getClass() == Rectangle.class) {
//			DAO<Rectangle> dRe = dfj.createDaoRectangle();
//			dRe.update((Rectangle) forme);
//		}else if(forme.getClass() == Cercle.class) {
//			DAO<Cercle> dCe = dfj.createDaoCercle();
//			dCe.update((Cercle) forme);
//		}else if(forme.getClass() == Triangle.class) {
//			DAO<Triangle> dTr = dfj.createDaoTriangle();
//			dTr.update((Triangle) forme);
//		}else {
//			DAO<EnsembleForme> dEf = dfj.createDaoGroupeForme();
//			dEf.update((EnsembleForme) forme);
//		}
//		return null;
//	}

}
