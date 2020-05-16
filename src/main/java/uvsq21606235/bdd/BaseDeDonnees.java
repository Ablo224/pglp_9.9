package uvsq21606235.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class BaseDeDonnees {

		/**
		 * nom de la bdd
		 */
		private static String nomBdd = "dessin";
		
		
		/**
		 * création de la bdd
		 */
		public static void createDataBase()  {
	        
			try {
	           Connection conn = DriverManager.getConnection("jdbc:derby:" + nomBdd + ";create=true");
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		
		
		/**
		 * connexion à la bdd
		 * @return
		 */
		public static Connection getConnection() {
		 try {
		         return DriverManager.getConnection("jdbc:derby:" + nomBdd + ";create=true");
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return null;
		}
		
		/**
		 * création de la table Formes
		 * @param conn
		 * @throws SQLException
		 */
		
		private static void createTableForme(final Connection conn)throws SQLException {
	        String table = "create table Formes ("
	                + "nomForme varchar(20) not null primary key"
	                + ")";
	        Statement stat = conn.createStatement();
	        stat.execute(table);
	    }
		
		/**
		 * création de la table carre
		 * @param conn
		 * @throws SQLException
		 */
		private static void creatTableCarre(final Connection conn)throws SQLException {
	        String laTable = "create table Carre ("
	                + "nomForme varchar(20) not null primary key,"
	                + "origine_x double,"
	                + "origine_y double,"
	                + "cote double,"
	                + "foreign key (nomForme) references Formes (nomForme) ON DELETE CASCADE"
	                + ")";
	        Statement etat = conn.createStatement();
	        etat.execute(laTable);
	    }
		
		/**
		 * création de la table cercle
		 * @param conn
		 * @throws SQLException
		 */
		private static void creatTableCercle(final Connection conn)throws SQLException {
	        String laTable = "create table Cercle ("
	                + "nomForme varchar(20) not null primary key,"
	                + "centre_x double,"
	                + "centre_y double,"
	                + "rayon double,"
	                + "foreign key (nomForme) references Formes (nomForme) ON DELETE CASCADE"
	                + ")";
	        Statement etat = conn.createStatement();
	        etat.execute(laTable);
	    }
		
		
		/**
		 * création de la table rectangle
		 * @param conn
		 * @throws SQLException
		 */
		private static void creatTableRectangle(final Connection conn)throws SQLException {
	        String laTable = "create table Rectangle ("
	                + "nomForme varchar(20) not null primary key,"
	                + "origine_x double,"
	                + "origine_y double,"
	                + "longueur double,"
	                + "largeur double,"
	                + "foreign key (nomForme) references Formes (nomForme) ON DELETE CASCADE"
	                + ")";
	        Statement etat = conn.createStatement();
	        etat.execute(laTable);
	    }
		
		/**
		 * création de la table rectangle
		 * @param conn
		 * @throws SQLException
		 */
		private static void creatTableTriangle(final Connection conn)throws SQLException {
	        String laTable = "create table Triangle ("
	                + "nomForme varchar(20) not null primary key,"
	                + "p1_x double,"
	                + "p1_y double,"
	                + "p2_x double,"
	                + "p2_y double,"
	                + "p3_x double,"
	                + "p3_y double,"
	                + "foreign key (nomForme) references Formes (nomForme) ON DELETE CASCADE"
	                + ")";
	        Statement etat = conn.createStatement();
	        etat.execute(laTable);
	    }
		
		
		
		
		
		
		
		
}






