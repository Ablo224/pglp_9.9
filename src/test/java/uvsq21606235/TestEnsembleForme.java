package uvsq21606235;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ibm.icu.text.Edits.Iterator;

import uvsq21606235.formes.Carre;
import uvsq21606235.formes.EnsembleForme;
import uvsq21606235.formes.Formes;
import uvsq21606235.formes.Point;
import uvsq21606235.formes.Rectangle;

public class TestEnsembleForme {


	@Test
	public void testAjoutForme() {
		EnsembleForme forme = new EnsembleForme("CARRES");
		Carre c = new Carre("carré", new Point(2,3), 3);
		Carre c1 = new Carre("carré2", new Point(2,3), 3);
		
		forme.ajoutForme(c);
		forme.ajoutForme(c1);
		assertTrue(forme.getListForme().size() == 2 );
		assertTrue(forme.getListForme().get(0) == c);
		assertTrue(forme.getListForme().get(1) == c1);
	}
	
	@Test
	public void testSupprimerForme() {
		EnsembleForme forme = new EnsembleForme("CARRES");
		Carre c = new Carre("carré", new Point(2,3), 3);
		Carre c1 = new Carre("carré2", new Point(2,3), 3);
		
		forme.ajoutForme(c);
		forme.ajoutForme(c1);
		forme.supprimerForme(c);
		
		assertTrue(forme.getListForme().size() == 1 );
		assertTrue(forme.getListForme().get(0) == c1);
		
		
	}
	
	@Test
	public void testDeplaceForme() {
		EnsembleForme forme = new EnsembleForme("CARRES");
		Carre c = new Carre("carré", new Point(2,3), 3);
		
		forme.ajoutForme(c);
		forme.deplace(2, 3);
		
		assertTrue(c.getOrigine().getX() == 4 && c.getOrigine().getY() == 6);
	}
	
	@Test
	public void testIterator() {
		EnsembleForme forme = new EnsembleForme("CARRES");
		Carre c = new Carre("carré", new Point(2,3), 3);
		
		forme.ajoutForme(c);
		java.util.Iterator<Formes> it = forme.iterator();
		
		assertTrue(it.hasNext() && it.next()== c);
		assertFalse(it.hasNext());
	}
}








