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
public class Affecter_noteController implements Initializable {

    @FXML
    private TextField cin_et;
    @FXML
    private Button affecter;
    @FXML
    private TextField note;

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
    private void btn_affecter(ActionEvent event) throws ClassNotFoundException {
        
         PreparedStatement pst,pst1;
    String cin1=cin_et.getText();
      String note1=note.getText();
      boolean ok=true;
       if(cin1.equals("")){
            JOptionPane.showMessageDialog(null,"saisir cin etudiant");
               ok=false;
       }else{
           
            boolean exist_et=false;
        
                 
             try { 
                 Class.forName("com.mysql.jdbc.Driver");
                 con=DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);
             
              pst=con.prepareStatement("select password,role from users where password=?  ");
                    pst.setString(1,cin1);
                      rs=pst.executeQuery();
              if(rs.next()){ 
                  if(rs.getString("role").equals("Etudiant")){
                     exist_et=true;
                  }

              }else{
     JOptionPane.showMessageDialog(null,"etudiant inexistant reesseyer");
              }
              
              if(exist_et){
                   pst=con.prepareStatement("select * from pfe where cin=?  ");
                    pst.setString(1,cin1);
                      rs=pst.executeQuery();
                      if(rs.next()){
                          if(!rs.getString("cin_raport").equals(Enseignant.stock)){
                                 JOptionPane.showMessageDialog(null,"Vous n'avez pas le droit d'affecter une note a cet etudiant");
                          }else{
                              if(note1==""){
                               JOptionPane.showMessageDialog(null," Saisir la note svp");

                              }else{
                                  float note2=Float.parseFloat(note1);
                                  if(note2>20){
                         JOptionPane.showMessageDialog(null," note invalide ");

                                  }else{
                                    Statement  stmt=con.createStatement();
                String sql="update pfe set note_pfe='"+note2+"',etat='evalué' where cin='"+cin1+"'and cin_raport='"+Enseignant.stock+"'";
            stmt.executeUpdate(sql);
      
            
     JOptionPane.showMessageDialog(null," Note Enregistree avec succes");
                              }}
                          }
                      }
                      
                      
              }
              
              
              
           
       } catch (SQLException ex) {
                 Logger.getLogger(Affecter_noteController.class.getName()).log(Level.SEVERE, null, ex);
             }
          
       }  
}
}
