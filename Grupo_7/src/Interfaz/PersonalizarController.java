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
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author darin
 */
public class PersonalizarController implements Initializable {
    private Stage stage;
    private Color cambioColor;
    @FXML
    private ChoiceBox Extensiones;
    @FXML
    private Rectangle VistaColor;
    @FXML
    private TextField IngresoExtension;
    @FXML
    private ColorPicker colorPicker;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colorPicker.setValue(Color.DODGERBLUE);
    }
    
    @FXML
    public void AgregarExtension(){
        
    }
    
    @FXML
    public void QuitarExtension(){
        
    }
    
    @FXML
    public void EscogerColor(){
       VistaColor.setFill(colorPicker.getValue());
    }
    

    @FXML
    public void AplicarCambios(){
        
    }
    
    @FXML
    public void Regresar(){
        
    }
    
    
public void setStage(Stage stage){
        this.stage=stage;
    }
    
}
