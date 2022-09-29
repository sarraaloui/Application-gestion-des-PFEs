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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Sarah
 */
public class Ajout_EnseignantController implements Initializable {

    @FXML
    private TextField nom_ens;
    @FXML
    private TextField pre_ens;
    @FXML
    private Button sub;
    @FXML
    private Button retour;
    @FXML
    private TextField user;
    @FXML
    private PasswordField pass;
  @FXML
    private DatePicker mydate;
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
public boolean numerique(String x){
    int i=0; boolean test=true;
    if(x.length()!=8){
test=false;
        }else{
       
    while (i< x.length()&& test ){
        if(x.charAt(i)<'0'||  x.charAt(i) >'9' ){
            test=false;
        }else {
            i++;
        }
    }
   }
  return test;  
}
    @FXML
    private void btn_sub(ActionEvent event) throws SQLException {
        
            
     boolean   ok=true;                       
     String nom=nom_ens.getText();

    if(nom.length()==0){
               JOptionPane.showMessageDialog(null,"saisir le nom de l'enseignant svp");
               ok=false;}
                        String prenom=pre_ens.getText();

      if(prenom.length()==0){
               JOptionPane.showMessageDialog(null,"saisir le prenom de l'enseignant svp");
               ok=false;} 
                          String id=user.getText();

      if(id.length()==0){
               JOptionPane.showMessageDialog(null,"saisir username de l'enseignant svp");
               ok=false;   }
   String cin=pass.getText();
    if(numerique(cin)==false){
    JOptionPane.showMessageDialog(null,"verifier votre cin  ");
        ok=false;}
                         LocalDate date=mydate.getValue();

      
      
                  
        try {
            Class.forName("com.mysql.jdbc.Driver");
       
      
            con=DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);
            pst=con.prepareStatement("select * from users where username=? and password=?");
            pst.setString(1,id);
            pst.setString(2,cin);
            rs=pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"enseignant Existant");
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
                    String sql="insert into users(username,password,nom,prenom,date_naissance,role) values ('"+id+"','"+cin+"','"+nom+"','"+prenom+"','"+date+"','Enseignant')";
        Statement stmt=con.createStatement();
        stmt.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null,"Ajouté(e) avec succés !");
              }
            
       
          
             } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ajout_EnseignantController.class.getName()).log(Level.SEVERE, null, ex);
        } //mtaa l catch    
                    
        
      }

    @FXML
    private void btn_retour(ActionEvent event) {
        
    }
    
}
