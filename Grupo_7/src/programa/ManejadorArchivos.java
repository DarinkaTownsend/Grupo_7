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
    public static void leerArchivoColores(String nombreArchivo){
        File fichero = new File(nombreArchivo);
        items = FXCollections.observableArrayList();  
        try (BufferedReader entrada = new BufferedReader(new FileReader(fichero))) {
            String readLine;
            while((readLine = entrada.readLine()) != null){
                String[] elementos=readLine.split(",");
                Color colorAgre = Color.web(elementos[1]);      
                ColorArchivo exten =new ColorArchivo(elementos[0],colorAgre);            
                items.add(exten);
            }
            entrada.close();
            
        } catch (FileNotFoundException exFNF) {
            System.err.println(exFNF.getMessage());
        } catch (IOException exIO) {
            System.err.println(exIO.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        
        
    }
    
    public static void escribirArchivoColores(String nombreArchivo, ColorArchivo color) {
        Color colorA = color.getColorExtension();
        String ColorHexa = sacarExtension(colorA);
        String exte = color.getExtension();
        String linea = exte + "," + ColorHexa;
        try (BufferedWriter escri = new BufferedWriter(new FileWriter(nombreArchivo,true))) {

            escri.write(linea+"\n");
            escri.close();
            // Escribimos linea a linea en el fichero

        } catch (FileNotFoundException ex2) {
            System.out.println("Mensaje error 2: " + ex2.getMessage());
        } catch (IOException a) {
            System.out.println(a.getCause());
        }
    }
    public static String sacarExtension(Color color) {
        int r = ((int) Math.round(color.getRed() * 255)) << 24;
        int g = ((int) Math.round(color.getGreen() * 255)) << 16;
        int b = ((int) Math.round(color.getBlue() * 255)) << 8;
        int a = ((int) Math.round(color.getOpacity() * 255));
        return String.format("#%08X", (r + g + b + a));
    }
    
    public static void RefrescarArchivo(String nombreArchivo){
        
        
        try (BufferedWriter escri = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (ColorArchivo co : items) {
                Color colorA = co.getColorExtension();
                String ColorHexa = sacarExtension(colorA);
                String exte = co.getExtension();
                String linea = exte + "," + ColorHexa;
                escri.write(linea + "\n");
            }
            
            escri.close();
            // Escribimos linea a linea en el fichero

        } catch (FileNotFoundException ex2) {
            System.out.println("Mensaje error 2: " + ex2.getMessage());
        } catch (IOException a) {
            System.out.println(a.getCause());
        }
    }
    }
