package XmlRead;
import java.io.*;

import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.filter.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Xml
{
   static org.jdom2.Document document;
   static Element racine;
   static ArrayList<String> nom = new ArrayList();
   
   static ArrayList<String> lire()
   {
      //On crée une List contenant tous les noeuds "liste" de l'Element racine
      List listEtudiants = racine.getChildren("personne");

      //On crée un Iterator sur notre liste
      Iterator i = listEtudiants.iterator();
      while(i.hasNext())
      {
         //On recrée l'Element courant à chaque tour de boucle afin de
         //pouvoir utiliser les méthodes propres aux Element comme :
         //sélectionner un nœud fils, modifier du texte, etc...
         Element courant = (Element)i.next();
         //On ajoute le nom courant à un arraylist
         nom.add(courant.getChild("nom").getText());
      }
      return nom;
   }
   static ArrayList<String> nom()
   {
	   SAXBuilder sxb = new SAXBuilder();
	      ArrayList<String> nom = new ArrayList();
	      ArrayList<String> code = new ArrayList();
	      try
	      {
	         //On crée un nouveau document JDOM avec en argument le fichier XML
	         //Le parsing est terminé ;)
	         Xml.document = sxb.build(new File("nom.xml"));
	      }
	      catch(Exception e){}
	      //On initialise un nouvel élément racine avec l'élément racine du document.
	      Xml.racine = Xml.document.getRootElement();

	      //Retourne une arraylist des noms
	      nom=Xml.lire();
	      return nom;
   }
}
