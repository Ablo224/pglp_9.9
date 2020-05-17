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
		public static Connection connection() {
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
		
		private static void createTableForme(Connection conn)throws SQLException {
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
		private static void creatTableCarre(Connection conn)throws SQLException {
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
		private static void creatTableCercle(Connection conn)throws SQLException {
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
		private static void creatTableRectangle(Connection conn)throws SQLException {
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
		private static void creatTableTriangle(Connection conn) throws SQLException {
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
		
		
		/**
		 * création de la table regroupe l'ensemble des formes
		 * @param conn
		 * @throws SQLException
		 */
		private static void creationTableEnsembleForme(Connection conn) throws SQLException {
	        String laTable = "create table EnsembleForme ("
	                + "nomGroupe varchar(20) not null primary key,"
	                + "foreign key (nomGroupe) references Formes (nomF)"
	                + ")";
	        Statement etat = conn.createStatement();
	        etat.execute(laTable);
	    }
		
		
		/**
		 * création de la relation resultante de l'ensemble des formes 
		 * et de l'abstraction des formes
		 * @param conn
		 * @throws SQLException
		 */
		private static void creationTableDeLien(Connection conn) throws SQLException {
	        String laTable = "create table Relation ("
	                + "idG varchar(20),"
	                + "idC varchar(20),"
	                + "primary key (idG, idC),"
	                + "foreign key (idG) references EnsembleForme (nomGroupe),"
	                + "foreign key (idC) references Formes (nomF)"
	                + ")";
	        Statement etat = conn.createStatement();
	        etat.execute(laTable);
	    }
		
		
		/**
		 * création effectif de la base de données en ajoutant les tables
		 * @throws Exception
		 */
		 public static void creatonEffectifDeLaBdd() throws Exception {
		        Connection conn = BaseDeDonnees.connection();
		        BaseDeDonnees.createTableForme(conn);
		        BaseDeDonnees.creatTableTriangle(conn);
		        BaseDeDonnees.creatTableCarre(conn);
		        BaseDeDonnees.creatTableCercle(conn);
		        BaseDeDonnees.creatTableRectangle(conn);
		        BaseDeDonnees.creationTableEnsembleForme(conn);
		        BaseDeDonnees.creationTableDeLien(conn);
		        conn.close();
		    }
}






