package uvsq21606235.command;


public class ViewFormeCommand implements Command{
	
	private GestionFormes gestionFormes;
	private String f;

	public ViewFormeCommand(GestionFormes gf, String f)
	{
		this.gestionFormes = gf;
		this.f = f;
	}

	@Override
	public String execute()
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
