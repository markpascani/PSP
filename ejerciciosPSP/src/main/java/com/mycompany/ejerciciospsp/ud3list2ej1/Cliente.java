/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud3list2ej1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Mihai Stinga
 */
public class Cliente {
    public static void main (String[] args){
        final int PUERTO = 12345;
        final String SERVIDOR = "localhost";
        Scanner sc = new Scanner(System.in);
        try(Socket socket = new Socket(SERVIDOR, PUERTO);
                OutputStream os = socket.getOutputStream();
                InputStream is = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                PrintWriter pw = new PrintWriter(os, true)
                ){
            System.out.println("Cliente iniciado...");
            String mensaje;
            while(true){
                System.out.println("Escribe algo para enviarlo al servidor...");
                mensaje = sc.nextLine();

                
                pw.println(mensaje);
                System.out.println("Enviado el mensaje al servidor...");
                String linea;
                while((linea = reader.readLine()) != null){
                    if(linea.isEmpty()) break;
                    System.out.println(linea);
                }
                System.out.println("Recibido el mensaje del servidor...");
                                
                if(mensaje.equalsIgnoreCase("salir")){
                    break;
                }
            }
            System.out.println("Terminando proceso cliente...");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
