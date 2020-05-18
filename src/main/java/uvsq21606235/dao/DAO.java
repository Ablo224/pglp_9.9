package uvsq21606235.dao;

import java.sql.SQLException;

public abstract class DAO<T> {
	
	/**
	 * ajouter un élément
	 * @throws SQLException 
	 */
	public abstract T create(T Object) throws SQLException;
	
	/**
	 * obtention d'un élément
	 */
	public abstract T find(String nomF);
	
	/**
	 * supprimer un élément
	 */
	public abstract void delete(T Object);
	
	/**
	 * mise à jour
	 * @throws SQLException 
	 */
	public abstract T update(T object) throws SQLException;
	
}
