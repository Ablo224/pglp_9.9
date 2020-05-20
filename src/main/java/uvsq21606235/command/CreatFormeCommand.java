package uvsq21606235.command;

import java.sql.SQLException;

import uvsq21606235.dao.*;
import uvsq21606235.dao.DaoFactoryJdbc;
import uvsq21606235.formes.*;

public class CreatFormeCommand implements Command {
	
	private GestionFormes gestionFormes;
	private String nom;
	private String type;
	private String param;
	
	public CreatFormeCommand(GestionFormes gf,String nomForme, String typeForme, String paramForme)
	{
		this.gestionFormes = gf;
		this.nom = nomForme;
		this.type = typeForme;
		this.param = paramForme;
	}

	@Override
	public String execute()
	{
		return gestionFormes.creat(this.nom, this.type, this.param);
	}
	
	public GestionFormes getGestionFormes() {
		return gestionFormes;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
//	private Formes forme;
//	
//	public CommandCreate(Formes f) {
//        this.forme = f;
//    }

//	@Override
//	public String execute() throws SQLException {
//		// TODO Auto-generated method stub
//		Formes f = null;
//		DaoFactoryJdbc dfj = new DaoFactoryJdbc();
//		
//		if(forme.getClass() == Carre.class) {
//			DAO<Carre> dCa = dfj.createDaoCarre();
//			f = dCa.create((Carre) forme);
//		}else if(forme.getClass() == Rectangle.class) {
//			DAO<Rectangle> dRe = dfj.createDaoRectangle();
//			f = dRe.create((Rectangle) forme);
//		}else if(forme.getClass() == Cercle.class) {
//			DAO<Cercle> dCe = dfj.createDaoCercle();
//			f = dCe.create((Cercle) forme);
//		}else if(forme.getClass() == Triangle.class) {
//			DAO<Triangle> dTr = dfj.createDaoTriangle();
//			f = dTr.create((Triangle) forme);
//		}else {
//			DAO<EnsembleForme> dEf = dfj.createDaoGroupeForme();
//			f = dEf.create((EnsembleForme) forme);
//		}
//		if (f == null) {
//            System.err.println("Forme inexistante");
//        }
//	}

}
