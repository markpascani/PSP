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
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Mihai Stinga
 */
public class Cliente {

    public static void main(String[] args) {
        // Dirección del servidor (localhost se refiere a la misma máquina).
        String host = "localhost";
        // Puerto en el que se comunicará con el servidor.
        int puerto = 5000;

        // Uso de un bloque try-with-resources para cerrar recursos automáticamente.
        try (
                // Establece la conexión al servidor.
                Socket socket = new Socket(host, puerto); // BufferedReader para leer las respuestas del servidor.
                 BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream())); // PrintWriter para enviar mensajes al servidor.
                 PrintWriter salida = new PrintWriter(socket.getOutputStream(), true); // BufferedReader para leer mensajes desde el teclado.
                 BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in))) {
            // Mensaje de confirmación de conexión.
            System.out.println("Conectado al servidor en " + host + ":" + puerto);

            // Bucle infinito para enviar y recibir mensajes.
            String mensaje;
            while (true) {
                // Solicita al usuario que introduzca un mensaje.
                System.out.print("Introduce cadena: ");
                mensaje = teclado.readLine();

                // Si el usuario introduce "salir" o deja el mensaje vacío, finaliza la conexión.
                if (mensaje == null || mensaje.equalsIgnoreCase("salir")) {
                    System.out.println("Finalizando conexión.");
                    break;
                }

                // Envía el mensaje al servidor.
                salida.println(mensaje);

                // Lee la respuesta del servidor.
                String respuesta = entrada.readLine();
                // Muestra la respuesta recibida.
                System.out.println(">> " + respuesta);
            }

        } catch (IOException e) {
            // Captura y muestra errores relacionados con la entrada/salida.
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}
