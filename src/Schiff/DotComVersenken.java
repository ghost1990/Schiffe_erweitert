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
public class DotComVersenken {
    private SpielHelfer helfer = new SpielHelfer();
    private ArrayList<DotComs> dotComListe = new ArrayList<DotComs>();
    private int anzahlVersuche = 0;
    
    public void spielEinrichten(){
        DotComs dot1 = new DotComs();
        DotComs dot2 = new DotComs();
        DotComs dot3 = new DotComs();
        
        dot1.setName("Bio.com");
        dot2.setName("Haustiere.com");
        dot3.setName("Test.com");
        
        dotComListe.add(dot1);
        dotComListe.add(dot2);
        dotComListe.add(dot3);
        
        System.out.println("Ihre Aufgabe ist es " + dot1.getName()+" || " + dot2.getName()+" ||" + dot3.getName() + " mit so wenig Versuchen wie möglich zu versenken ");
        
        for (DotComs aktuellesDotCom : dotComListe){
            ArrayList<String> neuerOrt = helfer.platziereDotCom(3);
            aktuellesDotCom.setZellorte(neuerOrt);
            //System.out.println("Test platzieren");
        }   
    }
    
    private void beginneSpiel(){
        while(!dotComListe.isEmpty()){
            String benutzereingabe = helfer.getBenutzereingabe("Bitte die Koordinate eingeben: ");
            prüfeRateversuch(benutzereingabe);  
        }
       beendeSpiel();
    }
    
    private void prüfeRateversuch(String rateversuch){
        anzahlVersuche++;
        String ergebnis = "vorbei";
        
        for (DotComs aktuellesDotCom : dotComListe){
            ergebnis = aktuellesDotCom.prüfDich(rateversuch);
            
            if(ergebnis.equals("Treffer")){
                break;
            }
            if (ergebnis.equals("Versenkt")){
                dotComListe.remove(aktuellesDotCom);
                break;
            }            
        } 
        System.out.println(ergebnis);
    }
    
    private void beendeSpiel(){
        System.out.println("Game Over!");
        
        if(anzahlVersuche < 14){
            System.out.println("Sehr Gut! "+anzahlVersuche);
        }else{
            System.out.println("Üben üben üben!!!"+anzahlVersuche);
        }
    }
    
    public static void main(String[] args) {
        DotComVersenken spiel = new DotComVersenken();
        
        spiel.spielEinrichten();
        spiel.beginneSpiel();
    }
}
