package uvsq21606235.dao;

import java.util.Map;

public abstract class DAO<T> {
	
	/**
	 * ajouter un élément
	 */
	public abstract T creation(T Object);
	
	/**
	 * obtentio d'un élément
	 */
	//public abstract T obtenirElement();
	
	/**
	 * supprimer un élément
	 */
	public abstract void supprimerElement(T Object);
	
	/**
	 * mise à jour
	 */
	public abstract T miseAjour(T object);
	
}
