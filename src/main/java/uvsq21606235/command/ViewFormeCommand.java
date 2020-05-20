package uvsq21606235.command;

import java.sql.SQLException;

public class ViewFormeCommand implements Command{
	
	private GestionFormes gestionFormes;
	private String f;

	public ViewFormeCommand(GestionFormes gf, String f)
	{
		this.gestionFormes = gf;
		this.f = f;
	}

	@Override
	public String execute() throws SQLException
	{
		return gestionFormes.view(this.f);
	}

	public GestionFormes getGestionFormes() {
		return gestionFormes;
	}
	
	public String getFormes() {
		return f;
	}

}
