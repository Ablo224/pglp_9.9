package uvsq21606235.command;

import java.sql.SQLException;

public class QuitCommand implements Command{
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
    	System.out.println("Merci d'avoir utiliser mon applicatioin");
    	System.exit(0);
	}

}
