package ricevimentodocenti;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * @author limonta_alberto
 */
public class Parser {

    private List<Docente> docenti;
    private List table;

    public Parser() {
        table = new ArrayList();
        docenti = new ArrayList();

    }

    public List<NodeList> parseDocument(String fileName)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        NodeList nodelist;

        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(fileName);
        root = document.getDocumentElement();

        nodelist = root.getElementsByTagName("tr");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {                
              
                element = (Element) nodelist.item(i);
                String value = element.getFirstChild().getTextContent();
                if (value != null) {
                    
                    if (element.getChildNodes().getLength() == 5) {
                        table.add(element);
                    }
                }

            }
        }

        return table;
    } 
    
    public void Docenti(List<NodeList> testo){
        for(int i=0; i<testo.size();i++){
            docenti.add(getDocente(testo.get(i)));
        }
    }
    
    public String toString(){
        String s="";
        
        for(int i=0;i<docenti.size();i++){
            s+=docenti.get(i).toString();
        }
        
        return s;
    }

    public Docente getDocente(NodeList nodelist) {
        Docente docente = new Docente();

        if (nodelist != null && nodelist.getLength() > 0) {
            docente.i=Integer.getInteger(nodelist.item(0).getTextContent());
            docente.nomeDocente=nodelist.item(1).getTextContent();
            docente.giorno=nodelist.item(2).getTextContent();
            docente.ora=Integer.getInteger(nodelist.item(3).getTextContent());
            docente.lotto=Integer.getInteger(nodelist.item(4).getTextContent());
        }
        return docente;
    }
}

