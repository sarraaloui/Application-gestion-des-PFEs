/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.io.File;

/**
 *
 * @author Sarah
 */
public class Pfe {
    
    String sujet;
    String entreprise;
    String cin;
        String binome;
    String cinb;
        String etat;
        String cin_enc;
           String cin_raport;

    public Pfe(String sujet, String entreprise, String cin, String binome, String cinb, String etat, String cin_enc, String cin_raport) {
        this.sujet = sujet;
        this.entreprise = entreprise;
        this.cin = cin;
        this.binome = binome;
        this.cinb = cinb;
        this.etat = etat;
     //   this.fichier = fichier;
        this.cin_enc = cin_enc;
        this.cin_raport = cin_raport;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setBinome(String binome) {
        this.binome = binome;
    }

    public void setCinb(String cinb) {
        this.cinb = cinb;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setCin_enc(String cin_enc) {
        this.cin_enc = cin_enc;
    }

    public void setCin_raport(String cin_raport) {
        this.cin_raport = cin_raport;
    }

    public String getSujet() {
        return sujet;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public String getCin() {
        return cin;
    }

    public String getBinome() {
        return binome;
    }

    public String getCinb() {
        return cinb;
    }

    public String getEtat() {
        return etat;
    }

    public String getCin_enc() {
        return cin_enc;
    }

    public String getCin_raport() {
        return cin_raport;
    }

    Pfe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Pfe(String string, String string0, String string1, String string2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    
    
}
