/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

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
    public void AgregarExtension(){
        
    }
    
    @FXML
    public void QuitarExtension(){
        
    }
    
    @FXML
    public void EscogerColor(){
        JPanel contentPane = new JPanel();
        Color color=JColorChooser.showDialog(contentPane, "Elige un color", Color.BLUE);
        VistaColor.setStyle("-fx-background-color:"+color2HexString(color));        
    }
    public String color2HexString(Color color) {
        return "#" + Integer.toHexString(color.getRGB() & 0x00ffffff);
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
