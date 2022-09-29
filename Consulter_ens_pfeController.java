/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Sarah
 */
public class Consulter_ens_pfeController implements Initializable {

    @FXML
    private TableView<Pfe1> table_ens;
    @FXML
    private TableColumn<Pfe1, String> colsujet;
    @FXML
    private TableColumn<Pfe1, String> colcin_et;
    @FXML
    private TableColumn<Pfe1, String> col_etat;
    @FXML
    private TableColumn<Pfe1, String> col_ets;
   
       @FXML
   private  TextField cin_et;
    
 Connection  con;
                  String dbName="projet_java";
                  String userName="root";

               ObservableList <Pfe1> oblist=FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
                  
          try {   
             Connection con = connectionClass.getConnection();
             ResultSet rs=con.createStatement().executeQuery("select sujet,entreprise,cin,etat from pfe where cin_enc='"+Enseignant.stock+"' ");
while (rs.next()){
        oblist.add(new Pfe1(rs.getString("sujet"),rs.getString("cin"),rs.getString("etat"),rs.getString("entreprise")) );

    }      
    
   } catch (ClassNotFoundException | SQLException ex) {
            System.out.println( ex.getMessage());
            }  
        colsujet.setCellValueFactory(new PropertyValueFactory<>(("sujet")));
         col_ets.setCellValueFactory(new PropertyValueFactory<>("entreprise"));
     colcin_et.setCellValueFactory(new PropertyValueFactory<>("cin"));
     col_etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        table_ens.setItems(oblist);  
    }    
  
    
    
}
