package uvsq21606235.command;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DrawinTUI {
	
	private Scanner saisie;
	private final Map<String, Command> commands;
	private GestionFormes gestionFormes;
	
	
	public DrawinTUI(GestionFormes f)
	{
		this.saisie = new Scanner(System.in);
		this.commands = new HashMap<>();
		this.gestionFormes = f;
	}
	
	public String storeAndExecute(String nom, Command cmd) throws SQLException
	{
		this.commands.put(nom, cmd);
	    return this.commands.get(nom).execute();   
	}
	
	public String executeCommand(String nom) throws SQLException
	{
		return this.commands.get(nom).execute();       
	}
	
	public String getType(String src, String s1, String s2, String s3, String s4)
	{
		if( src.contains(s1) )
		{
			return s1;
		}
		if( src.contains(s2) )
		{
			return s2;
		}
		if( src.contains(s3) )
		{
			return s3;
		}
		if( src.contains(s4) )
		{
			return s4;
		}
		return "error";
	}
	
	public void nextCOmmand(String[] args) throws Exception
	{
		boolean exit = false;
		boolean q = false;
		String phrase = "";
		while(!exit && !q)
		{
			try
			{
				phrase = saisie.nextLine();
				String[] entrer = phrase.split(" ");
				String tmpCmd = "";
				if(entrer.length > 1) //          
				{
					tmpCmd = entrer[1];
				}
				String cmd = entrer[0];
				if(tmpCmd.equals("="))
				{
					cmd = tmpCmd;
				}
				if(cmd.contains("move"))
				{
					cmd = "move";
				}
				
				
				switch (cmd)
				{
					case "exit":
					case "q":
							exit = true;
							break;

					case "=":
						String nom = entrer[0];
						String type = getType(entrer[2], "Cercle", "Carre", "Rectangle", "Triangle");
//						
						String param = "";
						for(int i=2; i < entrer.length; i++)
						{
							param += entrer[i];
							if(i+1 < entrer.length )
							{
								param += " "; 
							}
						}
						if(this.commands.containsKey(cmd))
						{
							System.out.println( executeCommand(cmd+nom) );
						}
						else
						{
							Command command = new CreatFormeCommand(this.gestionFormes,nom, type, param);
							System.out.println( storeAndExecute(cmd+nom, command) );
						}
						break;
						
					case "view":
						String nomViewForme = entrer[1];
						if(this.commands.containsKey(cmd))
						{
							System.out.println( executeCommand(cmd+nomViewForme) );
						}
						else
						{
							Command command = new ViewFormeCommand(this.gestionFormes,nomViewForme);
							System.out.println( storeAndExecute(cmd+nomViewForme, command) );
						}
						break;
					
					case "move":
						String nomMoveForme = entrer[0].substring(5, entrer[0].length()-1);
						String paramMoveForme = entrer[1]+" "+entrer[2];
						if(this.commands.containsKey(cmd))
						{
							System.out.println( executeCommand(cmd+nomMoveForme) );
						}
						else
						{
							Command command = new MoveFormeCommand(this.gestionFormes,nomMoveForme, paramMoveForme);
							System.out.println( storeAndExecute(cmd+nomMoveForme, command) );
						}
						break;
						
	
					default:
							System.out.println("Commande invalide !");
							
				}
			}
				
				
			catch(IndexOutOfBoundsException e)
			{
				System.out.println(e.getMessage());
				
			}
		}
		saisie.close();
		

	}
}
