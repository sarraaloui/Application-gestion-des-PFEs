/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.net.URL;
import java.sql.Connection;
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
public class Etat_pfeController implements Initializable {

    @FXML
    private TableView<etat_pfe> table;
    @FXML
    private TableColumn<etat_pfe, String> col_cin;
    @FXML
    private TableColumn<etat_pfe, String> col_etat;
                       ObservableList <etat_pfe> oblist=FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
   
         try {   
                Connection con = connectionClass.getConnection();
             ResultSet rs=con.createStatement().executeQuery("select * from pfe where cin='"+Etudiant.stock+"' or cinb='"+Etudiant.stock+"' ");
if (rs.next()){
    
 oblist.add (new etat_pfe (Etudiant.stock,rs.getString("etat")));
   }
 
   
      
       
      
   } catch (ClassNotFoundException ex) {
            System.out.println( ex.getMessage());
            } catch (SQLException ex) {
            System.out.println( ex.getMessage());
        } 
         
     col_cin.setCellValueFactory(new PropertyValueFactory<>(Etudiant.stock));
         col_etat.setCellValueFactory(new PropertyValueFactory<>("etat"));    
                   table.setItems(oblist);  

        
    }    
    
}
