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
		assertTrue(t.getNomForme().equals("triangle"));
				
	}
	
	@Test
	public void testDeplace() {
//		Point p1 = new Point(2,2);
//		Point p2 = new Point(5,5);
//		Point p3 = new Point(7,7);
//		
//		Triangle t = new Triangle("triangle",p1,p2,p3);
//		
//		t.deplace(2, 3);
//		
//		assertTrue(t.getH().getX() == p1.getX()+2 && t.getH().getY() == p1.getY()+3 
//				&&  t.getBg().getX() == p2.getX()+2 && t.getBg().getY() == p2.getY()+3
//				&& t.getBd().getX() == p3.getX()+2 && t.getBd().getY() == p3.getY()+3);
	}

}
