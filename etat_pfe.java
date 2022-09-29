/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

/**
 *
 * @author Sarah
 */
public class etat_pfe {
    
   private String cin;
   private String etat;
    
    
 

  public etat_pfe(String cin, String etat) {
       
        this.cin = cin;
        this.etat = etat;
       
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
    
    
}
