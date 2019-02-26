/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ricevimentodocenti;

/**
 *
 * @author vicini_gioele
 */
public class Docente {
    public String nomeDocente, giorno;
    public int ora, lotto,i;
    
    public Docente(){
        nomeDocente="";
        giorno="";
        ora=0;
        lotto=0;
        i=0;
    }
    
    public String toString(){
        return i+"Docente:"+nomeDocente+"\nGiorno:"+giorno+"\nOra"+ora+"\nLotto:"+lotto;
    }
}
