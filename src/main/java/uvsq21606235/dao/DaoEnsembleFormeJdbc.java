package uvsq21606235.dao;

import java.sql.Connection;

import uvsq21606235.formes.EnsembleForme;

public class DaoEnsembleFormeJdbc extends DAO<EnsembleForme> {

	private Connection conn;
	
	public DaoEnsembleFormeJdbc(Connection conn) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
	}

	@Override
	public EnsembleForme create(EnsembleForme Object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnsembleForme find(String nomF) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(EnsembleForme Object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EnsembleForme update(EnsembleForme object) {
		// TODO Auto-generated method stub
		return null;
	}

}
