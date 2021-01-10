/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author darin
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage){
        try {
            FXMLLoader loader = new FXMLLoader();
        
            Parent root = loader.load(getClass().getResourceAsStream("FXMLDocument.fxml"));
        
            final FXMLDocumentController inicio = loader.getController();
            inicio.setStage(stage);
            Scene scene = new Scene(root);             
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
