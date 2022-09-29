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
public class Espace_etudiantController implements Initializable {

    @FXML
    private Button depot_sujet;
    @FXML
    private Button depot_rapport;
    @FXML
    private Button etat;

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
    private void btn_depot(ActionEvent event) throws IOException {
            AnchorPane view = FXMLLoader.load(getClass().getResource("Deposer_sujet.fxml"));
        borderpane.setCenter(view);
    }

    @FXML
    private void btn_rapport(ActionEvent event) throws IOException {
          AnchorPane view = FXMLLoader.load(getClass().getResource("Deposer_rapport.fxml"));
        borderpane.setCenter(view);
    }

    @FXML
    private void btn_etat(ActionEvent event) throws IOException {
              AnchorPane view = FXMLLoader.load(getClass().getResource("Etat_pfe.fxml"));
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
}
