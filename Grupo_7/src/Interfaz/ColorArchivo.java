/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import javafx.scene.paint.Color;

/**
 *
 * @author darin
 */
public class ColorArchivo {

    private String extension;
    private Color colorExtension;

    public ColorArchivo(String extension, Color colorExtension) {
        this.extension = extension;
        this.colorExtension = colorExtension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setColorExtension(Color colorExtension) {
        this.colorExtension = colorExtension;
    }

    public String getExtension() {
        return extension;
    }

    public Color getColorExtension() {
        return colorExtension;
    }
    
    @Override
    public String toString(){
        return extension;
    }
}
