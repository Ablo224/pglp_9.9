package uvsq21606235.bdd;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * test de création de la bdd et de ces tables
 * @author ablo
 *
 */
public class TestBdd {

	@Before
	public void testCreatForme() {
		BaseDeDonnees bdd = new BaseDeDonnees();
		bdd.deleteTables();
		bdd.createtableForme();
		bdd.creatTableEnsembleForme();
	}
	

	
	@Test
	public void testCreatCercle() {
		BaseDeDonnees bdd = new BaseDeDonnees();
		bdd.creatTableCercle();

	}
	
	
	@Test
	public void testCreatCarre() {
		BaseDeDonnees bdd = new BaseDeDonnees();
		bdd.creatTableCarre();
	}
	
	@Test
	public void testCreatRectangle() {
		BaseDeDonnees bdd = new BaseDeDonnees();
		bdd.creatTableRectangle();

	}
	
	@Test
	public void testCreatTriangle() {
		BaseDeDonnees bdd = new BaseDeDonnees();
		bdd.creatTableTriangle();

	}
	
	@Test
	public void testCreatRelationComposition() {
		BaseDeDonnees bdd = new BaseDeDonnees();
		bdd.creatTableRealation();

	}
	
	

}
