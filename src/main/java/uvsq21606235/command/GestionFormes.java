package uvsq21606235.command;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import uvsq21606235.dao.DAO;
import uvsq21606235.dao.DaoFactoryJdbc;
import uvsq21606235.formes.*;



public class GestionFormes {
	
	private Map<String,Formes> formes;
	
	public GestionFormes()
	{
		this.formes = new HashMap<> ();
	}
	
//	public String reponseUser() {
//		String saisie= null;
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Sauvegarder la figure s/n ?");
//		return saisie = sc.nextLine();
//		
//	}

	@SuppressWarnings("unused")
	public String view(String f) throws SQLException
	{
		Formes formes;
//	    DaoFactoryJdbc factory = new DaoFactoryJdbc();
		if(this.formes.containsKey(f)) //"Cercle(centre=(0,0),rayon=50)"
		{
			Formes forme = this.formes.get(f);
			if(forme instanceof Cercle)
			{
				forme = (Cercle)forme;
//				DAO<Cercle> dao = factory.createDaoCercle();
//				formes = dao.find(forme.getNomForme());
//				if(forme == null) {
//					return "forme inexistante";
//				}else {
//					if(formes == null) {
//						return forme.getNomForme()+"(centre="+"("+forme.getCentre().getX()+","+forme.getCentre().getY()+")"+
//								",rayon="+forme.getRayon()+")";
//					}
					return forme.getNomForme()+"(centre="+"("+forme.getCentre().getX()+","+forme.getCentre().getY()+")"+
					",rayon="+forme.getRayon()+")";
				
				

			}
			else if(forme instanceof Rectangle)
			{
				forme = (Rectangle)forme;
//				DAO<Rectangle> dao = factory.createDaoRectangle();
//				formes = dao.find(forme.getNomForme());
//				if(forme == null) {
//					return "forme inexistante";
//				}else {
//					if(formes == null) {
//						return forme.getNomForme()+"(point_haut_gauche="+"("+forme.getOrigine().getX()+","+forme.getOrigine().getY()+")"+
//								",Longueur="+forme.getLongueur()+",Largeur="+forme.getLargeur()+")";
//					}
					return forme.getNomForme()+"(point_haut_gauche="+"("+forme.getOrigine().getX()+","+forme.getOrigine().getY()+")"+
					",Longueur="+forme.getLongueur()+",Largeur="+forme.getLargeur()+")";
				
				
			}
			else if(forme instanceof Carre)
			{
				forme = (Carre)forme;
				
//				DAO<Carre> dao = factory.createDaoCarre();
//				formes = dao.find(forme.getNomForme());
//				if(forme == null) {
//					return "forme inexistante";
//				}else {
//					if(formes == null) {
//						return forme.getNomForme()+"(Origine="+"("+forme.getOrigine().getX()+","+forme.getOrigine().getY()+")"+
//								", cote=("+forme.getCote()+")";
//					}
					return forme.getNomForme()+"(Origine="+"("+forme.getOrigine().getX()+","+forme.getOrigine().getY()+")"+
					", cote=("+forme.getCote()+")";
				
				
				
			}
			else if(forme instanceof Triangle)
			{
				forme = (Triangle)forme;
				
//				DAO<Triangle> dao = factory.createDaoTriangle();
//				formes = dao.find(forme.getNomForme());
//				if(forme == null) {
//					return "forme inexistante";
//				}else {
//					if(formes == null) {
//						return forme.getNomForme()+"(point_haut="+"("+forme.getH().getX()+","+forme.getH().getY()+")"+
//								",point_bas_gouche=("+forme.getBg().getX()+","+forme.getBg().getY()+")"+
//								",point_bas_droit=("+forme.getBd().getX()+","+forme.getBd().getY()+")";
//					}
					return forme.getNomForme()+"(point_haut="+"("+forme.getH().getX()+","+forme.getH().getY()+")"+
					",point_bas_gouche=("+forme.getBg().getX()+","+forme.getBg().getY()+")"+
					",point_bas_droit=("+forme.getBd().getX()+","+forme.getBd().getY()+")";
				
			
			}
			else
			{
				return " cette forme n'existe pas";
			}
		}
		return " cette forme n'existe pas";
	}

