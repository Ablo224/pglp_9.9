package uvsq21606235;

import uvsq21606235.bdd.BaseDeDonnees;
import uvsq21606235.command.DrawinTUI;
import uvsq21606235.command.GestionFormes;

/**
 * Hello world!
 *
 */
public class DrawinApp 
{
	 public static void main( String[] args) throws Exception
	    {
	    	GestionFormes gestionFormes = new GestionFormes();
	    	DrawinTUI saisie = new DrawinTUI(gestionFormes);
	    	saisie.saisieUser(args);
	    }
}
