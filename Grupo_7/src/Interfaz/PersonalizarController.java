/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author darin
 */
public class PersonalizarController implements Initializable {
    private Stage stage;
    @FXML
    private ChoiceBox Extensiones;
    
    
    @FXML
    public void AgregarExtension(){
        
    }
    
    @FXML
    public void QuitarExtension(){
        
    }
    
    @FXML
    public void EscogerColor(){
        
    }
    
    @FXML
    public void AplicarCambios(){
        
    }
    
    @FXML
    public void Regresar(){
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
public void setStage(Stage stage){
        this.stage=stage;
    }
    
}
