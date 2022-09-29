/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Sarah
 */
public class Affecter_encadreurController implements Initializable {

    @FXML
    private TextField cin1;
    @FXML
    private TextField cin2;
    @FXML
    private Button enreg;
 public  Connection  con;
                 ResultSet rs,rs1;
    String dbName="projet_java";
        String userName="root";
        String password="";
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn_enregistrer(ActionEvent event) throws SQLException {

     
          PreparedStatement pst,pst1;
    String cin_ens=cin1.getText();
      String cin_et=cin2.getText();
      boolean ok=true;

      if(cin_ens.equals("")||cin_et.equals("")){
            JOptionPane.showMessageDialog(null,"saisir les champs necessaires");
               ok=false;
      }else {
          boolean exist_et=false,exist_ens=false;
              try {
                  Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);
              pst=con.prepareStatement("select password,role from users where password=?  ");
                    pst.setString(1,cin_et);
                   // System.out.println(exist);
              rs=pst.executeQuery();
              if(rs.next()){ 
                  if(rs.getString("role").equals("Etudiant")){
                     exist_et=true;
                  }

              }else{
     JOptionPane.showMessageDialog(null,"etudiant inexistant reesseyer");

              }
                           pst=con.prepareStatement("select password,role from users where password=?  ");
                    pst.setString(1,cin_ens);
                   // System.out.println(exist);
              rs=pst.executeQuery();
              if(rs.next()){ 
                  if(rs.getString("role").equals("Enseignant")){
                     exist_ens=true;
                  }

              }else{
     JOptionPane.showMessageDialog(null,"enseignant inexistant reesseyer");
              }     
    

              
              if(exist_et && exist_ens){
                   pst1=con.prepareStatement("select etat,cin from pfe where cin=?  ");
                    pst1.setString(1,cin_et);
                                  rs1=pst1.executeQuery();

                 //   boolean test=false;
              if(rs1.next()){
                  if(rs1.getString("etat").equals("en cours d'encadrement")){
                     Statement  stmt=con.createStatement();
                      String x="encadré";
                String sql="update pfe set etat='encadré',cin_enc='"+cin_ens+"'  where cin='"+cin_et+"'";
            stmt.executeUpdate(sql);
      
            
     JOptionPane.showMessageDialog(null," etat effectue avec succes");
                  }       
               else{
     JOptionPane.showMessageDialog(null," etat non pris en compte");
                     }  
                 
          }
              }
              
              
              /*
      
              while (rs.next()){
         if(rs.getString("etat").equals("en attente de rapporteur")==false){
            JOptionPane.showMessageDialog(null,"l'etat de letudiaant non pris en compte");
ok=false;
         }
         if (rs.getString("etat").equals("en attente de rapporteur")){
               pst1=con.prepareStatement("select cin from users where cin=? and role='Enseignant' ");
            pst1.setString(1,cin_ens);
              rs1=pst1.executeQuery();
              if(!rs1.next()){
                  JOptionPane.showMessageDialog(null,"verifier cin enseignant!");
                  ok=false;
              }
              
         }
          
         if (rs.getString("etat").equals("en attente de rapporteur")){
               pst1=con.prepareStatement("select cin from users where cin=? and role='Etudiant' ");
            pst1.setString(1,cin_et);
              rs1=pst1.executeQuery();
              if(!rs1.next()){
                  JOptionPane.showMessageDialog(null,"verifier cin etudiant!");
                  ok=false;
              }
              
         }
           }
              if(ok) {
            Statement  stmt=con.createStatement();
                String sql="update pfe set etat='en cours d''évaluation',cin_enc='"+cin_ens+"' where cin='"+cin_et+"'";
            stmt.executeUpdate(sql);
     JOptionPane.showMessageDialog(null," etat effectue avec succes");
     ok=false;
         }
              
              
            */
            
            
         } catch (ClassNotFoundException ex) {
                  Logger.getLogger(Affecter_encadreurController.class.getName()).log(Level.SEVERE, null, ex);
              }
          
          
      }

    }
    
       @FXML
    void btn_rap(ActionEvent event) throws SQLException {

          PreparedStatement pst,pst1;
    String cin_ens=cin1.getText();
      String cin_et=cin2.getText();
      boolean ok=true;

      if(cin_ens.equals("")||cin_et.equals("")){
            JOptionPane.showMessageDialog(null,"saisir les champs necessaires");
               ok=false;
      }else {
          boolean exist_et=false,exist_ens=false;
              try {
                  Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);
              pst=con.prepareStatement("select password,role from users where password=?  ");
                    pst.setString(1,cin_et);
                   // System.out.println(exist);
              rs=pst.executeQuery();
              if(rs.next()){ 
                  if(rs.getString("role").equals("Etudiant")){
                     exist_et=true;
                  }

              }else{
     JOptionPane.showMessageDialog(null,"etudiant inexistant reesseyer");

              }
                           pst=con.prepareStatement("select password,role from users where password=?  ");
                    pst.setString(1,cin_ens);
                   // System.out.println(exist);
              rs=pst.executeQuery();
              if(rs.next()){ 
                  if(rs.getString("role").equals("Enseignant")){
                     exist_ens=true;
                  }

              }else{
     JOptionPane.showMessageDialog(null,"enseignant inexistant reesseyer");
              }     
    

              
              if(exist_et && exist_ens){
                   pst1=con.prepareStatement("select etat,cin from pfe where cin=?  ");
                    pst1.setString(1,cin_et);
                                  rs1=pst1.executeQuery();

                 //   boolean test=false;
              if(rs1.next()){
                  if(rs1.getString("etat").equals("en attente de rapporteur")){
                     Statement  stmt=con.createStatement();
                      String x="en cours d'évaluation";
                String sql="update pfe set etat='en cours d''évaluation',cin_raport='"+cin_ens+"'  where cin='"+cin_et+"'";
            stmt.executeUpdate(sql);
      
            
     JOptionPane.showMessageDialog(null," etat effectue avec succes");
                  }       
               else{
     JOptionPane.showMessageDialog(null," etat non pris en compte");
                     }  
                 
          }
              }
              
              
              /*
      
              while (rs.next()){
         if(rs.getString("etat").equals("en attente de rapporteur")==false){
            JOptionPane.showMessageDialog(null,"l'etat de letudiaant non pris en compte");
ok=false;
         }
         if (rs.getString("etat").equals("en attente de rapporteur")){
               pst1=con.prepareStatement("select cin from users where cin=? and role='Enseignant' ");
            pst1.setString(1,cin_ens);
              rs1=pst1.executeQuery();
              if(!rs1.next()){
                  JOptionPane.showMessageDialog(null,"verifier cin enseignant!");
                  ok=false;
              }
              
         }
          
         if (rs.getString("etat").equals("en attente de rapporteur")){
               pst1=con.prepareStatement("select cin from users where cin=? and role='Etudiant' ");
            pst1.setString(1,cin_et);
              rs1=pst1.executeQuery();
              if(!rs1.next()){
                  JOptionPane.showMessageDialog(null,"verifier cin etudiant!");
                  ok=false;
              }
              
         }
           }
              if(ok) {
            Statement  stmt=con.createStatement();
                String sql="update pfe set etat='en cours d''évaluation',cin_enc='"+cin_ens+"' where cin='"+cin_et+"'";
            stmt.executeUpdate(sql);
     JOptionPane.showMessageDialog(null," etat effectue avec succes");
     ok=false;
         }
              
              
            */
            
            
         } catch (ClassNotFoundException ex) {
                  Logger.getLogger(Affecter_encadreurController.class.getName()).log(Level.SEVERE, null, ex);
              }
          
          
      }
        
        
    }
    
    
    
}
