package uvsq21606235.dao;

import java.util.Map;

public abstract class DAO<T> {
	
	/**
	 * ajouter un élément
	 */
	public abstract T create(T Object);
	
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
	 */
	public abstract T update(T object);
	
}
