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
    public static ObservableList<ColorArchivo> items;
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
                items.add(nuevo);
                Extensiones.setItems(items);
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
        items = FXCollections.observableArrayList();
        Color azul = Color.web("#98c5ea");
        Color azulClaro = Color.web("#97bbe8");
        Color rojo = Color.web("#f4a59d");
        Color naranja = Color.web("#e9967a");
        Color verdeClaro = Color.web("#d0ece1");
        Color verdeOscuro = Color.web("#91d2b9");
        Color morado = Color.web("#d8bfd8");
        Color AmarilloOscuro = Color.web("#efd52e");
        Color AmarilloClaro = Color.web("#faf3c3");
        Color cafe = Color.web("#e3b57e");

        ColorArchivo word=new ColorArchivo(".doc",azul);
        ColorArchivo word2=new ColorArchivo(".docx",azulClaro);
        ColorArchivo excel=new ColorArchivo(".xlsx",verdeOscuro);
        ColorArchivo powerPoint=new ColorArchivo(".ppt",naranja);
        ColorArchivo pdf=new ColorArchivo(".pdf",rojo);
        ColorArchivo imagenesJPG=new ColorArchivo(".jpg",AmarilloOscuro);
        ColorArchivo imagenesPNG=new ColorArchivo(".png",AmarilloClaro);
        ColorArchivo Texto=new ColorArchivo(".txt",morado);
        ColorArchivo csv =new ColorArchivo(".csv",cafe);        
        
        items.addAll(word,word2,excel,powerPoint,pdf,imagenesPNG,imagenesJPG,Texto,csv);
        Extensiones.setItems(items);
        //Plano.getChildren().add(Extensiones);
        
        
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
        Main main= new Main();       
        main.start(new Stage());

        this.stage.close();
        
    }
    
    
public void setStage(Stage stage){
        this.stage=stage;
    }
    
}
