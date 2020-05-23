package uvsq21606235.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.umd.cs.findbugs.gui2.Driver;
import uvsq21606235.bdd.BaseDeDonnees;
import uvsq21606235.formes.Cercle;
import uvsq21606235.formes.Cercle;
import uvsq21606235.formes.Point;

public class DaoCercleJdbc extends DAO<Cercle>{

private static Connection conn;
	
	
	
	public DaoCercleJdbc(Connection conn) throws SQLException {
		this.conn = DriverManager.getConnection(BaseDeDonnees.url);
	}


	


	/**
	 * insertion des données du cercle dans la table Cercle
	 */
	@Override
	public Cercle create(Cercle c) {
		// TODO Auto-generated method stub
		System.out.println("je suis dans creat");
		int verif = 0;
		try {Connection connec = BaseDeDonnees.getConnection();
            PreparedStatement prepare = connec.prepareStatement(
                    "INSERT INTO Formes"
                    + " (nomForme)"+ " VALUES(?)");
                    prepare.setString(1, c.getNomForme());
                    prepare.executeUpdate();
            String inser =  "INSERT INTO Cercle (nomForme,centre_x,centre_y,rayon) VALUES(?, ?, ?, ?)";
            prepare = conn.prepareStatement(inser);
            prepare.setString(1, c.getNomForme());
            prepare.setDouble(2, c.getCentre().getX());
            prepare.setDouble(3, c.getCentre().getY());
            prepare.setDouble(4, c.getRayon());
            verif = prepare.executeUpdate();
            connec.close();
        }  catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
		
		if(verif > 0) {
			System.out.println("Insertion d'un cercle réussi");
			return c;
		}
		System.out.println("le cercle existe");
		return c;
			
	}

	
	/**
	 * obtention d'un cercle à l'aide de sa clé primaire
	 */
	@Override
	public Cercle find(String nomF) {
		// TODO Auto-generated method stub
        
        String select = "SELECT * FROM Cercle WHERE nomForme = ?";
        Cercle c = null;
        
        try {
            PreparedStatement prepare = conn.prepareStatement(select);
            prepare.setString(1, nomF);
            prepare.execute();
            ResultSet resultat = prepare.getResultSet();
            
            if (resultat.next()) {
                try {
                    c = new Cercle(nomF,new Point(resultat.getDouble("centre_x"),resultat.getDouble("centre_y"))
                    		, resultat.getDouble("rayon"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            c = null;
            return c;
        }
        return c;
  
}

	@Override
	public void delete(Cercle c) {
		// TODO Auto-generated method stub
		String del = "DELETE FROM Cercle WHERE nomForme = ?";
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
	 * mise à jour d'un cercle considéré existant
	 */
	@Override
	public Cercle update(Cercle c) {
		// TODO Auto-generated method stub
		int verif = 0;
        String update = "UPDATE Cercle SET origine_x = ?, origine_y = ?, cote = ? WHERE nomForme = ?";
   
        try {
            PreparedStatement prepare = conn.prepareStatement(update);
            prepare.setString(1, c.getNomForme());
            prepare.setDouble(2, c.getCentre().getX());
            prepare.setDouble(3, c.getCentre().getY());
            prepare.setDouble(4, c.getRayon());
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
