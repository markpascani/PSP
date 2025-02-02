/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud3list1ej5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Mihai Stinga
 */
public class Cliente {
    public static void main(String[] args){
        final int PUERTO = 12345;
        final String SERVIDOR = "localhost";
        
        try(Socket socket = new Socket(SERVIDOR, PUERTO);
                OutputStream os = socket.getOutputStream();
                PrintWriter pw = new PrintWriter(os,true);
                InputStream is = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is))){
            
            int numero = 1000;//numero par ala cuenta atras
            
            pw.println(numero); //pasa el numero al servidor
            System.out.println("numero enviado.");
            String linea;
            while((linea = reader.readLine())!= null){
                System.out.println(linea);
            }
            
            System.out.println("\nTerminada la cuenta atras.");
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
}
