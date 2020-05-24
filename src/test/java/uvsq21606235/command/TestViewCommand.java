package uvsq21606235.command;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import uvsq21606235.formes.*;

import uvsq21606235.command.*;

/**
 * test de l'affichage des formes
 * @author ablo
 *
 */

public class TestViewCommand {

	@Test
	public void viewCommandTestCercle() throws SQLException { // un cercle de centre(3,3) et de rayon = 1
		Cercle c = new Cercle("Ce", new Point(3,3), 1);
		GestionFormes f =  new GestionFormes();
		f.getFormes().put("c", c);
		ViewFormeCommand v = new ViewFormeCommand(f, "c");
		System.out.println(v.execute());
		assertTrue(v.execute().equals("Ce(centre=(3.0,3.0),rayon=1.0)"));
	}
	
	@Test
	public void viewCommandTestRectangle() throws SQLException { 
		Rectangle c = new Rectangle("Re", new Point(3, 4), 4, 8);
;
		GestionFormes f =  new GestionFormes();
		f.getFormes().put("c", c);
		ViewFormeCommand v = new ViewFormeCommand(f, "c");
		System.out.println(v.execute());
		assertTrue(v.execute().equals("Re(point_haut_gauche=(3.0,4.0),Longueur=4.0,Largeur=8.0)"));
	}
	
	@Test
	public void viewCommandTestCarre() throws SQLException { 
		Carre c = new Carre("Ca", new Point(2, 5), 7);

		GestionFormes f =  new GestionFormes();
		f.getFormes().put("c", c);
		ViewFormeCommand v = new ViewFormeCommand(f, "c");
		System.out.println(v.execute());
		assertTrue(v.execute().equals("Ca(Origine=(2.0,5.0), cote=7.0)"));
	}
	
	@Test
	public void viewCommandTestriangle() throws SQLException { 
		Triangle c = new Triangle("Tr",new Point(3, 4), new Point(4, 8),new Point(0, 0));


		GestionFormes f =  new GestionFormes();
		f.getFormes().put("c", c);
		ViewFormeCommand v = new ViewFormeCommand(f, "c");
		System.out.println(v.execute());
		assertTrue(v.execute().equals("Tr(point_haut=(3.0,4.0),point_bas_gouche=(4.0,8.0),point_bas_droit=(0.0,0.0)"));
	}


}
