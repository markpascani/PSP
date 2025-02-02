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
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Mihai Stinga
 */
public class Servidor {
    public static void main(String[] args){
        final int PUERTO = 12345;
        
        try(ServerSocket serverSocket = new ServerSocket(PUERTO);
                Socket socketCliente = serverSocket.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
                PrintWriter pw = new PrintWriter(socketCliente.getOutputStream(), true)){
            
            
            int numero;
            System.out.println("Cliente conectado.");
            numero = Integer.parseInt(reader.readLine());
            
            System.out.println("Recibido el numero -> "+numero);
            
            for(int i = numero; i>= 0; i--){
                pw.println(i);
            }
            
            System.out.println("\nTerminado de enviar numeros.");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
