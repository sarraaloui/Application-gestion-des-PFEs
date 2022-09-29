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
public class Enseignant {
       String id;
    String prenom;
    String nom;
 public   static String stock;
            String pass;

    String Date_naiss;
  Enseignant() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }
   
  
    public Enseignant(String id, String prenom, String nom,String pass ,String Date_naiss) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.Date_naiss = Date_naiss;
        this.pass=pass;
    }

    public String getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getDate_naiss() {
        return Date_naiss;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDate_naiss(String Date_naiss) {
        this.Date_naiss = Date_naiss;
    }
    
    
    
    
}
