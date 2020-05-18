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
		
		
		public void  createtable()  
		{
				try {
					
						Connection conn =DriverManager.getConnection(url);
						
						Statement state = conn.createStatement();
						DatabaseMetaData databaseMetadata = conn.getMetaData();
					    ResultSet resultSet = databaseMetadata.getTables(null, null, "CERCLE", null);
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
					    
					    resultSet = databaseMetadata.getTables(null, null, "CARRE", null);
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
					    	
					    resultSet = databaseMetadata.getTables(null, null, "TRIANGLE", null);
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
					    
					    resultSet = databaseMetadata.getTables(null, null, "RECTANGLE", null);
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
					    
					    resultSet = databaseMetadata.getTables(null, null, "FORMES", null);
					    if (resultSet.next()) {
							state.addBatch("DROP TABLE Formes");
					    }
					    	state.addBatch( "create table Formes ("
					                + "nomForme varchar(20) not null primary key"
					                + ")");
					    
					    resultSet = databaseMetadata.getTables(null, null, "RELATION", null);

					    if (resultSet.next()) {
							state.addBatch("DROP TABLE Relation");
					    }

							
							state.addBatch( "create table Relation ("
					                + "idG varchar(20),"
					                + "idC varchar(20),"
					                + "primary key (idG, idC),"
					                + "foreign key (idG) references EnsembleForme (nomGroupe),"
					                + "foreign key (idC) references Formes (nomF)"
					                + ")");
					
					  resultSet = databaseMetadata.getTables(null, null, "ENSEMBLEFORME", null);

					  if (resultSet.next()) {
							state.addBatch("DROP TABLE EnsembleForme");
					    }
					  	state.addBatch("create table EnsembleForme ("
			                + "nomGroupe varchar(20) not null primary key,"
			                + "foreign key (nomGroupe) references Formes (nomF)"
			                + ")");
					   		
					    state.executeBatch();

			
			
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
	
}






