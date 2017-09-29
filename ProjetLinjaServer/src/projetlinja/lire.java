/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetlinja;

import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author DjazzJah
 */
public class lire {

    public lire() {
        System.out.println("----------------------------------------------");
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(""));
            Document doc = db.parse(is);
            NodeList nodes = doc.getElementsByTagName("etudiant");
            for (int i = 0; i < nodes.getLength(); i++) {
                Node nNode = nodes.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println(" action : " + eElement.getAttribute("action"));
                    System.out.println(" id : " + eElement.getAttribute("id"));
                    System.out.println(" Name : " + eElement.getElementsByTagName("nom").item(0).getTextContent());
                    System.out.println("adresse : " + eElement.getElementsByTagName("adresse").item(0).getTextContent());
                    System.out.println("bourse: " + eElement.getElementsByTagName("bourse").item(0).getTextContent());

                }
            }
        } catch (Exception e) {
        }
    }
    public String getCharacterDataFromElement(Element e) {
        Node child = e.getFirstChild();
        if (child instanceof CharacterData) {
            CharacterData cd = (CharacterData) child;
            return cd.getData();
        }
        return "";
    }
}
