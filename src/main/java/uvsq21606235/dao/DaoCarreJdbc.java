package uvsq21606235.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import uvsq21606235.bdd.BaseDeDonnees;
import uvsq21606235.formes.Carre;
import uvsq21606235.formes.Point;

/**
 * 
 * @author ablo
 *
 */
public class DaoCarreJdbc extends DAO<Carre> {

	private static Connection conn;
	
	
	
	public DaoCarreJdbc(Connection conn) throws SQLException {
		// TODO Auto-generated constructor stub
		BaseDeDonnees bdd = new BaseDeDonnees();
		this.conn = DriverManager.getConnection(bdd.url);
	}


	/**
	 * insertion des données du carré dans la table Carre
	 */
	@Override
	public Carre create(Carre c) {
		// TODO Auto-generated method stub
		int verif = 0;
		try {
            PreparedStatement prepare = conn.prepareStatement(
                    "INSERT INTO Formes"
                    + " (nomForme)"+ " VALUES(?)");
                    prepare.setString(1, c.getNomForme());
                    prepare.executeUpdate();
            String inser =  "INSERT INTO Carre (nomForme,origine_x,origine_y,cote) VALUES(?, ?, ?, ?)";
            prepare = conn.prepareStatement(inser);
            prepare.setString(1, c.getNomForme());
            prepare.setDouble(2, c.getOrigine().getX());
            prepare.setDouble(3, c.getOrigine().getY());
            prepare.setDouble(4, c.getCote());
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
	public Carre find(String nomF) {
		// TODO Auto-generated method stub
        
        String select = "SELECT * FROM Carre WHERE nomForme ="+ nomF;
        Carre c = null;
        
        try {
        	Statement statement = conn.createStatement();
        		    ResultSet resultat = statement.executeQuery("SELECT * FROM Carre WHERE nomForme ="+ nomF);
        	
//            PreparedStatement prepare = conn.prepareStatement(select);
//            prepare.setString(1, nomF);
//            prepare.execute();
//            ResultSet resultat = prepare.getResultSet();
            
            if (resultat.next()) {
            	System.out.println("find");
                try {
                	
                    c = new Carre(nomF,new Point(resultat.getDouble("origine_x"),resultat.getDouble("origine_y"))
                    		, resultat.getDouble("cote"));
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
	public void delete(Carre c) {
		// TODO Auto-generated method stub
		String del = "DELETE FROM Carre WHERE nomForme = ?";
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
	public Carre update(Carre c) {
		// TODO Auto-generated method stub
		int verif = 0;
        String update = "UPDATE Carre SET origine_x = ?, origine_y = ?, cote = ? WHERE nomForme = ?";
   
        try {
            PreparedStatement prepare = conn.prepareStatement(update);
            prepare.setString(1, c.getNomForme());
            prepare.setDouble(2, c.getOrigine().getX());
            prepare.setDouble(3, c.getOrigine().getY());
            prepare.setDouble(4, c.getCote());
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
