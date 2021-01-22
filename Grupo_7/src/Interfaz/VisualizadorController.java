/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import programa.ManejadorArchivos;


/**
 * FXML Controller class
 *
 * @author darin
 */
public class VisualizadorController implements Initializable {

    @FXML
    private Label peso;
    @FXML
    private Label mensajeGuardado;
    @FXML
    private Button capturar;
    
    private Stage stage;
    @FXML
    private AnchorPane pane;
    @FXML
    private HBox box;
    @FXML
    private HBox base;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarContenido();
        
    }

    @FXML
    public void TomarCaptura() throws IOException {
        
        try {
            Robot robot = new Robot();
            java.awt.Rectangle rectangulo = new java.awt.Rectangle();
            rectangulo.setFrame(stage.getX()+7,stage.getY(),stage.getWidth()-14,stage.getHeight()-7);

            BufferedImage image = robot.createScreenCapture(rectangulo);
            Image myImage = SwingFXUtils.toFXImage(image, null);
            ImageIO.write(image, "jpg", new File("captura.jpg"));
            mensajeGuardado.setText("Guardado!");

        } catch (AWTException ex) {
            Logger.getLogger(VisualizadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void regresar() {
        Main main = new Main();
        main.start(new Stage());

        this.stage.close();
    }
    
    private void cargarContenido(){
        TreeMap<Long,File> map;
        File archivo = FXMLDocumentController.ruta;
        map = ManejadorArchivos.crearMapa(archivo);
        boolean plantilla = true;
        long tamaño = ManejadorArchivos.tamCarpeta(archivo);
        peso.setText(peso.getText()+ManejadorArchivos.ObtenerPeso(tamaño));
        double xMax =box.getPrefWidth();
        double yMax =box.getPrefHeight();
        
        box = crearTreeMap(box,tamaño,xMax,yMax,map,plantilla);
        
    }
    
    private HBox crearTreeMap(HBox root, double tamaño, double xMax, double yMax, TreeMap<Long,File> mapa, boolean plantilla){
        
        for (Map.Entry<Long,File> entry : mapa.entrySet()) {
            
                double percent = entry.getKey()/tamaño;
                if(entry.getValue().isDirectory()){
                    VBox nBox = new VBox();
                    nBox.setPrefSize(xMax*percent, yMax);
                    TreeMap<Long,File> nMap = ManejadorArchivos.crearMapa(entry.getValue());
                    double nTam = (double)ManejadorArchivos.tamCarpeta(entry.getValue());
                    root.getChildren().add(crearTreeMap(nBox,nTam,xMax*percent,yMax,nMap,false));
                    if(plantilla)
                        colocarUbicacion(xMax*percent,yMax,entry.getValue().getName(),entry.getKey(),entry.getValue());
                }
                else{
                    Rectangle r = new Rectangle();
                    r.setWidth(xMax*percent);
                    r.setHeight(yMax);
                    r.setFill(obtenerColor(entry.getValue()));
                    root.getChildren().add(r);
                    if(plantilla)                    
                        colocarUbicacion(xMax*percent,yMax,entry.getValue().getName(),entry.getKey(),entry.getValue());
                }
            
        }
        return root;
    }
    
    private VBox crearTreeMap(VBox root, double tamaño, double xMax, double yMax, TreeMap<Long,File> mapa, boolean plantilla){
        for (Map.Entry<Long,File> entry : mapa.entrySet()) {
            
                double percent = entry.getKey()/tamaño;
                if(entry.getValue().isDirectory()){
                    HBox nBox = new HBox();
                    nBox.setPrefSize(xMax, yMax*percent);
                    TreeMap<Long,File> nMap = ManejadorArchivos.crearMapa(entry.getValue());
                    double nTam = (double)ManejadorArchivos.tamCarpeta(entry.getValue());
                    root.getChildren().add(crearTreeMap(nBox,nTam,xMax,yMax*percent,nMap,plantilla));
                }
                else{
                    Rectangle r = new Rectangle();
                    r.setWidth(xMax);
                    r.setHeight(yMax*percent);
                    r.setFill(obtenerColor(entry.getValue()));
                    root.getChildren().add(r);
                }
            
        }
        return root;
    }

    private Paint obtenerColor(File arch) {
	String fileName = arch.getName();
	String ext = "";
	int i = fileName.lastIndexOf('.');
	if (i > 0) {
	    ext = fileName.substring(i+1);
	}
        ext="."+ext;
        Color color=null;
        for(ColorArchivo c :FXMLDocumentController.items ){
            if(c.getExtension().equals(ext)){
                color = c.getColorExtension();
                break;
            }
        }
        if(color == null)
            color = Color.GRAY;
        
        return color;
    }
    
    private void abrirUbicacion(File archivo){
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(archivo);
        } catch (IOException ex) {
            Logger.getLogger(VisualizadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void colocarUbicacion(double xMax, double yMax, String nombre, long peso, File archivo){
        VBox newBox = new VBox();
        newBox.setAlignment(Pos.TOP_LEFT);
        newBox.setPrefSize(xMax, yMax);
        Label lbl = new Label(nombre+": "+ManejadorArchivos.ObtenerPeso(peso));
        lbl.setWrapText(true);
        lbl.setTextFill(Color.web("#ffffff"));
        lbl.setFont(Font.font("Verdana",FontWeight.BOLD,12));
        newBox.getChildren().add(lbl);
        newBox.setOnMouseClicked(e->abrirUbicacion(archivo));
        base.getChildren().add(newBox);
    }
}
