/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sarah
 */
public class Espace_adminController implements Initializable {

    @FXML
    private Button ajout_et;
    @FXML
    private Button liste_et;
    @FXML
    private Button ajout_ens;

     @FXML
    private BorderPane borderpane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn_ajout_et(ActionEvent event) throws IOException {
        //borderpane
        AnchorPane view = FXMLLoader.load(getClass().getResource("Ajout_Etudiant.fxml"));
        borderpane.setCenter(view);
    }

    @FXML
    private void btn_liste_et(ActionEvent event) throws IOException {
         AnchorPane view = FXMLLoader.load(getClass().getResource("Consulter_liste_etudiant.fxml"));
        borderpane.setCenter(view);
    }

    @FXML
    private void btn_ajout_ens(ActionEvent event) throws IOException {
         AnchorPane view = FXMLLoader.load(getClass().getResource("Ajout_Enseignant.fxml"));
        borderpane.setCenter(view);
    }
    
        @FXML
    private void btn_list_ens (ActionEvent event) throws IOException {
         AnchorPane view = FXMLLoader.load(getClass().getResource("consulter_liste_ens.fxml"));
        borderpane.setCenter(view);
    }
      @FXML
    private void btn_affecter_encadrent (ActionEvent event) throws IOException {
         AnchorPane view = FXMLLoader.load(getClass().getResource("Affecter_encadreur.fxml"));
        borderpane.setCenter(view);
    }
      @FXML
    private void btn_decnx (ActionEvent event) throws IOException {
       Parent root= FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene= new Scene(root);
        Stage stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }
     @FXML
    private void btn_pfe(ActionEvent event) throws IOException {
         AnchorPane view = FXMLLoader.load(getClass().getResource("Consulter_pfe.fxml"));
        borderpane.setCenter(view);
    }
}
