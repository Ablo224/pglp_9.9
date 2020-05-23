package uvsq21606235.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import uvsq21606235.formes.Rectangle;
import uvsq21606235.bdd.BaseDeDonnees;
import uvsq21606235.formes.Point;


public class DaoRectangleJdbc extends DAO<Rectangle>{

	private static Connection conn;
	
	
	
	public DaoRectangleJdbc(Connection conn)  {
		this.conn = conn;
	}


	/**
	 * insertion des données du carré dans la table Rectangle
	 */
	@Override
	public Rectangle create(Rectangle c) {
		// TODO Auto-generated method stub
		System.out.println("Je suis dans creat rectangle");
		int verif = 0;
		try {
            PreparedStatement prepare = conn.prepareStatement(
                    "INSERT INTO Formes"
                    + " (nomForme)"+ " VALUES(?)");
                    prepare.setString(1, c.getNomForme());
                    prepare.executeUpdate();
            String inser =  "INSERT INTO Rectangle (nomForme,origine_x,origine_y,longueur,largeur) VALUES(?, ?, ?, ?, ?)";
            prepare = conn.prepareStatement(inser);
            prepare.setString(1, c.getNomForme());
            prepare.setDouble(2, c.getOrigine().getX());
            prepare.setDouble(3, c.getOrigine().getY());
            prepare.setDouble(4, c.getLongueur());
            prepare.setDouble(5, c.getLargeur());
            verif = prepare.executeUpdate();
            conn.close();
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
		
		if(verif > 0) {
			System.out.println("Insertion d'un carré réussi");
			return c;
		}
		return c;
			
	}

	
	/**
	 * obtention d'un carré à l'aide de sa clé primaire
	 */
	@Override
	public Rectangle find(String nomF) {
		// TODO Auto-generated method stub
        
        String select = "SELECT * FROM Rectangle WHERE nomForme = ?";
        Rectangle c = null;
        
        try {
            PreparedStatement prepare = conn.prepareStatement(select);
            prepare.setString(1, nomF);
            prepare.execute();
            ResultSet resultat = prepare.getResultSet();
            
            if (resultat.next()) {
                try {
                    c = new Rectangle(nomF,new Point(resultat.getDouble("origine_x"),resultat.getDouble("origine_y"))
                    		, resultat.getDouble("longueur"),resultat.getDouble("largeur"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return c;
  
}

	@Override
	public void delete(Rectangle c) {
		// TODO Auto-generated method stub
		String del = "DELETE FROM Rectangle WHERE nomForme = ?";
	        try {
	            PreparedStatement prepare = conn.prepareStatement(del);
	            prepare.setString(1, c.getNomForme());
	            prepare.executeUpdate();
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	/**
	 * mise à jour d'un carré considéré existant
	 */
	@Override
	public Rectangle update(Rectangle c) {
		// TODO Auto-generated method stub
		int verif = 0;
        String update = "UPDATE Rectangle SET origine_x = ?, origine_y = ?, longueur = ?, largeur = ? WHERE nomForme = ?";
   
        try {
            PreparedStatement prepare = conn.prepareStatement(update);
            prepare.setString(1, c.getNomForme());
            prepare.setDouble(2, c.getOrigine().getX());
            prepare.setDouble(3, c.getOrigine().getY());
            prepare.setDouble(4, c.getLongueur());
            prepare.setDouble(5, c.getLargeur());
            verif = prepare.executeUpdate();
            if(verif > 0) {
            	System.out.println("La mise à jour de la  forme "+ c.getNomForme() + " a bien réussi ");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return c;
	}


}
