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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Sarah
 */
public class Ajout_EtudiantController implements Initializable {

    @FXML
    private TextField cin1;

    @FXML
    private Button enreg;

    @FXML
    private TextField nom_et;


    @FXML
    private TextField pre_et;
 @FXML
    private DatePicker mydate;
 
   @FXML
    private TextField user;
 
 //pour la base de donnees   
   public  Connection  con;
                 PreparedStatement pst;
                 ResultSet rs;
    String dbName="projet_java";
        String userName="root";
        String password="";
   
   
    @FXML
    void btn_enreg(ActionEvent event) throws SQLException {

         
    
            String nom=nom_et.getText();
boolean ok=true;
         if(nom.length()==0){
               JOptionPane.showMessageDialog(null,"saisir le nom svp");
               ok=false;
               //JOptionPane.showMessageDialog(null,ok);

         }
                 String prenom=pre_et.getText();

          if(prenom.length()==0){
               JOptionPane.showMessageDialog(null,"saisir le prenom svp");
               ok=false;
               //JOptionPane.showMessageDialog(null,ok);

         }  
                         String id=user.getText();
          if(id.length()==0){
               JOptionPane.showMessageDialog(null,"saisir le username");
               ok=false;
               //JOptionPane.showMessageDialog(null,ok);

         }   
         
                   String cin=cin1.getText();

          if(id.length()==0){
               JOptionPane.showMessageDialog(null,"saisir le numero de votre carte cin");
               ok=false;
               //JOptionPane.showMessageDialog(null,ok);

         }
                LocalDate date=mydate.getValue();
          
        try {
            Class.forName("com.mysql.jdbc.Driver");
      
            con=DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);
            pst=con.prepareStatement("select * from users where username=? and password=? and role='Etudiant'");
            pst.setString(1,id);
            pst.setString(2,cin);
            rs=pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Etudiant Existant");
            ok=false;            
            }
             pst=con.prepareStatement("select * from users where username=?  ");
            pst.setString(1,id);
            rs=pst.executeQuery();
              if(rs.next()){
                JOptionPane.showMessageDialog(null,"username already used");
            ok=false;            
            }
               pst=con.prepareStatement("select * from users where password=?  ");
            pst.setString(1,cin);
            rs=pst.executeQuery();
              if(rs.next()){
                JOptionPane.showMessageDialog(null,"carte cin already used");
            ok=false;            
            }
              if (ok){
                    String sql="insert into users(username,password,nom,prenom,date_naissance,role) values ('"+id+"','"+cin+"','"+nom+"','"+prenom+"','"+date+"','Etudiant')";
        Statement stmt=con.createStatement();
        stmt.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null,"Ajouté(e) avec succés !");

              }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ajout_EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
                
    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
   
    
}
