package uvsq21606235.forme;

import static org.junit.Assert.*;

import org.junit.Test;

import uvsq21606235.formes.*;

public class TestTriangle {

	@Test
	public void testConstruction() {
		Point p1 = new Point(2,2);
		Point p2 = new Point(5,5);
		Point p3 = new Point(7,7);
		
		Triangle t = new Triangle("triangle",p1,p2,p3);
		assertTrue(t.getNomForme().equals("triangle")
				&& p1.getX() == t.getP(0).getX() && p1.getY() == t.getP(0).getY()
				&& p2.getX() == t.getP(1).getX() && p2.getY() == t.getP(1).getY()
				&& p3.getX() == t.getP(2).getX() && p3.getY() == t.getP(2).getY());
	}
	
	@Test
	public void testDeplace() {
		Point p1 = new Point(2,2);
		Point p2 = new Point(5,5);
		Point p3 = new Point(7,7);
		
		Triangle t = new Triangle("triangle",p1,p2,p3);
		
		t.deplace(2, 3);
		
		assertTrue(t.getP(0).getX() == p1.getX()+2 && t.getP(0).getY() == p1.getY()+3 
				&&  t.getP(1).getX() == p2.getX()+2 && t.getP(1).getY() == p2.getY()+3
				&& t.getP(2).getX() == p3.getX()+2 && t.getP(2).getY() == p3.getY()+3);
	}

}
