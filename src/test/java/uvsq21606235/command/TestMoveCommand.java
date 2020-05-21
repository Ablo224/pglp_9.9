package uvsq21606235.command;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import uvsq21606235.*;
import uvsq21606235.formes.*;


public class TestMoveCommand {

	@Test
	public void moveCommandTestTriangle() throws SQLException {
		Formes f = new Triangle("Tr", new Point(3,3), new Point(2,2),new Point(4,2));
		GestionFormes g =  new GestionFormes();
		g.getFormes().put("f", f);
		MoveFormeCommand v = new MoveFormeCommand(g, "f", "(7, 7))");
		System.out.println(v.execute());
		assertTrue(v.execute().equals("move success") );
		ViewFormeCommand v1 = new ViewFormeCommand(g, "f");
		assertTrue(v1.execute().equals("Tr(point_haut=(7.0,7.0),point_bas_gouche=(7.0,7.0),point_bas_droit=(7.0,7.0)"));

	}
	
	@Test
	public void moveCommandTestRectangle() throws SQLException {
		Formes f = new Rectangle("Re", new Point(3,3), 2, 8);
		GestionFormes g =  new GestionFormes();
		g.getFormes().put("f", f);
		MoveFormeCommand v = new MoveFormeCommand(g, "f", "(7, 7))");
		System.out.println(v.execute());
		assertTrue(((Rectangle) f).getOrigine().getX() == 7.0 && ((Rectangle) f).getOrigine().getY()==7.0);
		assertTrue(v.execute().equals("move success") );
	}
	
	@Test
	public void moveCommandTestCarre() throws SQLException {
		Formes f = new Carre("Ca", new Point(3,3), 8);
		GestionFormes g =  new GestionFormes();
		g.getFormes().put("f", f);
		MoveFormeCommand v = new MoveFormeCommand(g, "f", "(7, 7))");
		System.out.println(v.execute());
		assertTrue(((Carre) f).getOrigine().getX() == 7.0 && ((Carre) f).getOrigine().getY()==7.0);
		assertTrue(v.execute().equals("move success") );
	}
	
	@Test
	public void moveCommandTestCercle() throws SQLException {
		Formes f = new Cercle("Ce", new Point(3,3), 8);
		GestionFormes g =  new GestionFormes();
		g.getFormes().put("f", f);
		MoveFormeCommand v = new MoveFormeCommand(g, "f", "(7, 7))");
		System.out.println(v.execute());
		assertTrue(((Cercle) f).getCentre().getX() == 7.0 && ((Cercle) f).getCentre().getY()==7.0);
		assertTrue(v.execute().equals("move success") );
	}

}
