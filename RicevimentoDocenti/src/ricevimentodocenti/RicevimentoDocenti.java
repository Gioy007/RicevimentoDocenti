/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ricevimentodocenti;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import org.w3c.dom.NodeList;

/**
 *
 * @author vicini_gioele
 */
public class RicevimentoDocenti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        List<NodeList> tabella = null;
        Parser pars = new Parser();
        myFile file = new myFile();
        
        /*Scanner sc = new Scanner(System.in);
        String prof = sc.next();*/
        
        tabella = pars.parseDocument("circolare.xml");
        
        pars.Docenti(tabella);
        
        System.out.println(pars.toString());
    }
    
}
