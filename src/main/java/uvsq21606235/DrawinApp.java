package uvsq21606235;

import uvsq21606235.*;
import uvsq21606235.command.*;


/**
 * class principale qui lance l'application
 * @author ablo
 *
 */
public class DrawinApp 
{
	 public static void main( String[] args) throws Exception
	    {
		 	System.out.println("---------------------APPLICATION DE DESSIN------------------------");
		 	System.out.println("------------------Format valide pour créer des figures :-----------");
		 	System.out.println("Création Rectangle: ---Re = Rectangle((origine_x, origine_y), (Longueur, largeur))");
		 	System.out.println("Création Carre:  ------Ca = Carre((origine_x, origine_y), coté)");
		 	System.out.println("Création Cercle: ------Ce = Cercle((centre_x, centre_y ), rayon)");
		 	System.out.println("Création Triangle: ----Tr = Triangle((p1_x, p1_y ), (p2_x, p2_y ), (p3_x, p3_y ))");
		 	System.out.println("Pour deplacer une figure: move(nom_figure, (p1_x, p1_y)) ");
		 	System.out.println("Pour deplacer l'ensemble des formes: move(All, (p1_x, p1_y))");
		 	System.out.println("Pour quitter: exit");
		 	System.out.println("Exemple de création:\n"
		 			+ "------------Ca = Carre((2, 5), 7)\n" 
		 			+"--------------Re = Rectangle((3, 4), (4, 8))\n" 
		 			+"--------------Tr = Triangle((3, 4), (4, 8), (0, 0))\n" 
		 			+"--------------Ce = Cercle((2, 5), 7)");
		 	System.out.println("A vous de jouer:");
		 	
	    	GestionFormes gestionFormes = new GestionFormes();
	    	DrawinTUI saisie = new DrawinTUI(gestionFormes);
	    	saisie.nextCOmmand(args);
	    }
}
