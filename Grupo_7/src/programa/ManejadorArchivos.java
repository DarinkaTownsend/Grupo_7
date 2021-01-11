/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import java.io.File;
import java.util.TreeMap;
import javafx.scene.layout.AnchorPane;
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
    
    public static String ObtenerPeso(double peso){
        int c=0;
        while(peso>1024.0){
            peso/=1024;
            c++;
        }
        
        return peso+" "+pesos[c];
    }
    public static void leerArchivoColores(){
        //TODO
        
    }
    
    public static void escribirArchivoColores(){
        //TODO
    }
}
