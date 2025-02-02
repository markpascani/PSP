/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud3list1ej4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Mihai Stinga
 */
public class Receptor {
    public static void main (String[] args){
        final int PUERTO = 12345;
        
        
        try(ServerSocket serverSocket = new ServerSocket(PUERTO)){
            System.out.println("ESperando conexion en el puerto: "+PUERTO);
            
            try(Socket socket = serverSocket.accept();
                    InputStream is = socket.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is))){
                
                System.out.println("Cliente conectado. Recibiendo archivo...");
                
                String linea; 
                while((linea= reader.readLine())!=null){
                    System.out.println(linea);
                }
                
                System.out.println("\nARchivo recibido correctamente.");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
