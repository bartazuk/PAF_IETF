package IETF;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class Url {
	
	ArrayList<String> articles = new ArrayList();
	
	Url(ArrayList<String> auteur){
		for (int i = 0;i<auteur.size();i++){
			try {
				getFinal(auteur.get(i));
			} catch (IOException e) {e.printStackTrace();}
		}
	}
	
	private void getFinal(String auteur) throws IOException {
	//On se connecte au site et on charge le document html

	Document doc = Jsoup.connect("https://datatracker.ietf.org/doc/search/?name=&rfcs=on&activedrafts=on&sort=&by=author&author="+auteur).get();
	 
	
	Elements element= doc.select("td.doc");//on regarde toutes les balise td qui ont pour classe doc et on les met dans element
	for (int i=0;i<element.size();i++){
	articles.add(element.get(i).getElementsByTag("a").attr("href"));//pour chaque td, on extrait le contenu du href des <a> et on les met dans l'arraylist
	}
	}
	
	public ArrayList<String> getArticles(){
		return articles;
	}
}

