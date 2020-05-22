package uvsq21606235.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import uvsq21606235.formes.Carre;
import uvsq21606235.formes.Cercle;
import uvsq21606235.formes.EnsembleForme;
import uvsq21606235.formes.Point;
import uvsq21606235.formes.Rectangle;
import uvsq21606235.formes.Triangle;

public class TestDaoCreateJdbc {
	
	
	
	@Test
	public void testCreateCarre() throws SQLException{
		
		DaoFactoryJdbc df = new DaoFactoryJdbc();
		DAO<Carre> daoC = df.createDaoCarre();
		DAO<EnsembleForme> daoG = df.createDaoGroupeForme();
		
		EnsembleForme g1 = new EnsembleForme("G1");
		assertNotNull(daoG.create(g1)); 
		Carre c = new Carre("Ca", new Point(2,3), 3);
		assertNotNull(daoC.create(c));
	}
	
	
	@Test
	public void testCreateRectangle() throws SQLException{
		
		DaoFactoryJdbc df = new DaoFactoryJdbc();
		DAO<Rectangle> daoC = df.createDaoRectangle();
		DAO<EnsembleForme> daoG = df.createDaoGroupeForme();
		
		EnsembleForme g2 = new EnsembleForme("G2");
		assertNotNull(daoG.create(g2)); 
		Rectangle r = new Rectangle("Re", new Point(2,3), 3, 4);
		assertNotNull(daoC.create(r));
	}
	
	@Test
	public void testCreateTriangle() throws SQLException{
		
		DaoFactoryJdbc df = new DaoFactoryJdbc();
		DAO<Triangle> daoC = df.createDaoTriangle();
		DAO<EnsembleForme> daoG = df.createDaoGroupeForme();
		
		EnsembleForme g3 = new EnsembleForme("G3");
		assertNotNull(daoG.create(g3)); 
		Triangle r = new Triangle("Tr", new Point(2,3), new Point(5,3),new Point(2,9));
		assertNotNull(daoC.create(r));
	}
	
	@Test
	public void testCreateCercle() throws SQLException{
		
		DaoFactoryJdbc df = new DaoFactoryJdbc();
		DAO<Cercle> daoC = df.createDaoCercle();
		DAO<EnsembleForme> daoG = df.createDaoGroupeForme();
		
		EnsembleForme g4 = new EnsembleForme("G4");
		assertNotNull(daoG.create(g4)); 
		Cercle r = new Cercle("Cer", new Point(2,3), 5);
		assertNotNull(daoC.create(r));
	}
	
}
