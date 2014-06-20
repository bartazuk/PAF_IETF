package IETF;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;



public class HttpClass {
	
	Xml xml= new Xml();
	private String getCode(String url) {//ouvre la page demandée
		String code = "";

		if (urlExists(url)) {
			BufferedReader in = null;

			try {
				URL site = new URL(url);
				in = new BufferedReader(
						new InputStreamReader(site.openStream()));

				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					code = code + "\n" + (inputLine);
				}

				in.close();

			} catch (IOException ex) {
				System.out.println("Erreur dans l'ouverture de l'URL : " + ex);
			} finally {
				try {
					in.close();
				} catch (IOException ex) {
					System.out.println("Erreur dans la fermeture du buffer : "
							+ ex);
				}
			}
		} else {
			System.out.println("Le site n'existe pas !");
		}

		return code; //envoi le code html de la page
	}

	private boolean urlExists(String url) {//verifie l'existence de l'URL
		try {
			URL site = new URL(url);
			try {
				site.openStream();
				return true;
			} catch (IOException ex) {
				return false;
			}
		} catch (MalformedURLException ex) {
			return false;
		}
	}
	
	
	public String[] resultat() // on l'appelle pour recuperer le tableau des codes html
	{
		 ArrayList<String> nom = xml.nom();
			//---------------------------------------------Recherche et stockage des réponses
		     String[] tab = new String[nom.size()];
		      for (int i=0;i<nom.size();i++)
			{
				tab[i]=getCode("https://datatracker.ietf.org/doc/search/?name=&rfcs=on&activedrafts=on&sort=&by=author&author="+nom.get(i));
			}
		      return tab;
	}
}