	public String creat(String nom, String type, String param) throws SQLException
	{
		String saisie= null;
		 Formes f;
	     //DaoFactoryJdbc factory = new DaoFactoryJdbc();
		if(type.equals("Cercle"))
		{
			String[] tmpParam = param.split(" ");

			String pX = tmpParam[0].substring(8, tmpParam[0].length()-1);
			String pY = tmpParam[1].substring(0, tmpParam[1].length()-2);
			String rayon = tmpParam[2].substring(0, tmpParam[2].length()-1);
			this.formes.put(nom, new Cercle(nom, new Point(new Double(pX), new Double(pY)), new Double(rayon) ));
			
//			//demande la sauvegarde dans la base de donnée
//			saisie = reponseUser();
//			
//			if(saisie.contentEquals("s") || saisie.contentEquals("S") || saisie.contentEquals("save")) {
//				DAO<Cercle> dao = factory.createDaoCercle();
//	            f = dao.create(new Cercle(nom, new Point(new Double(pX), new Double(pY)), new Double(rayon)));
//	            return nom + " est créé";
//			}
			
			return nom + " est créé mais pas sauvegarder dans la base de donnée";
		}
		else if(type.equals("Carre"))
		{
			String[] tmpParam = param.split(" ");
			String hgX = tmpParam[0].substring(7, tmpParam[0].length()-1);
			String hgY = tmpParam[1].substring(0, tmpParam[1].length()-2);

			String c = tmpParam[2].substring(0, tmpParam[2].length()-1);
			this.formes.put(nom, new Carre("Carre", new Point(new Double(hgX), new Double(hgY)),new Double(c)));
			
//			//demande la sauvegarde dans la base de donnée
//			saisie = reponseUser();
//			
//			if(saisie.contentEquals("s") || saisie.contentEquals("S") || saisie.contentEquals("save")) {
//				DAO<Carre> dao = factory.createDaoCarre();
//	            f = dao.create(new Carre(nom, new Point(new Double(hgX), new Double(hgY)),new Double(c)));
//	            return nom + " est créé";
//			}
			return nom + " est créé mais pas sauvegarder dans la base de donnée";
			
			
		}
		else if(type.equals("Rectangle"))
		{
			String[] tmpParam = param.split(" ");
			String hgX = tmpParam[0].substring(11, tmpParam[0].length()-1);
			String hgY = tmpParam[1].substring(0, tmpParam[1].length()-2);
			String ln = tmpParam[2].substring(1, tmpParam[2].length()-1);
			String la = tmpParam[3].substring(0, tmpParam[3].length()-2);
			this.formes.put(nom, new Rectangle(nom, new Point(new Double(hgX), new Double(hgY)),
													new Double(ln), new Double(la)));
			
//			//demande la sauvegarde dans la base de donnée
//			saisie = reponseUser();
//			
//			if(saisie.contentEquals("s") || saisie.contentEquals("S") || saisie.contentEquals("save")) {
//				DAO<Rectangle> dao = factory.createDaoRectangle();
//	            f = dao.create(new Rectangle(nom, new Point(new Double(hgX), new Double(hgY)),
//						new Double(ln), new Double(la)));
//	            return nom + " est créé";
//			}
//			
			return nom + " est créé mais pas sauvegarder dans la base de donnée";
		}
		else if(type.equals("Triangle"))
		{
			String[] tmpParam = param.split(" ");
			String hX = tmpParam[0].substring(10, tmpParam[0].length()-1);
			String hY = tmpParam[1].substring(0, tmpParam[1].length()-2);
			String bgX = tmpParam[2].substring(1, tmpParam[2].length()-1);
			String bgY = tmpParam[3].substring(0, tmpParam[3].length()-2);
			String bdX = tmpParam[4].substring(1, tmpParam[4].length()-1);
			String bdY = tmpParam[5].substring(0, tmpParam[5].length()-2);
			this.formes.put(nom, new Triangle(nom, new Point(new Double(hX), new Double(hY)),
														  new Point(new Double(bgX), new Double(bgY)),
														  new Point(new Double(bdX), new Double(bdY))
														  ));
			//demande la sauvegarde dans la base de donnée
//			saisie = reponseUser();
//			
//			if(saisie.contentEquals("s") || saisie.contentEquals("S") || saisie.contentEquals("save")) {
//				DAO<Triangle> dao = factory.createDaoTriangle();
//	            f = dao.create(new Triangle(nom, new Point(new Double(hX), new Double(hY)),
//						  new Point(new Double(bgX), new Double(bgY)),
//						  new Point(new Double(bdX), new Double(bdY))
//						  ));
//	            
//	            return nom + " est créé";
//			}
			
			return nom + " est créé mais pas sauvegarder dans la base de donnée";
		}
		
		else
		{
			return "Impossible de créer" + nom;
		}
		
	}

