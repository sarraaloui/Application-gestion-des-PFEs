/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Sarah
 */
public class Deposer_rapportController implements Initializable {

    
   public  Connection  con;
                  String dbName="projet_java";
                  String userName="root";

    /**
     * Initializes the controller class.
     */
    
    final FileChooser fc=new  FileChooser();
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
     //   fileChooser.setInitialDirectory(new File("C:\\PFE"));
    
    }    
    ResultSet rs,rs1;
              PreparedStatement pst,pst1;

     @FXML
    private Button btnOpenFile;
  @FXML
    private TextArea taOpenfile;
    @FXML
    void handleopenFile(ActionEvent event) throws SQLException, ParseException {
        
        try {
            
            
            Class.forName("com.mysql.jdbc.Driver");
       
             con=DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,"");
            pst=con.prepareStatement("select * from pfe where cin=? ");
            pst.setString(1,Etudiant.stock);
          
            rs=pst.executeQuery();
        //verifier si il a terminer son stage
           // String sdate=rs.getString("date_depot");0000-00-00
         if(rs.next()){

           Date d= new Date();
          if(LocalDate.now().compareTo(rs.getDate("date_depot").toLocalDate())<3 ) {
                 JOptionPane.showMessageDialog(null,"Vous navez pas terminer votre stage");

          }else{
               Statement  stmt=con.createStatement();
                          
fc.setTitle("My File Chooser");
fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF File","*pdf"));
File file=fc.showOpenDialog(null);
taOpenfile.appendText(file.getAbsolutePath()+"\n");
        
        String  sql="update pfe set etat='en attente de rapporteur',rapport='"+file.getAbsolutePath()+"'where cin='"+Etudiant.stock+"'";
            stmt.executeUpdate(sql);
      
            
     JOptionPane.showMessageDialog(null," etat effectue avec succes");
          }
         
             
             
         }
            
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Deposer_rapportController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
       
        

    }
    
}
