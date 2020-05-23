package uvsq21606235.bdd;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public  class BaseDeDonnees {

		
		
		public static String url="jdbc:derby:Logiciel_Dessin;create=true" ;
		
		
		private static final String user = "Abdou";
		
		
		private static final String pwd = "debal";
		
		
		
		public  BaseDeDonnees() {
			// TODO Auto-generated constructor stub
			   Properties connectionProps = new Properties();
		        connectionProps.put("user", user);
		        connectionProps.put("password", pwd);
		       System.out.println("Vous êtes connecté");
			
		}
		
		
		public void  createtableForme()  
		{
				try {
					
						Connection conn =DriverManager.getConnection(url);
						
						Statement state = conn.createStatement();
						DatabaseMetaData databaseMetadata = conn.getMetaData();
					    ResultSet resultSet = databaseMetadata.getTables(null, null, "Formes", null);

						 resultSet = databaseMetadata.getTables(null, null, "Formes", null);
					    if (resultSet.next()) {
							state.addBatch("DROP TABLE Formes");
					    }
				    	state.addBatch( "create table Formes ("
				                + "nomForme varchar(20) not null primary key"
				                + ")");
				    	
//			    	
					   		
					    state.executeBatch();
					    
					    System.out.println("création des tables réussi");
			
			
					} catch (BatchUpdateException  e) {
						
						 int[] updateCount = e.getUpdateCounts();
			             
				            int count = 1;
				            for (int i : updateCount) {
				                if  (i == Statement.EXECUTE_FAILED) {
				                    System.out.println("Error on request " + count +": Execute failed");
				                } else {
				                    System.out.println("Request " + count +": OK");
				                }
				                count++;
				                 
				            }	        }catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
		}
		
		public void creatTableEnsembleForme() {

			try {
				Connection conn =DriverManager.getConnection(url);
				Statement state = conn.createStatement();
				DatabaseMetaData databaseMetadata = conn.getMetaData();
				ResultSet resultSet = databaseMetadata.getTables(null, null, "EnsembleForme", null);
			    if (resultSet.next()) {
					state.addBatch("DROP TABLE EnsembleForme");
			    }
			    state.addBatch("create table EnsembleForme ("
		                + "nomForme varchar(20) not null  primary key,"
		                + "foreign key (nomForme) references Formes (nomForme)"
		                + ")");
				state.executeBatch();
				System.out.println("Groupe de formes créé");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		public void creatTableCarre() {

			try {
				Connection conn =DriverManager.getConnection(url);
				Statement state = conn.createStatement();
				DatabaseMetaData databaseMetadata = conn.getMetaData();
				ResultSet resultSet = databaseMetadata.getTables(null, null, "Carre", null);
			    if (resultSet.next()) {
					state.addBatch("DROP TABLE Carre");
			    }
				state.addBatch(
	   				 "create table Carre ("
	   			                + "nomForme varchar(20) not null primary key,"
	   			                + "origine_x double,"
	   			                + "origine_y double,"
	   			                + "cote double,"
	   			                + "foreign key (nomForme) references Formes (nomForme) ON DELETE CASCADE"
	   			                + ")");
				state.executeBatch();
				System.out.println("Carré créé");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	
		public void creatTableCercle() {

			try {
				Connection conn =DriverManager.getConnection(url);
				Statement state = conn.createStatement();
				DatabaseMetaData databaseMetadata = conn.getMetaData();
				ResultSet resultSet = databaseMetadata.getTables(null, null, "Cercle", null);
			    if (resultSet.next()) {
					state.addBatch("DROP TABLE Cercle");
			    }
				state.addBatch(
		    			 "create table Cercle ("
		    		                + "nomForme varchar(20) not null primary key,"
		    		                + "centre_x double,"
		    		                + "centre_y double,"
		    		                + "rayon double,"
		    		                + "foreign key (nomForme) references Formes (nomForme) ON DELETE CASCADE"
		    		                + ")");
				state.executeBatch();
				System.out.println("Cercle créé");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		public void creatTableRectangle() {

			try {
				Connection conn =DriverManager.getConnection(url);
				Statement state = conn.createStatement();
				DatabaseMetaData databaseMetadata = conn.getMetaData();
				ResultSet resultSet = databaseMetadata.getTables(null, null, "Rectangle", null);
			    if (resultSet.next()) {
					state.addBatch("DROP TABLE Rectangle");
			    }
			    state.addBatch(
		    			"create table Rectangle ("
		    	                + "nomForme varchar(20) not null primary key,"
		    	                + "origine_x double,"
		    	                + "origine_y double,"
		    	                + "longueur double,"
		    	                + "largeur double,"
		    	                + "foreign key (nomForme) references Formes (nomForme) ON DELETE CASCADE"
		    	                + ")");
				state.executeBatch();
				System.out.println("Rectangle créé");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		public void creatTableTriangle() {

			try {
				Connection conn =DriverManager.getConnection(url);
				Statement state = conn.createStatement();
				DatabaseMetaData databaseMetadata = conn.getMetaData();
				
				ResultSet resultSet = databaseMetadata.getTables(null, null, "Triangle", null);
			    if (resultSet.next()) {
					state.addBatch("DROP TABLE Triangle");
			    }
			    state.addBatch(
		    			"create table Triangle ("
		    	                + "nomForme varchar(20) not null primary key,"
		    	                + "p1_x double,"
		    	                + "p1_y double,"
		    	                + "p2_x double,"
		    	                + "p2_y double,"
		    	                + "p3_x double,"
		    	                + "p3_y double,"
		    	                + "foreign key (nomForme) references Formes (nomForme) ON DELETE CASCADE"
		    	                + ")");
				state.executeBatch();
				System.out.println("Triangle créé");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		public void creatTableRealation() {

			try {
				Connection conn =DriverManager.getConnection(url);
				Statement state = conn.createStatement();
				DatabaseMetaData databaseMetadata = conn.getMetaData();
				
				ResultSet resultSet = databaseMetadata.getTables(null, null, "Relation", null);
			    if (resultSet.next()) {
					state.addBatch("DROP TABLE Relation");
			    }
			    state.addBatch( "create table Relation ("
		                + "idG varchar(20) not null,"
		                + "idC varchar(20) not null,"
		                + "primary key (idG, idC),"
		                + "foreign key (idG) references EnsembleForme (nomForme),"
		                + "foreign key (idC) references Formes (nomForme)"
		                + ")");
				//state.executeBatch();
				System.out.println("Relation de composition créé");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		public static void deleteTables() {

			Statement stat = null;
	        try {
				Connection conn =DriverManager.getConnection(url);

	            stat = conn.createStatement();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        try {
	            stat.execute("drop table Relation");
	        } catch (SQLException e) {
	        }
	        try {
	            stat.execute("drop table Cercle");
	        } catch (SQLException e) {
	        }
	        try {
	            stat.execute("drop table Rectangle");
	        } catch (SQLException e) {
	        }
	        try {
	            stat.execute("drop table Carre");
	        } catch (SQLException e) {
	        }
	        try {
	            stat.execute("drop table Triangle");
	        } catch (SQLException e) {
	        }
	        try {
	            stat.execute("drop table EnsembleForme");
	        } catch (SQLException e) {
	        }
	        try {
	            stat.execute("drop table Formes");
	        } catch (SQLException e) {
	        }
	    }
		
		
	
}






