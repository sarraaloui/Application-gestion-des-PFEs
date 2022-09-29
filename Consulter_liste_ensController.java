/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Sarah
 */
public class Consulter_liste_ensController implements Initializable {

    @FXML
    private TableColumn<Enseignant, Integer> colid;
    @FXML
    private TableColumn<Enseignant, String> colnom;
    @FXML
    private TableColumn<Enseignant, String> colprenom;
    @FXML
    private TableColumn<Enseignant, Date> coldate;
     @FXML
    private TableColumn<Enseignant, String> colcin1;

    @FXML
    private TableView<Enseignant> table_ens;

        public  Connection  con;
                  String dbName="projet_java";
                  String userName="root";
               ObservableList   <Enseignant> oblist=FXCollections.observableArrayList();
                  
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         try {   
                Connection con = connectionClass.getConnection();
             ResultSet rs=con.createStatement().executeQuery("select * from users ");
while (rs.next()){
  if(rs.getString("role").equals("Enseignant")){
   
 oblist.add (new Enseignant(rs.getString("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("date_naissance"),rs.getString("password")));
  }
}      
       
      
   } catch (ClassNotFoundException ex) {
            System.out.println( ex.getMessage());
            } catch (SQLException ex) {
            System.out.println( ex.getMessage());
        } 
   colid.setCellValueFactory(new PropertyValueFactory<>(("id")));
         colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
     colprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
         coldate.setCellValueFactory(new PropertyValueFactory<>("date_naissance"));   
         colcin1.setCellValueFactory(new PropertyValueFactory<>("password"));    
          table_ens.setItems(oblist);  


       
    }
        
        
    }    
    

