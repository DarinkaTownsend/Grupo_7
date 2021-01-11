/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
    private Rectangle VistaColor;
    @FXML
    private AnchorPane Plano;
    @FXML
    private TextField IngresoExtension=null;
    @FXML
    private ColorPicker colorPicker;
    
    @FXML
    private ComboBox<ColorArchivo> Extensiones;
    @FXML
    private Label mensaje;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colorPicker.setValue(Color.DODGERBLUE);
        llenarComboBox();
    }
    
    @FXML
    public void AgregarExtension(){
        if(IngresoExtension.getText().isEmpty()){
            mensaje.setText("Ingrese una extensión");
        }else{
            if(colorPicker.getValue()==null){
                mensaje.setText("Escoja un color para la nueva extensión");
                
            }else{
                ColorArchivo nuevo=new ColorArchivo(IngresoExtension.getText(),colorPicker.getValue());
                FXMLDocumentController.items.add(nuevo);
                Extensiones.setItems(FXMLDocumentController.items);
                mensaje.setText("Extensión añadida");
                IngresoExtension.setText("");
            }
            
        }
    }
    
    @FXML
    public void QuitarExtension(){
        ColorArchivo remover = Extensiones.getValue();
        Extensiones.getItems().remove(remover);
        mensaje.setText("Extensión removida");      
    }
    
    @FXML
    public void IniciarCombo(){
        Color colorExtension;
        if(Extensiones.getValue() == null){
            Extensiones.setValue(Extensiones.getItems().get(0));
        }
        colorExtension = Extensiones.getValue().getColorExtension();
        VistaColor.setFill(colorExtension);
        }
    
    public void llenarComboBox(){        
        Extensiones.setItems(FXMLDocumentController.items);
        //Plano.getChildren().add(Extensiones);
        
        
    }
    @FXML
    public void EscogerColor(){
       VistaColor.setFill(colorPicker.getValue());
    }
    

    @FXML
    public void CambiarColor(){
        if(Extensiones.getValue()==null){
            mensaje.setText("Escoja una extensión de la lista");
        }else{
            ColorArchivo cambiar = Extensiones.getValue();
            cambiar.setColorExtension(colorPicker.getValue());
            mensaje.setText("Color cambiado");
        }
    }
    
    @FXML
    public void Regresar(){
        Main main= new Main();       
        main.start(new Stage());

        this.stage.close();
        
    }
    
    
public void setStage(Stage stage){
        this.stage=stage;
    }
    
}
