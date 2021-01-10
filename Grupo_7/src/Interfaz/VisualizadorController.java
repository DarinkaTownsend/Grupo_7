/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void TomarCaptura() {
        
    }

    void setStage(Stage stage) {
        this.stage = stage;
    }

    public void regresar() {
        Main main = new Main();
        main.start(new Stage());

        this.stage.close();
    }
}
