package uvsq21606235.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import uvsq21606235.formes.Carre;
import uvsq21606235.formes.EnsembleForme;
import uvsq21606235.formes.Point;

public class TestDaoFindJdbc {

	@Test
	public void testCreateCarre() throws SQLException{
		
		DaoFactoryJdbc df = new DaoFactoryJdbc();
		DAO<Carre> daoC = df.createDaoCarre();
		DAO<EnsembleForme> daoG = df.createDaoGroupeForme();
		
		EnsembleForme g5 = new EnsembleForme("G");
		Carre c = new Carre("Ca", new Point(2,3), 3);
		assertNotNull(daoC.find(c.getNomForme()));
	}
	
	
}