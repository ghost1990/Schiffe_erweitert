/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Schiff;

import java.util.ArrayList;

/**
 *
 * @author Ghost
 */
public class DotComs {
    
    private ArrayList<String> zellorte;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getZellorte() {
        return zellorte;
    }

    public void setZellorte(ArrayList<String> zellorte) {
        this.zellorte = zellorte;
    }

    public String prüfDich(String benutzerEingabe){
        String ergebnis = "vorbei";
        int index = zellorte.indexOf(benutzerEingabe);
        System.out.println("Index: "+index);
        if (index >= 0){
            zellorte.remove(index);
        
            if (zellorte.isEmpty()) {
                ergebnis = "Versenkt";
                System.out.println("Sie haben " + name + " versenkt: ");
            } else {
                ergebnis = "Treffer";
            }
        }
        return ergebnis;
    }
}
