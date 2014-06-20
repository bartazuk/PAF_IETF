package IETF;

import java.util.ArrayList;


public class Liste {
	
	private ArrayList<String> liste;
	
	Liste()
	{
		liste= new ArrayList();
	}
	
	public void add(String url) //A utiliser pour mettre le resultat du code qui recupere les urls
	{
		if (!liste.contains(url))//verifie si l'url est pas déjà dans la liste (si plusieurs membres ont publié le même article)
		{
			
			liste.add(url);//ajoute l'url à la liste si il n'y est pas déjà
		}
	}
	public ArrayList<String> getUrl()
	{
		
		return liste;
	}
}
