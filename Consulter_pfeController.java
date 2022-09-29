/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import static com.sun.org.apache.xerces.internal.xinclude.XIncludeHandler.BUFFER_SIZE;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.sql.Blob;
import java.sql.Clob;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JPanel;
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

/**
 * FXML Controller class
 *
 * @author Sarah
 */
public class Consulter_pfeController implements Initializable {

    @FXML
    private TableView<Pfe> table_pfe;
    @FXML
    private TableColumn<Pfe, String> col_suj;
    @FXML
    private TableColumn<Pfe, String> col_ets;
    @FXML
    private TableColumn<Pfe, String> colcin1;
    @FXML
    private TableColumn<Pfe, String> colbin;
    @FXML
    private TableColumn<Pfe, String> colcin2;
    @FXML
    private TableColumn<Pfe, String> col_etat;

    @FXML
    private TableColumn<Pfe, String> col_encad;
    @FXML
    private TableColumn<Pfe, String> col_rap;
     @FXML
 public  Connection  con;
                  String dbName="projet_java";
                  String userName="root";

               ObservableList <Pfe> oblist=FXCollections.observableArrayList();
                  
        
         /*      
               m_PDFViewer = new PDFViewer();
		BorderPane borderPane = new BorderPane(m_PDFViewer);
		Scene scene = new Scene(borderPane);
		stage.setTitle("JavaFX PDFViewer - Qoppa Software");
		stage.setScene(scene);
		stage.centerOnScreen();
		stage.show();
	
               
               
         
               void openpdf(String file){
                   
                   try{
                       SwingController control=new SwingController();
                       SwingViewBuilder factry=new SwingViewBuilder(control);
                       JPanel veiwerCompnt1=factry.buildViewerPanel();
                       ComponentKeyBinding.install(control,veiwerCompnt1);
                       control.getDocumentViewController().setAnnotationCallback(
                       new org.icepdf.ri.common.MyAnnotationCallback(
                       control.getDocumentViewController()));
                       control.openDocument(file);
                    // jScrollPane2.setViewportView(veiwerCompnt1);
                       
                   }catch(Exception ex){
                       
                   }
                   
               }  */
    /**    
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

         
          try {   
             Connection con = connectionClass.getConnection();
             ResultSet rs=con.createStatement().executeQuery("select sujet,entreprise,cin,binome,cinb,etat,cin_enc,cin_raport from pfe ");
while (rs.next()){
        oblist.add(new Pfe(rs.getString("sujet"),rs.getString("entreprise"),rs.getString("cin"),rs.getString("binome"),rs.getString("cinb"),rs.getString("etat"),rs.getString("cin_enc"),rs.getString("cin_raport")) );

    }      
    
   } catch (ClassNotFoundException | SQLException ex) {
            System.out.println( ex.getMessage());
            }  
       col_suj.setCellValueFactory(new PropertyValueFactory<Pfe, String>("sujet"));
         col_ets.setCellValueFactory(new PropertyValueFactory<Pfe, String>("entreprise"));
     colcin1.setCellValueFactory(new PropertyValueFactory<Pfe, String>("cin"));
         colbin.setCellValueFactory(new PropertyValueFactory<Pfe,String>("binome"));
         colcin2.setCellValueFactory(new PropertyValueFactory<Pfe, String>("cinb"));
         col_etat.setCellValueFactory(new PropertyValueFactory<Pfe, String>("etat"));
          col_encad.setCellValueFactory(new PropertyValueFactory<Pfe, String>("cin_enc"));
          col_rap.setCellValueFactory(new PropertyValueFactory<Pfe, String>("cin_raport"));

         
         
         table_pfe.setItems(oblist);    
    }
        
    @FXML
    private Button rapports;

   

    @FXML
    void btn_rapports(ActionEvent event) throws IOException {
        
         Parent root= FXMLLoader.load(getClass().getResource("Lesrapports.fxml"));
        Scene scene= new Scene(root);
        Stage stage= (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Les Rapports");
        stage.show();
    }    
}

