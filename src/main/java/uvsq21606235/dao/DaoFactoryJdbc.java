package uvsq21606235.dao;

import java.sql.Connection;
import java.sql.SQLException;

import uvsq21606235.bdd.BaseDeDonnees;

import uvsq21606235.formes.*;

public class DaoFactoryJdbc {
	
	private Connection conn;
   
	
    public DaoFactoryJdbc() {
        conn = BaseDeDonnees.connection();
    }
   
 
    public DAO<Cercle> createDaoCercle() {
        return new DaoCercleJdbc(conn);
    }
    
    public DAO<Carre> createDaoCarre() {
        return new DaoCarreJdbc(conn);
    }
  
    public DAO<Rectangle> createDaoRectangle() {
        return new DaoRectangleJdbc(conn);
    }
  
    public DAO<Triangle> createDaoTriangle() {
        return new DaoTriangleJdbc(conn);
    }
    
    public DAO<EnsembleForme> createDaoGroupeForme() {
        return new DaoEnsembleFormeJdbc(conn);
    }

}
