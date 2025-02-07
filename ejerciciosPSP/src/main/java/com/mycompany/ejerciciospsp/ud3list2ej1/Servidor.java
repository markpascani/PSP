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
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Mihai Stinga
 */
public class Servidor {
    public static void main (String[] args){
        int mensajesRecibidos = 0; 
        int longitudDelMensajeRecibido = 0;
        final int PUERTO = 12345;
        System.out.println("Iniciando servidor...");
        try(ServerSocket serverSocket = new ServerSocket(PUERTO);
                Socket clienteSocket = serverSocket.accept();
                InputStream is = clienteSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                OutputStream os = clienteSocket.getOutputStream();
                PrintWriter pw = new PrintWriter(os,true)
                ){
            System.out.println("Cliente conectado...");
            String linea;
            while(true){
                linea = reader.readLine();
                mensajesRecibidos++;
                longitudDelMensajeRecibido = linea.length();
                System.out.println("Mensaje recibido del cliente....");
                StringBuilder sb = new StringBuilder();
                sb.append(linea).append("\n").append("Mensajes recibido -> ").append(mensajesRecibidos).append("\n").append("Longitud del mensaje recibido ->").append(longitudDelMensajeRecibido);
                
                pw.println(sb.toString());
                System.out.println("Mensaje devuelto al cliente...");
                if(linea.equalsIgnoreCase("salir")) break;
            }
            System.out.println("Cliente desconectado...");
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Servidor cerrado...");
    }
}
