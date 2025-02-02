/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciospsp.ud3list1ej1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
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
        try {
            // Mensaje para indicar la creación del servidor.
            System.out.println("Creación del socket servidor.");

            // Creación de un socket servidor para escuchar conexiones.
            ServerSocket serverSocket = new ServerSocket();

            // Mensaje indicando que se está configurando el servidor.
            System.out.println("Realización de bind.");

            // Asocia el servidor a una dirección IP y un puerto específicos.
            InetSocketAddress iSA = new InetSocketAddress("localhost", 5000);
            serverSocket.bind(iSA);

            // Mensaje para indicar que el servidor está esperando conexiones.
            System.out.println("Espera a que llegue una petición de socket.");

            // Acepta una conexión entrante de un cliente.
            try (Socket clienteSocket = serverSocket.accept(); 
                     BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream())); // Prepara un BufferedReader para leer los mensajes del cliente.
                     PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(), true)// Prepara un PrintWriter para enviar respuestas al cliente.
                    
                    ) {

                // Mensaje indicando que el cliente está conectado.
                System.out.println("Cliente conectado.");
                String mensaje;

                // Bucle para procesar los mensajes recibidos del cliente.
                while ((mensaje = entrada.readLine()) != null) {
                    // Muestra el mensaje recibido en la consola.
                    System.out.println("Recibiendo: " + mensaje);

                    // Envía una respuesta al cliente con un prefijo "ECO".
                    salida.println("ECO: " + mensaje);
                }

                // Mensaje indicando que el cliente se ha desconectado.
                System.out.println("Cliente desconectado.");
            }

        } catch (IOException ex) {
            // Registra cualquier error relacionado con entradas/salidas.
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
