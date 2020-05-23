package uvsq21606235.command;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import uvsq21606235.*;
import uvsq21606235.formes.*;

/**
 * test du pattern MoveCommand
 * @author ablo
 *
 */

public class TestMoveCommand {

	@Test
	public void moveCommandTestTriangle() throws SQLException {
		Formes f = new Triangle("Tr", new Point(3,3), new Point(2,2),new Point(4,2));
		GestionFormes g =  new GestionFormes();
		g.getFormes().put("f", f);
		MoveFormeCommand v = new MoveFormeCommand(g, "f", "(7, 7))");
		System.out.println(v.execute());
		assertTrue(v.execute().equals(f.getNomForme()+" deplacée avec succès") );
	}
	
	@Test
	public void moveCommandTestRectangle() throws SQLException {
		Formes f = new Rectangle("Re", new Point(3,3), 2, 8);
		GestionFormes g =  new GestionFormes();
		g.getFormes().put("f", f);
		MoveFormeCommand v = new MoveFormeCommand(g, "f", "(7, 7))");
		System.out.println(v.execute());
		assertTrue(((Rectangle) f).getOrigine().getX() == 7.0 && ((Rectangle) f).getOrigine().getY()==7.0);
		assertTrue(v.execute().equals(f.getNomForme()+" deplacée avec succès") );
	}
	
	@Test
	public void moveCommandTestCarre() throws SQLException {
		Formes f = new Carre("Ca", new Point(3,3), 8);
		GestionFormes g =  new GestionFormes();
		g.getFormes().put("f", f);
		MoveFormeCommand v = new MoveFormeCommand(g, "f", "(7, 7))");
		System.out.println(v.execute());
		assertTrue(((Carre) f).getOrigine().getX() == 7.0 && ((Carre) f).getOrigine().getY()==7.0);
		assertTrue(v.execute().equals(f.getNomForme()+" deplacée avec succès") );
	}
	
	@Test
	public void moveCommandTestCercle() throws SQLException {
		Formes f = new Cercle("Ce", new Point(3,3), 8);
		GestionFormes g =  new GestionFormes();
		g.getFormes().put("f", f);
		MoveFormeCommand v = new MoveFormeCommand(g, "f", "(7, 7))");
		System.out.println(v.execute());
		assertTrue(((Cercle) f).getCentre().getX() == 7.0 && ((Cercle) f).getCentre().getY()==7.0);
		assertTrue(v.execute().equals(f.getNomForme()+" deplacée avec succès") );
	}

}
