/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;


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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void TomarCaptura() throws IOException {
        
        try {
            Robot robot = new Robot();
            Rectangle rectangulo = new Rectangle();
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
}
