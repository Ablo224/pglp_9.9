package uvsq21606235;

import static org.junit.Assert.*;

import org.junit.Test;

import uvsq21606235.formes.*;

public class TestRectangle {

	@Test
	public void testConstruction() {
		Point p = new Point(2,3);
		Rectangle r = new Rectangle("rectangle",p,7,4);
		assertTrue(r.getNomForme().equals("rectangle") && r.getOrigine().getX() == p.getX() 
				&& r.getOrigine().getY() == p.getY()   && r.getLongueur() == 7 && r.getLargeur() == 4);
	}
	
	
	@Test
	public void testDeplace() {
		Rectangle r = new Rectangle("rectangle", new Point(2,3), 7,4);
		r.deplace(3, 4);
		assertTrue(r.getOrigine().getX() == 5 && r.getOrigine().getY() == 7);
	}
	
}
