package uvsq21606235.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import uvsq21606235.formes.Point;
import uvsq21606235.formes.Triangle;

public class DaoTriangleJdbc extends DAO<Triangle> {

private Connection conn = null;
	
	
	public DaoTriangleJdbc(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}


	/**
	 * insertion des données du triangle dans la table Triangle
	 */
	@Override
	public Triangle create(Triangle t) {
		// TODO Auto-generated method stub
		int verif = 0;
		try {
            PreparedStatement prepare = conn.prepareStatement(
                    "INSERT INTO Formes"
                    + " (nomForme)"+ " VALUES(?)");
                    prepare.setString(1, t.getNomForme());
                    prepare.executeUpdate();
            String inser =  "INSERT INTO Triangle (nomForme,p1_x, p1_y, p2_x, p2_y, p3_x, p3_y) VALUES(?, ?, ?, ?, ?, ?, ?)";
            prepare = conn.prepareStatement(inser);
            prepare.setString(1, t.getNomForme());
            prepare.setDouble(2, t.getH().getX());
            prepare.setDouble(3, t.getH().getY());
            prepare.setDouble(4, t.getBg().getX());
            prepare.setDouble(5, t.getBg().getY());
            prepare.setDouble(6, t.getBd().getX());
            prepare.setDouble(7, t.getBd().getY());
            verif = prepare.executeUpdate();
            conn.close();
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
		
		if(verif > 0) {
			System.out.println("Insertion d'un carré réussi");
			return t;
		}
		return t;
			
	}

	
	/**
	 * obtention d'un carré à l'aide de sa clé primaire
	 */
	@Override
	public Triangle find(String nomF) {
		// TODO Auto-generated method stub
        
        String select = "SELECT * FROM Triangle WHERE nomForme = ?";
        Triangle c = null;
        
        try {
        	
            PreparedStatement prepare = conn.prepareStatement(select);
            prepare.setString(1, nomF);
            prepare.execute();
            ResultSet resultat = prepare.getResultSet();
            
            if (resultat.next()) {
                try {
                    c = new Triangle(nomF,new Point(resultat.getDouble("p1_x"),resultat.getDouble("p1_y"))
                    		, new Point(resultat.getDouble("p2_x"),resultat.getDouble("p2_y")) 
                    		,new Point (resultat.getDouble("p3_xr"),resultat.getDouble("p3_y")));
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
	public void delete(Triangle c) {
		// TODO Auto-generated method stub
		String del = "DELETE FROM Triangle WHERE nomForme = ?";
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
	 * mise à jour d'un triangle considéré existant
	 */
	@Override
	public Triangle update(Triangle t) {
		// TODO Auto-generated method stub
		int verif = 0;
        String update = "UPDATE Triangle SET p1_x = ?, p1_y = ?, p2_x = ?, p2_y = ?, p3_x = ?, p3_y =? WHERE nomForme = ?";
   
        try {
            PreparedStatement prepare = conn.prepareStatement(update);
            prepare.setString(1, t.getNomForme());
            prepare.setDouble(2, t.getH().getX());
            prepare.setDouble(3, t.getH().getY());
            prepare.setDouble(4, t.getBg().getX());
            prepare.setDouble(5, t.getBg().getY());
            prepare.setDouble(6, t.getBd().getX());
            prepare.setDouble(7, t.getBd().getY());
            verif = prepare.executeUpdate();
            if(verif > 0) {
            	System.out.println("La mise à jour de la  forme "+ t.getNomForme() + " a bien réussi ");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return t;
	}

}
