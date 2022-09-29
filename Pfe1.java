/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.sql.Date;

/**
 *
 * @author Sarah
 */
public class Pfe1 {
    
   String sujet;
         String   cin;
         String   etat;
         String           entreprise;

    public Pfe1(String sujet, String cin, String etat, String entreprise) {
        this.sujet = sujet;
        this.cin = cin;
        this.etat = etat;
        this.entreprise = entreprise;
    }

    Pfe1(String string, String string0, String string1, String string2, Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }
    
    
    
}
