package uvsq21606235;

import static org.junit.Assert.*;

import org.junit.Test;

import uvsq21606235.formes.Cercle;
import uvsq21606235.formes.Point;

public class TestCercle {


	@Test
	public void testConstruction() {
		Point p = new Point(2,3);
		Cercle c = new Cercle("cercle",p,5);
		assertTrue(c.getNomForme().equals("cercle") && c.getCentre().getX() == p.getX() 
				&& c.getCentre().getY() == p.getY()   && c.getRayon() == 5);
	}
	
	
	@Test
	public void testDeplace() {
		Cercle c = new Cercle("carré", new Point(2,3), 3);
		c.deplace(3, 4);
		assertTrue(c.getCentre().getX() == 5 && c.getCentre().getY() == 7);
	}

}
