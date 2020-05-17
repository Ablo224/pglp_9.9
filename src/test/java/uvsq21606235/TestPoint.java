package uvsq21606235;

import static org.junit.Assert.*;

import org.junit.Test;

import uvsq21606235.formes.Point;

public class TestPoint {

	@Test
    public void testConstructionPoint() {
        Point p = new Point(4,6);
        assertFalse(p.getX() == 0 && p.getY() == 1);
    }
	
	
	
	@Test
    public void testToString() {
        Point p = new Point(4,6);
        String s = p.toString();
        System.out.println(s);
        assertTrue(s.equals("(4.0,6.0)"));
    }
	
	
	@Test
	public void testDeplace() {
		Point p = new Point(4,6);
		p.deplace(3, 4);
		assertTrue(p.getX() == 7 && p.getY() == 10);
	}
	
	/**
	 * test du clonage
	 */
    @Test
    public void testClone() {
        Point p1 = new Point(4,6);
        Point p2 = p1.clone();
        assertFalse(p2.getX() != p1.getX() && p2.getY() != p1.getY());
    }
}
