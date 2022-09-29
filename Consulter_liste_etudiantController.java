/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Sarah
 */
public class Consulter_liste_etudiantController implements Initializable {

    @FXML
    private TableColumn<Etudiant, Integer> colid;
    @FXML
    private TableColumn<Etudiant, String> colnom;
    @FXML
    private TableColumn<Etudiant, String> colprenom;
    @FXML
    private TableColumn<Etudiant, String> coldate;
    @FXML
    private TableView<Etudiant> table_et;
    
    
      public  Connection  con;
                  String dbName="projet_java";
                  String userName="root";

               ObservableList    <Etudiant> oblist=FXCollections.observableArrayList();
                  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        try {   
                Connection con = connectionClass.getConnection();
           
             ResultSet rs=con.createStatement().executeQuery("select  role,id,nom,prenom,date_naissance from users ");
while (rs.next()){
    
      if(rs.getString("role").equals("Etudiant")){
    oblist.add(new Etudiant(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),rs.getDate("date_naissance")) );
}
}
            
      
   } catch (ClassNotFoundException ex) {
            System.out.println( ex.getMessage());
            } catch (SQLException ex) {
            System.out.println( ex.getMessage());
        }  
       colid.setCellValueFactory(new PropertyValueFactory<>("id"));
         colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
     colprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
         coldate.setCellValueFactory(new PropertyValueFactory<>("date_naissance"));
         table_et.setItems(oblist);    
    }
}
