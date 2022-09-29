/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 *
 * @author Sarah
 */
public class FXMLDocumentController implements Initializable {
    
   
    
    
    @FXML
    private Button btnok;


    @FXML
    private PasswordField txtpass;

    @FXML
    private TextField txtuname;

             public  Connection  con;
                 PreparedStatement pst;
                 ResultSet rs;
    String dbName="projet_java";
        String userName="root";
        String password="";
    
    @FXML
    void login(ActionEvent event) throws SQLException, IOException {
     Boolean    ok=true;
    //    JOptionPane.showMessageDialog(null,"hi");
      String uname=txtuname.getText();
      String pass=txtpass.getText();
      
      if(uname.equals("")&& pass.equals("")){
          JOptionPane.showMessageDialog(null,"Saisir vos coordonnées svp");
      }else {
      
        try {
   
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);
            pst=con.prepareStatement("select * from users where username=? and password=?");
            pst.setString(1,uname);
            pst.setString(2,pass);
            rs=pst.executeQuery();
       while(rs.next()){
      if(rs.getString("password").equals("sarra")&& rs.getString("username").equals("sarra"))                
         {
        Parent root= FXMLLoader.load(getClass().getResource("espace_admin.fxml"));
        Scene scene= new Scene(root);
        Stage stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Espace Admin");
        stage.show();
    ok=false;
                
             }} 
      //else{
      
           pst=con.prepareStatement("select * from users where username=? and password=?");
            pst.setString(1,uname);
            pst.setString(2,pass);
            rs=pst.executeQuery();
              while(rs.next()){
              if(rs.getString("role").equals("Enseignant"))                
         {
           
                   Enseignant.stock=rs.getString("password");
             //       System.out.println(Enseignant.stock);
             Parent root= FXMLLoader.load(getClass().getResource("Espace_enseignant.fxml"));
        Scene scene= new Scene(root);
        Stage stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene); ok=false;
        stage.setTitle("Espace Enseignant");
        stage.show();
   
         }
              }
    
              
              
              
               pst=con.prepareStatement("select * from users where username=? and password=?");
            pst.setString(1,uname);
            pst.setString(2,pass);
            rs=pst.executeQuery();
              while(rs.next()){
              if(rs.getString("role").equals("Etudiant"))                
         {
           
                   Etudiant.stock=rs.getString("password");
             //       System.out.println(Enseignant.stock);
             Parent root= FXMLLoader.load(getClass().getResource("Espace_etudiant.fxml"));
        Scene scene= new Scene(root);
        Stage stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Espace Etudiant"); 
        ok=false;
        stage.show();
   
         }
              }
              
         
                 pst=con.prepareStatement("select * from users where username=? and password=? ");
            pst.setString(1,uname);
            pst.setString(2,pass);
            rs=pst.executeQuery();
              if(!rs.next()){
                 JOptionPane.showMessageDialog(null,"login failed");
                txtuname.setText("");
                txtpass.setText("");
               txtuname.requestFocus();}
              
        //  }  
       
       }  catch (Exception ex) {
           System.out.println(ex.getMessage());
        }
          
        
        
        
      
      
       
  

    

  
/*
        connectionClass connection=new connectionClass();
        Connection conn;
        conn = connection.getConnection();
          String sql="select username,password from admin ;";
        Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=stmt.executeQuery(sql);}
       */

          

    
        
        
        /*
        INSERTION 
        String sql="insert into admin values ('"+textField.getText()+"','"+textField1.getText()+"')";
        Statement stmt=conn.createStatement();
        stmt.executeUpdate(sql);
        */
        

      }}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
