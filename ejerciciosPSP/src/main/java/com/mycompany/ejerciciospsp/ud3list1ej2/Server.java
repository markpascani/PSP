/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud3list1ej2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mihai Stinga
 */
public class Server {

    public static void main(String[] args) {
        final int PUERTO = 12345;
        int contadorClientes = 0;
        final int MAX_CLIENTES = 4;

        try {
            System.out.println("Creacion del socket servidor");
            //Creacion de un socker servidor para escuchar
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            System.out.println("Espera que llegue una peticion de socket");

            while (contadorClientes < MAX_CLIENTES) {
                try (Socket clienteSocket = serverSocket.accept(); 
                        BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream())); 
                        PrintWriter pw = new PrintWriter(clienteSocket.getOutputStream())) {
                    contadorClientes++;
                    // Mensaje indicando que el cliente está conectado.
                    System.out.println("Cliente conectado. Cliente ->  " + contadorClientes);
                    String mensaje;
                    
                    
                    pw.println("Hola cliente "+contadorClientes);
                    if (contadorClientes >= 3) {
                        System.out.println("Servidor ha atendido 3 clientes. Cerrando...");
                        break;
                    }
                    // Mensaje indicando que el cliente se ha desconectado.
                    System.out.println("Cliente desconectado.");

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
