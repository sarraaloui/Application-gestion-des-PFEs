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
public class Etudiant {
     public   static String stock;

    int id;
    String prenom;
    String nom;
    Date Date_naiss;

    public Etudiant(int id, String prenom, String nom, Date Date_naiss) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.Date_naiss = Date_naiss;
    }

    Etudiant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public Date getDate_naiss() {
        return Date_naiss;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDate_naiss(Date Date_naiss) {
        this.Date_naiss = Date_naiss;
    }
    
    
}
