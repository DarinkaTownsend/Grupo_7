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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private Label mensaje;
    @FXML
    private AnchorPane ventana1;
    @FXML
    private TextField escribirRuta;
    @FXML
    private Button visualizar;
    @FXML
    private ImageView image;
    
    public static File ruta;
    @FXML
    public void BuscarRuta(){
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int seleccion = fc.showOpenDialog(fc);
        if(seleccion == JFileChooser.APPROVE_OPTION){
            File fichero = fc.getSelectedFile();
            escribirRuta.setText(fichero.getAbsolutePath());
            ruta=fichero;
        }
    }
    
    @FXML
    public void Personalizar(){
        CambiarAPersonalizar cambioP = new CambiarAPersonalizar();        
        cambioP.start(new Stage());
        this.stage.close();
    }
    
    
    public boolean ComprobarRuta(){
        File ru=new File(escribirRuta.getText());
        if(escribirRuta.getText().isEmpty()){
            mensaje.setText("Escoja Ruta");
            return false;
        }if(!ru.exists()){
            mensaje.setText("La ruta no existe");
            return false;
        }if(ru.isFile()){
            mensaje.setText("Escoja una carpeta");
            return false;
        }
        ruta=ru;
        return true;
    }
    
    @FXML
    public void Visualizar(){
        
        if (ComprobarRuta()) {
            CambiarAVisualizar cambioV = new CambiarAVisualizar();
            cambioV.start(new Stage());
            this.stage.close();
        }
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        image.setImage(new Image("/recursos/fondo2.jpg"));
    }    

    void setStage(Stage stage) {
        this.stage=stage;
    }
    
}
