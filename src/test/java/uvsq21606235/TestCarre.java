package uvsq21606235;

import static org.junit.Assert.*;

import org.junit.Test;

import uvsq21606235.formes.*;

public class TestCarre {

	@Test
	public void testConstruction() {
		Point p = new Point(2,3);
		Carre c = new Carre("carré",p,5);
		assertTrue(c.getNomForme().equals("carré") && c.getOrigine().getX() == p.getX() 
				&& c.getOrigine().getY() == p.getY()   && c.getCote() == 5);
	}
	
	
	@Test
	public void testDeplace() {
		Carre c = new Carre("carré", new Point(2,3), 3);
		c.deplace(3, 4);
		assertTrue(c.getOrigine().getX() == 5 && c.getOrigine().getY() == 7);
	}
}
