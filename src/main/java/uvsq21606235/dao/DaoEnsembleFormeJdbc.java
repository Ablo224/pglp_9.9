package uvsq21606235.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import uvsq21606235.formes.*;

public class DaoEnsembleFormeJdbc extends DAO<EnsembleForme> {

	private Connection conn;
	
	public DaoEnsembleFormeJdbc(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}
	
	/**
	 * insertion des données résultant de l'ensemble des formes
	 * @param idG
	 * @param idC
	 */
   public void createRelation(String idG, String idC) {
    
	   String inser = "INSERT INTO Relation (idG, idC) VALUES(?, ?)";
        try {
            PreparedStatement prepare = conn.prepareStatement(inser);
            prepare.setString(1, idG);
            prepare.setString(2, idC);
            prepare.executeUpdate();
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
    }
	
	@Override
	public EnsembleForme create(EnsembleForme forme) throws SQLException {
		// TODO Auto-generated method stub
        DaoFactoryJdbc factory = new DaoFactoryJdbc();
        try {
            PreparedStatement prepare = conn.prepareStatement(
                    "INSERT INTO Formes"
                    + " (nomForme)"
                    + " VALUES(?)");
            prepare.setString(1, forme.getNomForme());
            prepare.executeUpdate();
            prepare = conn.prepareStatement(
                    "INSERT INTO EnsembleForme"
                    + " (nomForme)"
                    + " VALUES(?)");
            prepare.setString(1, forme.getNomForme());
            prepare.executeUpdate();
            for (Formes f : forme.getListForme()) {
                if (f.getClass() == Cercle.class) {
                    DAO<Cercle> dao = factory.createDaoCercle();
                    dao.create((Cercle) f);
                } else if (f.getClass() == Carre.class) {
                    DAO<Carre> dao = factory.createDaoCarre();
                    dao.create((Carre) f);
                } else if (f.getClass() == Rectangle.class) {
                    DAO<Rectangle> dao = factory.createDaoRectangle();
                    dao.create((Rectangle) f);
                } else if (f.getClass() == Triangle.class) {
                    DAO<Triangle> dao = factory.createDaoTriangle();
                    dao.create((Triangle) f);
                } else {
                    this.create((EnsembleForme) f);
                }
                this.createRelation(
                        forme.getNomForme(), f.getNomForme());
            }
            conn.close();
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return forme;
	}
	
	/**
	 * retourne un ensemble de groupe
	 * @param nomF
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<Formes> findGroupe(String nomF) throws SQLException {
		String select =  "SELECT idC FROM Relation WHERE idG = ?";
        ArrayList<Formes> find = new ArrayList<Formes>();
        DaoFactoryJdbc factory = new DaoFactoryJdbc();
        try {
            PreparedStatement prepare = conn.prepareStatement(select);
            prepare.setString(1, nomF);
            prepare.execute();
            ResultSet result = prepare.getResultSet();
            DAO<Cercle> dCe = factory.createDaoCercle();
            DAO<Carre> dCa = factory.createDaoCarre();
            DAO<Rectangle> dR = factory.createDaoRectangle();
            DAO<Triangle> dT = factory.createDaoTriangle();
            
            while (result.next()) {
                Formes f = dCe.find(result.getString("idC"));
                if (f == null) {
                    f = dCa.find(result.getString("idC"));
                }
                if (f == null) {
                    f = dR.find(result.getString("idC"));
                }
                if (f == null) {
                    f = dT.find(result.getString("idC"));
                }
                if (f == null) {
                    f = this.find(result.getString("idC"));
                }
                find.add(f);
            }
            conn.close();
        } catch (SQLException e) {
            return new ArrayList<Formes>();
        }
        return find;
    }
	
	/**
	 * obtention d'un tuple
	 */
	@Override
	public EnsembleForme find(String nomF) {
		// TODO Auto-generated method stub
        EnsembleForme find = null;
        String s = "SELECT * FROM GroupeForme WHERE nomForme = ?";
        try {
            PreparedStatement prepare = conn.prepareStatement(s);
            prepare.setString(1, nomF);
            prepare.execute();
            ResultSet result = prepare.getResultSet();
            if (result.next()) {
                find = new EnsembleForme(nomF);
                ArrayList<Formes> list = findGroupe(nomF);
                for (Formes f : list) {
                    find.ajoutForme(f);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return find;
	}
	
	/**
	 * suppression d'un element DAO
	 */
	@Override
	public void delete(EnsembleForme object) {
		// TODO Auto-generated method stub
		String del = "DELETE FROM EnsembleForme WHERE variableName = ?";
		String delF =  "DELETE FROM Formes WHERE variableName = ?";
        try {
            PreparedStatement prepare = conn.prepareStatement(del);
            prepare.setString(1, object.getNomForme());
            prepare.executeUpdate();
            prepare = conn.prepareStatement(delF);
            prepare.setString(1, object.getNomForme());
            prepare.executeUpdate();
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
		
	}

	
	/**
	 * mise à jour d'un element du DAO
	 * @throws SQLException 
	 */
	@Override
	public EnsembleForme update(EnsembleForme object) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Formes> listing = this.findGroupe(object.getNomForme());
		
        if (!listing.isEmpty()) {
            DaoFactoryJdbc factory = new DaoFactoryJdbc();
            for (Formes f : object.getListForme()) {
                if (f.getClass() == Cercle.class) {
                    DAO<Cercle> dao = factory.createDaoCercle();
                    dao.create((Cercle) f);
                } else if (f.getClass() == Carre.class) {
                	DAO<Carre> dao = factory.createDaoCarre();
                    dao.create((Carre) f);
                } else if (f.getClass() == Rectangle.class) {
                	DAO<Rectangle> dao = factory.createDaoRectangle();
                    dao.create((Rectangle) f);
                } else if (f.getClass() == Triangle.class) {
                	DAO<Triangle> dao = factory.createDaoTriangle();
                    dao.create((Triangle) f);
                } else {
                    this.create((EnsembleForme) f);
                }
                this.createRelation(object.getNomForme(), f.getNomForme());
            }
        } else {
            return null;
        }
        return object;
	}

}
