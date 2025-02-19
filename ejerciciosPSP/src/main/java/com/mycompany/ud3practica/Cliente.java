/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ud3practica;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author mihai
 */
public class Cliente {

    public static int PUERTO = 12345;
    public static String SERVIDOR = "localhost";

    public static void main(String[] args) {
        //Creamos el socket y conectamos al servidor
        try (Socket socket = new Socket(SERVIDOR, PUERTO); InputStream is = socket.getInputStream(); BufferedReader reader = new BufferedReader(new InputStreamReader(is)); OutputStream os = socket.getOutputStream(); PrintWriter pw = new PrintWriter(os, true)) {
            //Enviamos una operacion al servidor (5 + 3)
            String operacion = args.toString();
            pw.print(operacion);
            System.out.println("Operacion enviada al servidor...");
            //Recibe el resultado y lo imprime 
            while(true){
                String respuesta = reader.readLine();
                if(respuesta != null){
                    System.out.println(respuesta);
                    break;
                }
                System.out.println("Esperando respuesta...");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
