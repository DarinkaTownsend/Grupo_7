/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JFileChooser;

/**
 *
 * @author darin
 */
public class FXMLDocumentController implements Initializable {
    private Stage stage;
    @FXML
    private Label label;
    @FXML
    private AnchorPane ventana1;
    @FXML
    private TextField escribirRuta;
    @FXML
    public void BuscarRuta(){
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int seleccion = fc.showOpenDialog(fc);
        if(seleccion == JFileChooser.APPROVE_OPTION){
            File fichero = fc.getSelectedFile();
            escribirRuta.setText(fichero.getAbsolutePath());
        }
    }
    
    @FXML
    public void Personalizar(){
        CambiarAPersonalizar cambioP = new CambiarAPersonalizar();        
        cambioP.start(new Stage());        
    }
    
    @FXML
    public void Visualizar(){
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setStage(Stage stage) {
        this.stage=stage;
    }
    
}