	public String move(String f, String param)
	{

		if(this.formes.containsKey(f)) //"Cercle(centre=(0,0),rayon=50)"
		{
			Formes forme = this.formes.get(f);
			if(forme instanceof Cercle) 
			{
				forme = (Cercle)forme;
				String[] tmpParam = param.split(" ");
				String pX = tmpParam[0].substring(1, tmpParam[0].length()-1);
				String pY = tmpParam[1].substring(0, tmpParam[1].length()-2);
				Point c = new Point(new Double(pX), new Double(pY));
				
				((Cercle) forme).setCentre(c);
				
				
				return "move success";
			}
			else if(forme instanceof Rectangle)
			{
				forme = (Rectangle)forme;
				String[] tmpParam = param.split(" ");
				String hgX = tmpParam[0].substring(1, tmpParam[0].length()-1);
				String hgY = tmpParam[1].substring(0, tmpParam[1].length()-2);
				Point p = new Point(new Double(hgX), new Double(hgY));
				
				((Rectangle) forme).setOrigine(p);
				
				
				return "move success";
			}
			else if(forme instanceof Carre)
			{
				forme = (Carre)forme;
				String[] tmpParam = param.split(" ");
				String hgX = tmpParam[0].substring(1, tmpParam[0].length()-1);
				String hgY = tmpParam[1].substring(0, tmpParam[1].length()-2);
				Point p = new Point(new Double(hgX), new Double(hgY));
				
				
				
				((Carre) forme).setOrigine(p);
				
				return "move success";
			}
			else if(forme instanceof Triangle)
			{
				forme = (Triangle)forme;
				String[] tmpParam = param.split(" ");
				String hX = tmpParam[0].substring(1, tmpParam[0].length()-1);
				String hY = tmpParam[1].substring(0, tmpParam[1].length()-2);
				Point p = new Point(new Double(hX), new Double(hY));
				
				((Triangle) forme).setH(p);
				((Triangle) forme).setBd(p);
				((Triangle) forme).setBg(p);
				

				return "move success";
			}
			else
			{	
				return " cette forme n'existe pas 1";
			}
		}
		else if(f.contains("All"))
		{
			Set<String> list = this.formes.keySet();
			Iterator<String> iterator = list.iterator();
			while(iterator.hasNext())
			{
				Object key = iterator.next();
				String cle = key.toString(); 
				move(cle, param);
			}
			return "success";
		}
		else if(f.contains("Cercle") )
		{
			Set<String> list = this.formes.keySet();
			Iterator<String> iterator = list.iterator();
			while(iterator.hasNext())
			{
				Object key = iterator.next();
				String cle = key.toString(); 
				if(this.formes.get(cle).getNomForme().contains("Cercle"))
				{
					move(cle, param);
				}
			}
			return "success";
		}
		else if(f.contains("Carre"))
		{
			Set<String> list = this.formes.keySet();
			Iterator<String> iterator = list.iterator();
			while(iterator.hasNext())
			{
				Object key = iterator.next();
				String cle = key.toString(); 
				if(this.formes.get(cle).getNomForme().contains("Carre"))
				{
					move(cle, param);
				}
			}
			return "success";
		}
		else if(f.contains("Rectangle"))
		{
			Set<String> list = this.formes.keySet();
			Iterator<String> iterator = list.iterator();
			while(iterator.hasNext())
			{
				Object key = iterator.next();
				String cle = key.toString(); 
				if(this.formes.get(cle).getNomForme().contains("Rectangle"))
				{
					move(cle, param);
				}
			}
			return "success";
		}
		else if(f.contains("Triangle"))
		{
			Set<String> list = this.formes.keySet();
			Iterator<String> iterator = list.iterator();
			while(iterator.hasNext())
			{
				Object key = iterator.next();
				String cle = key.toString(); 
				if(this.formes.get(cle).getNomForme().contains("Triangle"))
				{
					move(cle, param);
				}
			}
			return "success";
		}
		return " cette forme n'existe pas 2";
	}

	public Map<String, Formes> getFormes() {
		return formes;
	}

	public void setFormes(Map<String, Formes> formes) {
		this.formes = formes;
	}
}
