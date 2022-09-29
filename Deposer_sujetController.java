/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.JDBCType.NULL;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Sarah
 */
public class Deposer_sujetController implements Initializable {

    @FXML
    private TextField sujet;
    @FXML
    private TextField ets;
    @FXML
    private TextField cin1;
    @FXML
    private TextField nom1;
    @FXML
    private RadioButton O;
    @FXML
    private ToggleGroup R1;
    @FXML
    private RadioButton N;
    @FXML
    private TextField nom2;
    @FXML
    private TextField cin2;
    @FXML
    private Button deposer;
  public  Connection  con;
                 PreparedStatement pst;
                 ResultSet rs;
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
    private void btn_deposer(ActionEvent event) throws SQLException {
     
         String   sujet1=sujet.getText();
     String   nom=nom1.getText();
     String   ets1=ets.getText();
          String   nom3=nom2.getText();
          String   cin3=cin2.getText();
          
          if(sujet1.equals("")){
               JOptionPane.showMessageDialog(null,"choisir votre sujet ");
          }
          
          if(ets1.equals("")){
               JOptionPane.showMessageDialog(null,"choisir l'entreprise ");              
          }
          
     //Pour sassurer quil a choisi une des 2 boutons radios
        if(!O.isSelected()&& !N.isSelected()){
         JOptionPane.showMessageDialog(null,"choisir si vous avez un(e) binome");}
        
        if(!ets1.equals("")&& N.isSelected() && !sujet1.equals("")){
            
             try {
                 Class.forName("com.mysql.jdbc.Driver");
                   con=DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);
    
            pst=con.prepareStatement("select * from pfe where cin=? or cinb=?");
            pst.setString(1,Etudiant.stock);
            pst.setString(2,Etudiant.stock);           
            rs=pst.executeQuery();
        if(rs.next()){
            JOptionPane.showMessageDialog(null,"Vous avez deja deposé !");
        }else{
             Statement stmt; 
                stmt=con.createStatement();
        String sql="insert into pfe(sujet,entreprise,cin,binome,etat,date_depot) values ('"+sujet1+"','"+ets1+"','"+Etudiant.stock+"','N','en cours d''encadrement','"+java.time.LocalDate.now()+"')";
       stmt.executeUpdate(sql);
                               JOptionPane.showMessageDialog(null,"Votre sujet est ajouté avec succés !");
        }
            
             } catch (ClassNotFoundException ex) {
                 Logger.getLogger(Deposer_sujetController.class.getName()).log(Level.SEVERE, null, ex);
             }
            
           
            
        } // cas mtaa non
        
     if(O.isSelected() && !sujet1.equals("")&& !ets1.equals("")){
        boolean ok=true;
         if(cin3.equals("")){
      JOptionPane.showMessageDialog(null,"Saisir le cin de votre binome svp !");
             ok=false;
         }else{
            try {
                //Cas mtaa binome inexistant
                Class.forName("com.mysql.jdbc.Driver");
          
            con=DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);
    
            pst=con.prepareStatement("select * from users where password=? and role='Etudiant'");
            pst.setString(1,cin3);
            rs=pst.executeQuery();
            if(!rs.next()){
                JOptionPane.showMessageDialog(null,"Binome inexistante dans la base"); 
                ok=false;
            }else {
                //binome existe
                //on va voir si lbinome a deposer le sujet avec letudient courant
                
                 pst=con.prepareStatement("select * from pfe where (cin=? or cinb=?) and (cin='"+Etudiant.stock+"' or cinb='"+Etudiant.stock+"')");
            pst.setString(1,cin3);
              pst.setString(2,cin3);
              
            rs=pst.executeQuery();
                if(rs.next()){
                    ok=false;
                  JOptionPane.showMessageDialog(null,"Votre binome a deja depose votre sujet"); 
                }
                //cas mtaa binome aandou deja andou binome ekherr
            pst=con.prepareStatement("select * from pfe where (cin=? or cinb=?) and (cin!='"+Etudiant.stock+"' or cinb!='"+Etudiant.stock+"')");
 pst.setString(1,cin3);
              pst.setString(2,cin3);
             
            rs=pst.executeQuery();
                if(rs.next()){
                    ok=false;
         JOptionPane.showMessageDialog(null,"Votre binome est affecte avec un autre etudiant"); 
                }
                //cas mtaa binome individuel
                pst=con.prepareStatement("select * from pfe where (cin=? or cinb=?)");
 pst.setString(1,cin3);
              pst.setString(2,cin3);
              if(rs.next()){
                  ok=false;
              JOptionPane.showMessageDialog(null,"Votre binome a depose son projet individuel"); 
              }
              if(ok){
                  Statement stmt; 
                stmt=con.createStatement();
        String sql="insert into pfe(sujet,entreprise,cin,binome,cinb,nomb,etat,date_depot) values ('"+sujet1+"','"+ets1+"','"+Etudiant.stock+"','"+'O'+"','"+cin3+"','"+nom3+"','en cours d''encadrement','"+java.time.LocalDate.now()+"')";
       stmt.executeUpdate(sql);
       
                        JOptionPane.showMessageDialog(null,"Votre sujet est ajouté avec succés !");
              }  
              
              
              
            }
         
             
              } catch (ClassNotFoundException ex) {
                Logger.getLogger(Deposer_sujetController.class.getName()).log(Level.SEVERE, null, ex);
            }
             
         }
         
         
     } //mtaa l oui
        
        
    }
}
        
    
    

