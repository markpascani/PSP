/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud3list1ej4;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Mihai Stinga
 */
public class Emisor {
    public static void main(String[] args){
        final String SERVIDOR = "localhost";
        final int PUERTO = 12345;
        final String ruta_archivo = "contabilidad.txt";
        
        try(Socket socket = new Socket(SERVIDOR, PUERTO);
                FileInputStream fis = new FileInputStream(ruta_archivo);
                BufferedInputStream bis = new BufferedInputStream(fis);
                OutputStream os = socket.getOutputStream()){
            
            System.out.println("Conectado a : "+ SERVIDOR+":"+PUERTO);
            byte[] buffer = new byte[4096]; //Creamos un buffer para leer 4kb de archivo y hacer mas rapida la lectura
            int bytesRead;
            
            while((bytesRead = bis.read(buffer)) != -1){
                os.write(buffer,0,bytesRead); //Escribimos solo la parte valida del buffer (del  0 a los bytes leidos)
            }
            
            System.out.println("Archivo enviado correctamente.");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
