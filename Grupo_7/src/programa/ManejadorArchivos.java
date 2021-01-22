/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import Interfaz.ColorArchivo;
import static Interfaz.FXMLDocumentController.items;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.TreeMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javax.swing.JFileChooser;

/**
 *
 * @author darin
 */
public class ManejadorArchivos {
    private static String[] pesos = {"B","KB","MB","GB"};
    
    public static TreeMap crearMapa(File archivo){
        TreeMap<Long, File> mapa = new TreeMap<>();
        for(File f : archivo.listFiles()){
            if(f.isDirectory()){
                int n = f.list().length;
                if(n!=0)
                    mapa.put(tamCarpeta(f), f);
            }
            else
                mapa.put(f.length(), f);
        }
        return mapa;
    }

    public static long tamCarpeta(File directory) {
    long length = 0;
    for (File file : directory.listFiles()) {
        if (file.isFile())
            length += file.length();
        else
            length += tamCarpeta(file);
    }
    return length;
    }
    
    public static String ObtenerPeso(long peso){
        int c=0;
        while(peso>1024.0){
            peso/=1024;
            c++;
        }
        
        return (int)peso+" "+pesos[c];
    }

    
    
    
   
    }




